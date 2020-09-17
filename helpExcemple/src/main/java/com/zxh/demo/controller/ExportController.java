package com.zxh.demo.controller;

import com.sun.xml.internal.ws.resources.WsdlmodelMessages;
import com.zxh.demo.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: znn
 * @date: 2020/09/2020/9/14
 * @description 导出周报
 */
@Controller
@RequestMapping("export")
public class ExportController {

    private final ExportService exportServiceImpl;

    @Autowired
    public ExportController(ExportService exportServiceImpl) {
        this.exportServiceImpl = exportServiceImpl;
    }

    @RequestMapping("exportOneWeek")
    public String exportOneWeek(Model model) {
        String mess = exportServiceImpl.copySheetInOneExcel();
        model.addAttribute("mess", mess);
        return "layout/exportExcel";
    }

}
