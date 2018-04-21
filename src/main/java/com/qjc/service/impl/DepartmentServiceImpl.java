package com.qjc.service.impl;

import com.qjc.mapper.DepartmentMapper;
import com.qjc.model.Department;
import com.qjc.service.DepartmentService;
import com.qjc.utils.DatatablesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description: 部门处理
 * @create 2018/04/21 10:54
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{


    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }
}
