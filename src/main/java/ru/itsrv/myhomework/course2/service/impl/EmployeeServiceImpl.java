package ru.itsrv.myhomework.course2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itsrv.myhomework.course2.entity.Employee;
import ru.itsrv.myhomework.course2.exceptions.EmployeeNotFoundException;
import ru.itsrv.myhomework.course2.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements ru.itsrv.myhomework.course2.service.EmployeeService {

//    private final Map<String, Employee> employeeBookMap;

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getEmployeeBookMap() {
        return repository.findAll();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName, String patronymic, Integer salary, Integer department) {
        return repository.save(new Employee(firstName, lastName, patronymic, salary, department));
    }


    @Override
    public Employee deleteEmployee(String firstName, String lastName, String patronymic) {
        return  repository.deleteByFirstNameAndLastNameAndPatronymic(firstName, lastName, patronymic);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, String patronymic) {
        return repository.findByFirstNameAndLastNameAndPatronymic(firstName, lastName, patronymic);
    }

    @Override
    public Employee findById(Long id) {
        return repository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }


}

