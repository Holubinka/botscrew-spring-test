package com.holubinka.dao;

import com.holubinka.model.Departs;

import java.util.List;

public interface DepartmentInformationDao {

    List<Departs> getAll();

    Departs getHeadOfDepartment(String headOfDepart);

    Long getDepartDegreeCount(String degree, String departName);

    Double getAverageSalary(String departName);

    Long getEmployeesCount(String departName);

    List<String> search(String name);
}
