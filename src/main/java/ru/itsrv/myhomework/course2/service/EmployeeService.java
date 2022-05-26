package ru.itsrv.myhomework.course2.service;


import ru.itsrv.myhomework.course2.entity.Employee;

import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, String patronymic, Integer salary, Integer department);
    Employee deleteEmployee(String firstName, String lastName,String patronymic);
    Employee findEmployee(String firstName, String lastName, String patronymic);
    Optional<Employee> findById(Long id);
}
