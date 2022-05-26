package ru.itsrv.myhomework.course2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.itsrv.myhomework.course2.entity.Employee;

import java.util.List;

public interface EmployeeDepartmentRepository extends PagingAndSortingRepository<Employee, Long> {

    // Нативный запрос
    //    @Query(value = "SELECT * from Employee emp where emp.department = :id order by emp.salary desc  LIMIT 1", nativeQuery = true )
    //    List<Employee> findEmployeeByDepartmentAndMaxSalary(@Param("id") Integer id);

    @Query(value = "select testfunction()", nativeQuery = true)
    String testFunction();

    List<Employee> findByDepartment(Integer id);
    Page<Employee> findByDepartmentOrderBySalaryDesc(Integer id, Pageable pageable);
    Page<Employee> findByDepartmentOrderBySalary(Integer id, Pageable pageable);
}
