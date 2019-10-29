package com.holubinka.service;

import com.holubinka.dao.DepartmentInformationDao;
import com.holubinka.model.Departs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentInformationDao departmentDao;

    @Override
    public List<Departs> getAll() {
        return departmentDao.getAll();
    }

    @Override
    public Departs getHeadOfDepartment(String headOfDepart) {
        return departmentDao.getHeadOfDepartment(headOfDepart);
    }

    @Override
    public Long getDepartDegreeCount(String degree, String departName) {
        return departmentDao.getDepartDegreeCount(degree, departName);
    }

    @Override
    public Double getAverageSalary(String departName) {
        return departmentDao.getAverageSalary(departName);
    }

    @Override
    public Long getEmployeesCount(String departName) {
        return departmentDao.getEmployeesCount(departName);
    }

    @Override
    public List<String> search(String name) {
        return departmentDao.search(name);
    }
}
