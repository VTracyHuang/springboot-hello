package com.example.demo.util.excel;

import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * created by huangyating
 *
 * @Date 2020/11/14
 */
public class ExcelUtil {
    /**
     * @Description:
     *     文件下载
     * @param fileName
     * @param response
     * @param workbook
     * @return void
     * @author huangyating
     * @date 2020/11/13
     */
    public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            // throw new NormalException(e.getMessage());
        }
    }

}
