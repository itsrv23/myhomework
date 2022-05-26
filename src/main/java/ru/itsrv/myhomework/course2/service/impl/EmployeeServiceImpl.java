package ru.itsrv.myhomework.course2.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itsrv.myhomework.course2.entity.Employee;
import ru.itsrv.myhomework.course2.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements ru.itsrv.myhomework.course2.service.EmployeeService {

    private static final Logger logger  = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addEmployee(String firstName, String lastName, String patronymic, Integer salary, Integer department) {
        System.out.println("sout in console");
        logger.info("info in logger ");
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
//    public Employee findById(Long id) {
//        return repository.findById(id).orElseThrow(EmployeeNotFoundException::new);
//    }
    public Optional<Employee>  findById(Long id) {
        return repository.findById(id);
    }


}

