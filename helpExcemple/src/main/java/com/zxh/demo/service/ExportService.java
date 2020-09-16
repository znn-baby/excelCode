package com.zxh.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author: znn
 * @date: 2020/08/2020/9/14
 * @description 导出周报service
 */
public interface ExportService {
    /**
     * 导出一周的周报
     *
     * @return 执行结果
     */
    String exportOneWeek();
    /**
     * 在excel表中新增一周的sheet
     * @return 新建一个excel
     */
    String newExcel();
    /**
     * 复制excel中的第一个sheet 复制到当前excel中
     */
    String copySheetInOneExcel();

}
