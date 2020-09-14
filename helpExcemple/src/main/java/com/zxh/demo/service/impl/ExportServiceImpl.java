package com.zxh.demo.service.impl;

import com.zxh.demo.service.ExportService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: znn
 * @date: 2020/09/2020/9/14
 * @description 导出周报serviceImpl
 */
@Service
public class ExportServiceImpl implements ExportService {
    /**
     * 导出一周的周报
     *
     * @return 执行结果
     */
    @Override
    public String exportOneWeek() {
        String fromPath = "E:\\testExcel\\excelModel.xls";// excel模版
        File file = new File(fromPath);
        String toPath = "E:\\testExcel\\newExcel\\znn周报.xls";//新excel存放全路径
        HSSFWorkbook wb;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(toPath);
            wb = new HSSFWorkbook(fis);
            /*填数据
            HSSFSheet fromsheet = wb.getSheetAt(0);
            Row row = fromsheet.getRow(1);
            Cell cell = row.getCell(2);
            cell.setCellValue("");*/
            HSSFSheet sheet = wb.getSheet("test");
            String name = sheet.getSheetName();
            System.out.println("name------------>" + name);
            HSSFRow row = sheet.getRow(0);
            HSSFCell cell = row.getCell(0);
            System.out.println("cell------------>" + cell);
            if (null == cell) {
                cell = row.createCell(0);
                cell.setCellValue(100);
            }
            HSSFSheet sheet2 = wb.cloneSheet(0);
            System.out.println("sheet2------------------>" + sheet.getSheetName());
            HSSFRow row2 = sheet2.getRow(0);
            HSSFCell cell2 = row2.getCell(2);
            if (null == cell2) {
                cell2 = row.createCell(2);
                cell2.setCellValue("测试数据");
            }
            wb.setSheetName(wb.getNumberOfSheets() - 1, "test2");
            HSSFSheet sheet3 = wb.createSheet("test3");
            wb.write(fos);
            fis.close();
            fos.close();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        } finally {
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String newExcel() {
        String fromPath = "E:\\testExcel\\excelModel.xls";// excel模版
        String toPath = "E:\\testExcel\\newExcel\\znn周报.xls";//新excel存放全路径
        HSSFWorkbook wb;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(fromPath);
            fos = new FileOutputStream(toPath);
            wb = new HSSFWorkbook(fis);
            /*填数据
            HSSFSheet fromsheet = wb.getSheetAt(0);
            Row row = fromsheet.getRow(1);
            Cell cell = row.getCell(2);
            cell.setCellValue("");*/
            wb.write(fos);
            fis.close();
            fos.close();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        } finally {
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
