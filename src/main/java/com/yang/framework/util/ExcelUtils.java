package com.yang.framework.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yang.framework.config.SystemConstants;

public class ExcelUtils {

	public String build2007LaterExcel(String[] title, Object[][] data)
			throws Exception {
		Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("数据");

		// 创建一行并放一些单元格到该行中，行的索引是以0开始的
		Row row = sheet.createRow((short) 0);
		// 填充标题
		for (int i = 0; i < title.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}

		// 填充内容
		if (data != null){
			for (int i = 0; i < data.length; i++) {
				Row dataRow = sheet.createRow((short) i + 1);

				for (int j = 0; j < data[i].length; j++) {
					Cell cell = dataRow.createCell(j);
					Object obj = data[i][j];
					if (obj == null)
						continue;
					if (obj instanceof Integer || obj instanceof Double
							|| obj instanceof Long) {
						cell.setCellValue(Double.valueOf(obj + ""));
					} else if (obj instanceof Date) {
						CellStyle cellStyle = wb.createCellStyle();
						cellStyle.setDataFormat(createHelper.createDataFormat()
								.getFormat("yyyy-MM-dd HH:mm:ss"));
						cell.setCellValue(createHelper
								.createRichTextString(((Date) obj).toString()));
						cell.setCellStyle(cellStyle);
					} else {
						cell.setCellValue(obj + "");
					}

				}
			}
		}
		
		File f = new File(SystemConstants.DOWNLOAD_DIR_REALPATH);
		
		if (!f.exists()) {
			f.mkdir();
		}
		
		f = new File(f, createExcelFileName());
		FileOutputStream fileOut = new FileOutputStream(f);
		wb.write(fileOut);
		fileOut.close();

		return f.getName();
	}
	
	public String build2007LaterExcel(String[] title, List<Object[][]> datas)
			throws Exception {
		Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		
		for (int k = 0; k < datas.size(); k++) {
			Object[][] data = datas.get(k);
			
			Sheet sheet = wb.createSheet("数据" + (k + 1));
			
			// 创建一行并放一些单元格到该行中，行的索引是以0开始的
			Row row = sheet.createRow((short) 0);
			// 填充标题
			for (int i = 0; i < title.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(title[i]);
			}
			
			// 填充内容
			if (data != null){
				for (int i = 0; i < data.length; i++) {
					Row dataRow = sheet.createRow((short) i + 1);
					
					for (int j = 0; j < data[i].length; j++) {
						Cell cell = dataRow.createCell(j);
						Object obj = data[i][j];
						if (obj == null)
							continue;
						if (obj instanceof Integer || obj instanceof Double
								|| obj instanceof Long) {
							cell.setCellValue(Double.valueOf(obj + ""));
						} else if (obj instanceof Date) {
							CellStyle cellStyle = wb.createCellStyle();
							cellStyle.setDataFormat(createHelper.createDataFormat()
									.getFormat("yyyy-MM-dd HH:mm:ss"));
							cell.setCellValue(createHelper
									.createRichTextString(((Date) obj).toString()));
							cell.setCellStyle(cellStyle);
						} else {
							cell.setCellValue(obj + "");
						}
						
					}
				}
			}
		}
		
		File f = new File(SystemConstants.DOWNLOAD_DIR_REALPATH);
		
		if (!f.exists()) {
			f.mkdir();
		}
		
		f = new File(f, createExcelFileName());
		FileOutputStream fileOut = new FileOutputStream(f);
		wb.write(fileOut);
		fileOut.close();
		
		return f.getName();
	}

	private String createExcelFileName() {
		return System.currentTimeMillis() + ".xlsx";
	}

}
