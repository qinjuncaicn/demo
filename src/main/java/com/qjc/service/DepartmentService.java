package com.qjc.service;

import com.qjc.model.Department;
import com.qjc.utils.DatatablesView;

import java.util.List;

/**
 * @author
 * @description: ${DESCRIPTION}
 * @create 2018/04/21 10:53
 */
public interface DepartmentService {


    List<Department> selectAll();
}
