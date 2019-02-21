package com.itheima.bos.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.entity.Region;
import com.itheima.bos.entity.Subarea;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.utils.FileUtils;
import com.itheima.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
	@Resource
	private ISubareaService subareaService;
	public String add() throws Exception {
		subareaService.save(model);
		return "list";
	}
	
	public String pageQuery() throws Exception {
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		String addresskey = model.getAddresskey();
		if(StringUtils.isNotBlank(addresskey)){
			dc.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		Region region = model.getRegion();
		if(region!=null){
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			dc.createAlias("region", "r");
			if(StringUtils.isNotBlank(province)){
				//多表关联查询，使用别名
				dc.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)){
				dc.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)){
				dc.add(Restrictions.like("r.district", "%"+district+"%"));
			}
		}
		subareaService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","decidedzone","subareas"});
		return NONE;
	}

	public String exportXml() throws Exception {
		List<Subarea> list = subareaService.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("分区数据");
		HSSFRow headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("省");
		headRow.createCell(2).setCellValue("市");
		headRow.createCell(3).setCellValue("区");
		headRow.createCell(4).setCellValue("关键字");
		headRow.createCell(5).setCellValue("起始号");
		headRow.createCell(6).setCellValue("终止号");
		headRow.createCell(7).setCellValue("单双号");
		headRow.createCell(8).setCellValue("位置");
		for (Subarea subarea : list) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getRegion().getProvince());
			dataRow.createCell(2).setCellValue(subarea.getRegion().getCity());
			dataRow.createCell(3).setCellValue(subarea.getRegion().getDistrict());
			dataRow.createCell(4).setCellValue(subarea.getAddresskey());
			dataRow.createCell(5).setCellValue(subarea.getStartnum());
			dataRow.createCell(6).setCellValue(subarea.getEndnum());
			dataRow.createCell(7).setCellValue("0".equals(subarea.getSingle())?"单双号":("1".equals(subarea.getSingle())?"单号":"双号"));
			dataRow.createCell(8).setCellValue(subarea.getPosition());
		}
		//一个流两个头
		String filename = "分区数据.xls";
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		ServletActionContext.getResponse().setContentType(contentType);
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		String encodeDownloadFilename = FileUtils.encodeDownloadFilename(filename, agent);
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;fileName="+encodeDownloadFilename);
		workbook.write(out);
		return NONE;
	}
	public String listajax(){
		List<Subarea> list = subareaService.findListNotAssociation();
		this.java2Json(list, new String[]{"region","decidedzone","startnum","endnum","single"});
		return NONE;
	}

	public String findListByDecidedzoneId() throws Exception {
		List<Subarea> list = subareaService.findListByDecidedzoneId(model.getDecidedzone().getId());
		this.java2Json(list, new String[]{"decidedzone","subareas"});
		return NONE;
	}

	public String findSubareasGroupByProvince() throws Exception {
		List<Object> list = subareaService.findSubareasGroupByProvince();
		this.java2Json(list, new String[]{});
		return NONE;
	}
	
}
