package com.talkyoung.simpro.controller;

import com.talkyoung.simcommon.CommonResult;
import com.talkyoung.simpojo.entity.Student;
import com.talkyoung.simpro.service.StudentService;
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

    @RequestMapping(method = RequestMethod.GET)
    public CommonResult<List<Student>> getByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){

        return null;
    }
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public CommonResult<List<Student>> getAll(){
        List<Student> studentList = studentService.getAll();
        return CommonResult.success(studentList);
    }
}
