package com.itheima.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.entity.Region;
import com.itheima.bos.service.IRegionService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.utils.PinYin4jUtils;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {
	
	private File regionFile;
	@Autowired
	private IRegionService regionService;
	private String q;
	
	public void setQ(String q) {
		this.q = q;
	}

	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	
	public String importXls() throws Exception {
		List<Region> regionList = new ArrayList<Region>();
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
		HSSFSheet hssfSheet = workbook.getSheet("Sheet1");
		for (Row row : hssfSheet) {
			int rowNum = row.getRowNum();
			if(rowNum==0){
				continue;
			}
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			Region region = new Region(id, province, city, district, postcode, null, null, null);
			
			province= province.substring(0, province.length()-1);
			city= city.substring(0, city.length()-1);
			district= district.substring(0, district.length()-1);
			String info = province+city+district;
			System.out.println(info);
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			//城市编码
			String citycode = PinYin4jUtils.hanziToPinyin(city,"");
			
			region.setShortcode(shortcode);
			region.setCitycode(citycode);
			regionList.add(region);
		}
		String f = "1";
		try {
			regionService.saveBatch(regionList);
		} catch (Exception e) {
			f="0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(f);
		return NONE;
	}

	public String pageQuery() throws Exception {
		regionService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","subareas"});
		return NONE;
	}

	public String listajax() throws Exception {
		List<Region> list = null;
		if(StringUtils.isNotBlank(q)){
			list = regionService.findListByQ(q);
		}else{
			list = regionService.findAll();
		}
		this.java2Json(list, new String[]{"subareas"});
		return NONE;
	}
	
}
