package com.example.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.model.LecturerModel;
import com.example.demo.util.excel.ExcelListener;
import com.example.demo.util.excel.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * created by huangyating
 *
 * @Date 2020/11/14
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);

    @GetMapping("/downloadTempalte")
    public void exportExcelTempalte(HttpServletResponse response){
        try{
            //Resource目录中的文件
            String filePath = "/excel/讲师新增模板.xlsx";
            ClassPathResource classPathResource = new ClassPathResource(filePath);
            Workbook workbook= WorkbookFactory.create(classPathResource.getInputStream());
            ExcelUtil.downLoadExcel("讲师新增模板.xlsx", response, workbook);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("文件下载失败,msg{}",e.getMessage());
        }
    }

    @PostMapping(value = "/importData"  )
    public String importExcelData(@RequestParam("file") MultipartFile file){
        try {
            InputStream in = file.getInputStream();
            EasyExcel.read(in, LecturerModel.class,new ExcelListener()).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    @GetMapping("/exportData")
    public String exportExcelData(){

        try {
            //实现excel写的操作
            //1 设置写入文件夹地址和excel文件名称
            ClassPathResource classPathResource = new ClassPathResource("/resources/excel/批量导出导师.xlsx");

            String filePath = classPathResource.getPath();
/*            File file = new File("/resources/excel/讲师新增模板.xlsx"); E:\resources\excel\讲师新增模板.xlsx (系统找不到指定的路径。)
            String filePath = file.getAbsolutePath();*/
            // 2 调用easyexcel里面的方法实现写操作
            // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
            EasyExcel.write(filePath,LecturerModel.class).sheet("讲师列表").doWrite(getData());
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
        return "success";
    }

    //创建方法返回list集合
    private static List<LecturerModel> getData() {
        List<LecturerModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LecturerModel data = new LecturerModel();
            data.setLecturerName("人"+i);
            data.setLecturerPhone("phone"+i);
            data.setLecturerEmail(i+"qq.com");
            data.setLecturerType("内部");
            list.add(data);
        }
        return list;
    }

}
