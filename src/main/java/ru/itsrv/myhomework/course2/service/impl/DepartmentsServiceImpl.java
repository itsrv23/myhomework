package ru.itsrv.myhomework.course2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itsrv.myhomework.course2.entity.Employee;
import ru.itsrv.myhomework.course2.exceptions.EmployeeNotFoundException;
import ru.itsrv.myhomework.course2.repository.EmployeeDepartment;
import ru.itsrv.myhomework.course2.repository.EmployeeRepository;
import ru.itsrv.myhomework.course2.service.DepartmentsService;

import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private EmployeeDepartment repository;


    @Override
    public Employee getMaxSalaryEmployeeByDepartment(Integer departmentId) {
        Page<Employee> page = repository.findByDepartmentOrderBySalaryDesc(departmentId, PageRequest.of(0, 1));
        return page.stream().findFirst().orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getMixSalaryEmployeeByDepartment(Integer departmentId) {
        return null;
//
//        return employeeService.getEmployeeBookMap()
//                .values()
//                .stream()
//                .filter(e -> e.getDepartment().equals(departmentId))
//                .collect(Collectors.toList())
//                .stream().min(Comparator.comparingInt(Employee::getSalary))
//                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getAllEmployeeByDepartment(Integer departmentId) {
        return repository.findByDepartment(departmentId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll();
//        return new ArrayList<>(employeeService.getEmployeeBookMap().values());
    }
}
