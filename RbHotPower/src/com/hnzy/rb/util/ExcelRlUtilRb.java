package com.hnzy.rb.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.hnzy.rb.pojo.RbrlUser;

public class ExcelRlUtilRb {
	public static void exportExcel(List<RbrlUser> yhInfosList,ServletOutputStream outputStream) throws IOException{
		//定义显示日期的公共格式
    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyy-MM-dd:HH:mm:ss");
    String newdate=simpleDateFormat.format(new Date());
		//创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建合并单元格对象
		CellRangeAddress cellRangeAddress=new CellRangeAddress(0,0,0,0);
		//头标题样式
		HSSFCellStyle style1 = creatCellStyle(workbook, (short) 14);
		//列标题样式
		HSSFCellStyle style2 = creatCellStyle(workbook, (short) 11);
		//创建工作表
		HSSFSheet sheet = workbook.createSheet("热表信息列表");
		//加载合并单元格对象
		sheet.addMergedRegion(cellRangeAddress);
		//设置默认列宽
		sheet.setDefaultColumnWidth(15);
		//创建行
		//创建头标题行，并设置头标题
		HSSFRow row1 = sheet.createRow(0);
		HSSFCell cell1 = row1.createCell(0);
		//创建题行，并设置头标题
		HSSFRow row2 = sheet.createRow(1);
		String[] titles =
		{ "姓名", "用户地址", "通道号", "热表号", "累计热量" , "瞬时流量", "流量", "功率","进水温度", "回水温度" , "温差", "实时时间" };
		for (int i = 0; i < titles.length; i++)
		{
			HSSFCell cell2 = row2.createCell(i);
			//加载单元格样式
			cell2.setCellStyle(style1);
			cell2.setCellValue(titles[i]);
		}
		//操作单元格，将用户写Execl
		if(yhInfosList!=null){
			for(int j=0;j<yhInfosList.size();j++){
			HSSFRow row =sheet .createRow(j+2);
			HSSFCell c1=row.createCell(0);
			c1.setCellValue(yhInfosList.get(j).getcLIENTNAME());
			HSSFCell c2=row.createCell(1);
			c2.setCellValue(yhInfosList.get(j).getaDDRESS());
			HSSFCell c3=row.createCell(2);
			c3.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmBUSID());
			HSSFCell c4=row.createCell(3);
			c4.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmETERID());
			HSSFCell c5=row.createCell(4);
			c5.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmETERNLLJ());
			HSSFCell c6=row.createCell(5);
			c6.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmETERTJ());
			HSSFCell c7=row.createCell(6);
			c7.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmETERLS());
			HSSFCell c8=row.createCell(7);
			c8.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmETERGL());
			HSSFCell c9=row.createCell(8);
			c9.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmETERJSWD());
			HSSFCell c10=row.createCell(9);
			c10.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmETERHSWD());
			HSSFCell c11=row.createCell(10);
			c11.setCellValue(yhInfosList.get(j).getRbUser().getRbrlInfo().getmETERWC());
			HSSFCell c12=row.createCell(11);
			c12.setCellValue(simpleDateFormat.format(yhInfosList.get(j).getRbUser().getRbrlInfo().getdDATE()));
			}
		}
		workbook.write(outputStream);
		workbook.close();
	}
	private static HSSFCellStyle creatCellStyle(HSSFWorkbook workbook, short fontSize)
	{
		HSSFCellStyle style=workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		//创建字体
		HSSFFont font=workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗字体
		font.setFontHeightInPoints(fontSize);
		//加载字体
		style.setFont(font);
		
		return style;
	}

}
