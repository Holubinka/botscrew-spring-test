package com.holubinka.controller;

import com.holubinka.model.Departs;
import com.holubinka.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView vm) {
        vm.setViewName("department");
        vm.addObject("departments", departmentService.getAll());
        return vm;
    }

    @RequestMapping(value = "/departmentInfo", method = RequestMethod.GET)
    public ModelAndView getHeadOfDepartment(@RequestParam("headOfDepart") String headOfDepart, ModelAndView vm) {
        Departs departName = departmentService.getHeadOfDepartment(headOfDepart);
        vm.setViewName("departmentInfo");
        vm.addObject("department", departName);
        vm.addObject("assistCount", departmentService.getDepartDegreeCount("assistant", departName.getDepartName()));
        vm.addObject("associateProfCount", departmentService.getDepartDegreeCount("associate professor", departName.getDepartName()));
        vm.addObject("professorsCount", departmentService.getDepartDegreeCount("professor", departName.getDepartName()));
        vm.addObject("avgSalary", departmentService.getAverageSalary(departName.getDepartName()));
        vm.addObject("departCount", departmentService.getEmployeesCount(departName.getDepartName()));
        return vm;
    }

    @RequestMapping(value = "/department/search")
    public ModelAndView search(@RequestParam("name") String name, ModelAndView vm) {
        vm.setViewName("department");
        vm.addObject("departments", departmentService.getAll());
        vm.addObject("search", departmentService.search(name));
        return vm;
    }
}
