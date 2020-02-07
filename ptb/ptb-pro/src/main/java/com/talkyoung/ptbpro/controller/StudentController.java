package com.talkyoung.ptbpro.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.talkyoung.ptbcommon.CommonResult;
import com.talkyoung.ptbpojo.entity.Student;
import com.talkyoung.ptbpro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/selByPage", method = RequestMethod.GET)
    public CommonResult<List<Student>> selByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                 Student student){
        List<Student> studentList = studentService.selectByPage(student,pageNum,pageSize);
        return CommonResult.success(studentList);
    }
}
