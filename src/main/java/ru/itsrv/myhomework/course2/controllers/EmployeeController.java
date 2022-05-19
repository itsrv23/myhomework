package ru.itsrv.myhomework.course2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itsrv.myhomework.course2.entity.Employee;
import ru.itsrv.myhomework.course2.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/find")
    public Employee findEmployee(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "patronymic") String patronymic
    ) {
        return employeeService.findEmployee(firstName, lastName, patronymic);
    }

    @GetMapping(value = "/find/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/add")
    public Employee addEmployee(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "patronymic") String patronymic,
            @RequestParam(name = "salary") Integer salary,
            @RequestParam(name = "department") Integer department
    ) {
        return employeeService.addEmployee(firstName, lastName, patronymic, salary, department);
    }

    @GetMapping("/remove")
    public Employee deleteEmployee(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "patronymic") String patronymic
    ) {
        return employeeService.deleteEmployee(firstName, lastName, patronymic);
    }

    @GetMapping()
    public String employee() {
        return "<br>" +
                "1. По адресу /employee/add?firstName=Ivan&lastName=Ivanov&patronymic=Ivanovich должен вернуться объект Employee в формате JSON, т. е. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\" ... }, или исключение со статусом 500 Internal Server Error в случае переполнения массива или 400 Bad Request в случае, когда сотрудник уже существует.\n" +
                "<br>" +
                "2. По адресу /employee/remove?firstName=Ivan&lastName=Ivanov&patronymic=Ivanovich должен вернуться объект Employee в формате JSON, т. е. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\"... }, или исключение со статусом 404 Not Found, если сотрудник отсутствует.\n" +
                "<br>" +
                "3. По адресу /employee/find?firstName=Ivan&lastName=Ivanov&patronymic=Ivanovich должен вернуться объект Employee в формате JSON, т. е. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\" ...}, или исключение со статусом 404 Not Found, если такой сотрудник отсутствует.\n";
    }

}
