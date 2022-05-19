package ru.itsrv.myhomework.course2.service;

import ru.itsrv.myhomework.course2.entity.Employee;

import java.util.List;

public interface DepartmentsService {
    Employee getMaxSalaryEmployeeByDepartment(Integer departmentId);
    Employee getMixSalaryEmployeeByDepartment(Integer departmentId);
    List<Employee> getAllEmployeeByDepartment(Integer departmentId);
    List<Employee> getAllEmployee();
}
