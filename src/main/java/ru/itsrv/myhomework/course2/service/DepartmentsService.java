package ru.itsrv.myhomework.course2.service;

import ru.itsrv.myhomework.course2.entity.Employee;

import java.util.List;

public interface DepartmentsService {
    List<Employee> getMaxSalaryEmployeeByDepartment(Integer departmentId);
    List<Employee> getMixSalaryEmployeeByDepartment(Integer departmentId);
    List<Employee> getAllEmployeeByDepartment(Integer departmentId);
    List<Employee> getAllEmployee();
}
