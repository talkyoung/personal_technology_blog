package com.talkyoung.ptbpro.service;

import com.talkyoung.ptbpojo.entity.Student;
import com.talkyoung.ptbpojo.entity.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getAll();

    List<Student> selectByPage(Student student,Integer pageNum,Integer pageSize);
}
