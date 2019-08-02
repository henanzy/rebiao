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
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import com.hnzy.rb.pojo.Rb;

public class ExcelUtilRb {
	public static void exportExcel(List<Rb> yhInfosList,ServletOutputStream outputStream) throws IOException{
		//定义显示日期的公共格式
    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyy-MM-dd:HH:mm:ss");
    String newdate=simpleDateFormat.format(new Date());
		//创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建合并单元格对象
		CellRangeAddress cellRangeAddress=new CellRangeAddress(0,0,0,0);
		//头标题样式
		HSSFCellStyle style1 = creatCellStyleS(workbook, (short) 11);
//		 setBorderStyle(style1, BorderStyle.THIN);
		//列标题样式
		HSSFCellStyle style2 = creatCellStyle(workbook, (short) 14);

//         HSSFCellStyle setBorder = workbook.createCellStyle();
//         setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
         //创建工作表
		HSSFSheet sheet = workbook.createSheet("热表信息列表");
		//加载合并单元格对象
		sheet.addMergedRegion(cellRangeAddress);
		//设置默认列宽
		sheet.setDefaultColumnWidth(15);
		//创建行
		//创建头标题行，并设置头标题
//		HSSFRow row1 = sheet.createRow(0);
//		HSSFCell cell1 = row1.createCell(0);
		//创建题行，并设置头标题
		HSSFRow row2 = sheet.createRow(0);
		String[] titles =
		{ "用户姓名", "小区名称", "楼宇号", "单元号",  "户号", "住户号","热表地址" , "累计热量","瞬时热量","累计流量","瞬时流量", "进水温度", "回水温度", "温差","仪表状态","收费类型","工作时间 ","更新时间","热表类型","备注" };
		for (int i = 0; i < titles.length; i++)
		{
			HSSFCell cell2 = row2.createCell(i);
			//加载单元格样式
			cell2.setCellStyle(style2);
			cell2.setCellValue(titles[i]);
		}
		//操作单元格，将用户写Execl
		if(yhInfosList!=null){
			
			for(int j=0;j<yhInfosList.size();j++){
			HSSFRow row =sheet .createRow(j+1);
			HSSFCell c1=row.createCell(0);
			c1.setCellStyle(style1);//设置的宽度和高度一定要带入
			
			if(yhInfosList.get(j).getYh().getYhName()==null){
				c1.setCellValue("");
			}else{
				c1.setCellValue(yhInfosList.get(j).getYh().getYhName());
			}
			HSSFCell c2=row.createCell(1);
			if(yhInfosList.get(j).getYh().getXqName()==null){
				c2.setCellValue("");
			}else{
				c2.setCellStyle(style1);//设置的宽度和高度一定要带入
				c2.setCellValue(yhInfosList.get(j).getYh().getXqName());	
			}
			HSSFCell c3=row.createCell(2);
			if(yhInfosList.get(j).getYh().getRbLyName()==null){
				c3.setCellValue("");
			}else{
				c3.setCellStyle(style1);//设置的宽度和高度一定要带入
				c3.setCellValue(yhInfosList.get(j).getYh().getRbLyName());
			}
			
			HSSFCell c4=row.createCell(3);
			if(yhInfosList.get(j).getYh().getCellNO()==null){
				
			}else{
				c4.setCellStyle(style1);//设置的宽度和高度一定要带入
				c4.setCellValue(yhInfosList.get(j).getYh().getCellNO());
			}
			
			HSSFCell c5=row.createCell(4);
			if(yhInfosList.get(j).getYh().getHouseNO()==null){
				
			}else{
				c5.setCellStyle(style1);//设置的宽度和高度一定要带入
				c5.setCellValue(yhInfosList.get(j).getYh().getHouseNO());
			}
		
			HSSFCell c6=row.createCell(5);
			if(yhInfosList.get(j).getYh().getResNum()==null){
				
			}else{
				c6.setCellStyle(style1);//设置的宽度和高度一定要带入
				c6.setCellValue(yhInfosList.get(j).getYh().getResNum());
			}
			
			HSSFCell c20=row.createCell(6);
			if(yhInfosList.get(j).getRbAd()==null){
				c20.setCellValue("");
			}else{
				c20.setCellStyle(style1);//设置的宽度和高度一定要带入
				c20.setCellValue(yhInfosList.get(j).getRbAd());
			}
			HSSFCell c7=row.createCell(7);
			if(yhInfosList.get(j).getEnergy()==null){
				c7.setCellValue("");
			}else{
				c7.setCellStyle(style1);//设置的宽度和高度一定要带入
				c7.setCellValue(yhInfosList.get(j).getEnergy());
			}
			HSSFCell c8=row.createCell(8);
			if(yhInfosList.get(j).getPower()==null){
				c8.setCellValue("");
			}else{
				c8.setCellStyle(style1);//设置的宽度和高度一定要带入
				c8.setCellValue(yhInfosList.get(j).getPower());
			}
		
			HSSFCell c9=row.createCell(9);
			c9.setCellStyle(style1);//设置的宽度和高度一定要带入
			if(yhInfosList.get(j).getEnergyLj()==null){
				c9.setCellValue("");
			}else{
				c9.setCellValue(yhInfosList.get(j).getEnergyLj());	
			}
		
			HSSFCell c10=row.createCell(10);
			if(yhInfosList.get(j).getFlow()==null){
				c10.setCellValue("");
			}else{
				c10.setCellStyle(style1);//设置的宽度和高度一定要带入
				c10.setCellValue(yhInfosList.get(j).getFlow());
			}
			
			HSSFCell c11=row.createCell(11);
			if(yhInfosList.get(j).getInTmp()==null){
				c11.setCellValue("");
			}else{
				c11.setCellStyle(style1);//设置的宽度和高度一定要带入
				c11.setCellValue(yhInfosList.get(j).getInTmp());
			}
			
			HSSFCell c12=row.createCell(12);
			if(yhInfosList.get(j).getOutTmp()==null){
				c12.setCellValue("");
			}else{
				c12.setCellStyle(style1);//设置的宽度和高度一定要带入
				c12.setCellValue(yhInfosList.get(j).getOutTmp());	
			}

			HSSFCell c13=row.createCell(13);
			if(yhInfosList.get(j).getDiffTmp()!=null){
			c13.setCellStyle(style1);//设置的宽度和高度一定要带入
			c13.setCellValue(yhInfosList.get(j).getDiffTmp());
			}else{
				c13.setCellValue("");
			}
			HSSFCell c14=row.createCell(14);
			if(yhInfosList.get(j).getStatus()!=null){
				c14.setCellStyle(style1);//设置的宽度和高度一定要带入
				c14.setCellValue(yhInfosList.get(j).getStatus());
			}else{
				c14.setCellValue("");
			}
			HSSFCell c15=row.createCell(15);
			c15.setCellStyle(style1);//设置的宽度和高度一定要带入
			if(yhInfosList.get(j).getYh().getRbfl()==0){

				c15.setCellValue("流量");
			}else if(yhInfosList.get(j).getYh().getRbfl()==1){
				c15.setCellValue("面积");
			}else{
				c15.setCellValue("");
			}
			HSSFCell c16=row.createCell(16);
			if(yhInfosList.get(j).getOperTime()==null){
				c16.setCellValue("");
			}else{
				c16.setCellStyle(style1);//设置的宽度和高度一定要带入
				c16.setCellValue(yhInfosList.get(j).getOperTime());
			}
		
			HSSFCell c17=row.createCell(17);
			c17.setCellStyle(style1);//设置的宽度和高度一定要带入
			if(yhInfosList.get(j).getRecordTime()==null){
				c17.setCellValue("");
			}else{
				c17.setCellValue(simpleDateFormat.format(yhInfosList.get(j).getRecordTime()));	
			}
			
		/*	HSSFCell c18=row.createCell(17);
			c18.setCellStyle(style1);//设置的宽度和高度一定要带入
			if(yhInfosList.get(j).getReadMTime()==null){
				c18.setCellValue("");
			}else{
				c18.setCellValue(yhInfosList.get(j).getReadMTime());	
			}*/
			HSSFCell c18=row.createCell(18);
			if(yhInfosList.get(j).getRbType()==null){
				c18.setCellValue("");
			}else{
				c18.setCellValue(yhInfosList.get(j).getRbType());
			}
			
			HSSFCell c19=row.createCell(19);
			if(yhInfosList.get(j).getBz()==null){
				c19.setCellValue("");
			}else{
				c19.setCellValue(yhInfosList.get(j).getBz());
			}
			}
		}
		workbook.write(outputStream);
		workbook.close();
	}
	private static HSSFCellStyle creatCellStyleS(HSSFWorkbook workbook, short fontSize)
	{
		HSSFCellStyle style=workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);//水平居中
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_LEFT);//垂直居中
		//创建字体
		HSSFFont font=workbook.createFont();
		font.setFontHeightInPoints(fontSize);
		//加载字体
		style.setFont(font);
		
		return style;
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
