package com.wenzhuo4657;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
      //  Main.writeExCEL03();
//        Main.writeExCEL07();
        batch.BatchWrite03();
    }
    public static void writeExCEL03() throws IOException {
        Workbook  h1=new HSSFWorkbook();
        Sheet sheet=h1.createSheet("03测试");

//        写入数据时，先指定行/row,从得到Row对象
        Row row=sheet.createRow(0);

//        row对象指定列，得到具体的可以执行写入操作的单元格对象cell
        Cell cell=row.createCell(0);

//     设置写入数据
        cell.setCellValue("test");

//        输出文件
        FileOutputStream output=new FileOutputStream("./03test.xls");
        h1.write(output);
        output.close();
    }

    public static void writeExCEL07() throws IOException{
        Workbook  h1=new XSSFWorkbook();
        Sheet sheet=h1.createSheet("07测试");

//        写入数据时，先指定行/row,从得到Row对象
        Row row=sheet.createRow(0);

//        row对象指定列，得到具体的可以执行写入操作的单元格对象cell
        Cell cell=row.createCell(0);

//     设置写入数据
        cell.setCellValue("test");

//        输出文件
        FileOutputStream output=new FileOutputStream("./07.xls");
        h1.write(output);
        output.close();

    }

}

class  batch{

    public  static void  BatchWrite03() throws IOException {
        long start=System.currentTimeMillis();

        Workbook  h1=new HSSFWorkbook();
        Sheet sheet=h1.createSheet("03Batch");


        for (int row=0;row<1000;row++){
            Row row1=sheet.createRow(row);
            for (int i=0;i<255;i++){
                Cell cell=row1.createCell(i);
                cell.setCellValue(i+1);
            }
        }

        FileOutputStream output=new FileOutputStream("./03Batch.xls");
        h1.write(output);
        output.close();


        long end=System.currentTimeMillis();

        System.out.println((end-start)/1000);
    }


    public static  void writeBatchSXSSF07() throws IOException {
        Workbook  h1=new SXSSFWorkbook(200);
        Sheet sheet=h1.createSheet("07BatchXSSF");


        for (int row=0;row<1000;row++){
            Row row1=sheet.createRow(row);
            for (int i=0;i<255;i++){
                Cell cell=row1.createCell(i);
                cell.setCellValue(i+1);
            }
        }

        FileOutputStream output=new FileOutputStream("./07BatchSXSSF.xlsx");
        h1.write(output);
        output.close();

    }
}
