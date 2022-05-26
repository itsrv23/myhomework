package ru.itsrv.myhomework.course2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import ru.itsrv.myhomework.course2.entity.Employee;
import ru.itsrv.myhomework.course2.repository.EmployeeDepartmentRepository;
import ru.itsrv.myhomework.course2.service.DepartmentsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private EmployeeDepartmentRepository repository;


    @Override
    public List<Employee> getMaxSalaryEmployeeByDepartment(Integer departmentId) {
        return repository.findByDepartmentOrderBySalaryDesc(departmentId, PageRequest.of(0, 1))
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getMixSalaryEmployeeByDepartment(Integer departmentId) {

        return repository.findByDepartmentOrderBySalary(departmentId, PageRequest.of(0, 1))
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployeeByDepartment(Integer departmentId) {
        return repository.findByDepartment(departmentId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        System.out.println("Test Run function: " +  repository.testFunction());

        Iterable<Employee> all = repository.findAll(); // если не определяем в интерфейсе явно, то дает Iterable
        return Streamable.of(repository.findAll()).toList();
    }
}
