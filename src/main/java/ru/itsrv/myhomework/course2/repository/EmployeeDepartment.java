package ru.itsrv.myhomework.course2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itsrv.myhomework.course2.entity.Employee;

import java.util.List;

public interface EmployeeDepartment extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(Integer id);

//    @Query(value = "SELECT emp from Employee emp where emp.department =:id order by emp.salary desc  LIMIT 1", nativeQuery = true )
    @Query(value = "SELECT * from Employee emp where emp.department = :id order by emp.salary desc  LIMIT 1", nativeQuery = true )
    List<Employee> findEmployeeByDepartmentAndMaxSalary(@Param("id") Integer id);

    Page<Employee> findByDepartmentOrderBySalaryDesc(Integer id, Pageable pageable);

}
