package com.talkyoung.ptbpro.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.talkyoung.ptbpojo.entity.Student;
import com.talkyoung.ptbpojo.entity.StudentExample;
import com.talkyoung.ptbpojo.mapper.StudentMapper;
import com.talkyoung.ptbpro.service.StudentService;
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

    @Override
    public List<Student> selectByPage(Student student,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if(student.getSex() != null){
            criteria.andSexEqualTo(student.getSex());
        }
        if(student.getStatus() != null){
            criteria.andStatusEqualTo(student.getStatus());
        }
        List<Student> studentlist = studentMapper.selectByExample(studentExample);
        PageInfo<Student> page = new PageInfo<Student>(studentlist);
        int totaoCount = (int)page.getTotal();
        int pageNumCount = page.getPageNum();
        return studentlist;
    }
}
