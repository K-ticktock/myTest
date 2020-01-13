package com.demo.test.file.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ReadExcelPOI {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    public static void main(String[] args){
//        String execlPath = "/Users/jiaozheng/Documents/Java/JavaTestFile/datadict.xls";
        String execlPath = "/Users/jiaozheng/Documents/Java/JavaTestFile/12000第九次.xls";
        try {
            File excel = new File(execlPath);
            //判断文件是否存在
            if(excel.isFile()&&excel.exists()){
                String[] split = excel.getName().split("\\.");
                Workbook wb;
                //根据文件后缀（xls/xlsx）判断
                if (EXCEL_XLS.equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);
                    wb = new HSSFWorkbook(fis);
                }else if (EXCEL_XLSX.equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误");
                    return;
                }
                //开始解析
                Sheet sheet = wb.getSheetAt(0);
                int firstRowIndex = sheet.getFirstRowNum();   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);
                //遍历打印Excel信息
                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                System.out.println(cell.toString());
                            }
                        }
                    }
                }
                //获取Excel中的函数值
                Row hrow = sheet.getRow(lastRowIndex-1);
                Cell hcell = hrow.getCell(3);
                String sss;
                try {
                    sss = String.valueOf(hcell.getNumericCellValue());
                }catch (IllegalStateException e){
                    sss = String.valueOf(hcell.getRichStringCellValue());
                }
                System.out.println(sss);
                //Excel中写入值
                for(int rIndex = 2; rIndex <lastRowIndex-1;rIndex++){
                    System.out.println("rIndex: "+ rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null){
                        System.out.println(row.getCell(0)+"---"+row.getCell(1)+"---"+row.getCell(2)+"---"+row.getCell(3));
                        Cell cell = row.createCell(4);
                        cell.setCellValue("sucess");
                    }
                }
                OutputStream outputStream = new FileOutputStream(excel);
                wb.write(outputStream);
            }else {
                System.out.println("找不到指定的文件");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
