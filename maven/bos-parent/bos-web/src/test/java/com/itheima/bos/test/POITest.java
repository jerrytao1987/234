package com.itheima.bos.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class POITest {
//	@Test
	public void test1() throws Exception{
		String filePath="E:\\jerry\\文件\\区域导入测试数据.xls";
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(filePath)));
		HSSFSheet hssfSheet = workbook.getSheetAt(0);
		for (Row row : hssfSheet) {
			for (Cell cell : row) {
				String value = cell.getStringCellValue();
				System.out.print(value+"\t");
				
			}
			System.out.println();
		}
	}
}
