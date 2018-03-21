package com.youyue.test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

/**
 * Created by dllo on 18/1/31.
 */
public class ReadExcel {

    public static void main(String[] args) {

        String readFilePath = "/Users/dllo/Desktop/java/SpringMVC-02-0703/target/SpringMVC-02-0703/files/tt.xls";

        File file = new File(readFilePath);

        Workbook workbook = null;

        try {

            workbook = Workbook.getWorkbook(file);

            Sheet[] sheets = workbook.getSheets();

            for (Sheet sheet : sheets) {

                System.out.println("sheet表格: " + sheet.getName());

                int rows = sheet.getRows();

                int cols = sheet.getColumns();

//                根据行列遍历单元格内容
                for (int i = 0; i < rows; i++) {

                    for (int j = 0; j < cols; j++) {

                        Cell cell = sheet.getCell(j, i);

                        System.out.print("  " + cell.getContents() + "  ");

                    }

                    System.out.println("");

                }

                System.out.println("####");

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

    }

}
