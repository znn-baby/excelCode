package com.zxh.demo.service.impl;

import com.zxh.demo.service.ExportService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author: znn
 * @date: 2020/09/2020/9/14
 * @description 导出周报serviceImpl
 */
@Service
public class ExportServiceImpl implements ExportService {
    /**
     * 复制excel中的第一个sheet 复制到当前excel中
     */
    @Override
    public String copySheetInOneExcel() {
        String fromPath = "E:\\testExcel\\newExcel\\znn周报.xls";// excel模版
        Workbook wb;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(fromPath);
            wb = WorkbookFactory.create(fis);
            //Sheet sheet = wb.cloneSheet(0);
            //wb.setSheetName(wb.getNumberOfSheets()-1,"0917");
            //新增的语句 方便测试
            Sheet sheet = wb.getSheetAt(wb.getNumberOfSheets() - 1);
            //填日期
            Row row = sheet.getRow(3);
            Cell cell = row.getCell(10);
            cell.setCellValue("2020/9/17");
            //填星期一的日期  给合并单元格赋值 给左上角的那个单元格赋值即可
            Row monRow = sheet.getRow(6);
            Cell monCell = monRow.getCell(1);
            monCell.setCellValue("2020/9/14");
            /*//将10行以下的行下移6-4行
            sheet.shiftRows(10, sheet.getLastRowNum(), 6 - 4, true, false);
            //获取上一行的样式
            Row rowSource = sheet.getRow(9);
            CellStyle rowStyle = rowSource.getRowStyle();
            for (int i = 10; i < 12; i++) {
                Row rowInsert = sheet.createRow(i);
                if (rowStyle != null)
                    rowInsert.setRowStyle(rowStyle);
                rowInsert.setHeight(rowSource.getHeight());

                for (int col = 0; col < rowSource.getLastCellNum(); col++) {
                    Cell cellSource = rowSource.getCell(col);
                    Cell cellInsert = rowInsert.createCell(col);
                    CellStyle cellStyle = cellSource.getCellStyle();
                    //设置单元格样式
                    if (cellStyle != null)
                        cellInsert.setCellStyle(cellSource.getCellStyle());
                }
            }*/
            int num = 6;
            //填当天的日志和小时
            for (int i = 0; i < 3; i++) {
                Row wssRow = sheet.getRow(num);
                Cell wssCell = wssRow.getCell(2);
                wssCell.setCellValue("工作内容" + i + "。。。。。。。。。。。");
                Cell hourCell = wssRow.getCell(10);
                hourCell.setCellValue(i);
                num++;
            }

            fos = new FileOutputStream(fromPath);
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


    /**
     * 从模版excel复制sheet到新excel中
     *
     * @return 执行结果
     */
    @Override
    public String exportOneWeek() {
        // 1.查询数据库 循环内得到每个人的id 。。
        // 2.通过日期工具类得到今年第一周第一天到现在这周的最后一天的日期
        // 3. 根据 id 查出这个人的wss日志 3.

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
            //复制sheet
            HSSFSheet sheet2 = wb.cloneSheet(0);
            System.out.println("sheet2------------------>" + sheet.getSheetName());
            HSSFRow row2 = sheet2.getRow(0);
            HSSFCell cell2 = row2.getCell(2);
            if (null == cell2) {
                cell2 = row.createCell(2);
                cell2.setCellValue("测试数据");
            }
            //给excel中的最后一个sheet改名字
            wb.setSheetName(wb.getNumberOfSheets() - 1, "test2");
            //创建新的sheet
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
