package ru.itsrv.myhomework.course2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsrv.myhomework.course2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByFirstNameAndLastNameAndPatronymic(String firstName, String lastName, String Patronymic);
    Employee deleteByFirstNameAndLastNameAndPatronymic(String firstName, String lastName, String Patronymic);

}
