package com.talkyoung.simpro.serviceImpl;

import com.talkyoung.simpojo.entity.StudentExample;
import com.talkyoung.simpojo.mapper.StudentMapper;
import com.talkyoung.simpojo.entity.Student;
import com.talkyoung.simpro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public int countByExample(StudentExample example) {
        return studentMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(StudentExample example) {
        return studentMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public List<Student> selectByExample(StudentExample example) {
        return studentMapper.selectByExample(example);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Student record, StudentExample example) {
        return studentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Student record, StudentExample example) {
        return studentMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.selectByExample(null);
    }
}
