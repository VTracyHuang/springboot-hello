package com.example.demo.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * created by huangyating
 *
 * @Date 2020/11/13
 */
@Data
@EqualsAndHashCode( callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class LecturerModel extends BaseRowModel implements Serializable {

    private static final long serialVersionUID = 1L;


    @ExcelProperty(value = "姓名" ,index = 0)
    private String lecturerName;

    @ExcelProperty(value = "手机号" ,index = 1)
    private String lecturerPhone;

    @ExcelProperty(value = "邮箱" ,index = 2)
    private String lecturerEmail;

    @ExcelProperty(value = "讲师属性" ,index = 3)
    private String lecturerType;
}
