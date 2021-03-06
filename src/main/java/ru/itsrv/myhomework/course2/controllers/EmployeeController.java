package ru.itsrv.myhomework.course2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itsrv.myhomework.course2.entity.Employee;
import ru.itsrv.myhomework.course2.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
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

    //    @GetMapping(value = "/find/{id}")
//    public Employee findById(@PathVariable Long id) {
//        return employeeService.findById(id);
//    }
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return employeeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
                "1. ???? ???????????? /employee/add?firstName=Ivan&lastName=Ivanov&patronymic=Ivanovich ???????????? ?????????????????? ???????????? Employee ?? ?????????????? JSON, ??. ??. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\" ... }, ?????? ???????????????????? ???? ???????????????? 500 Internal Server Error ?? ???????????? ???????????????????????? ?????????????? ?????? 400 Bad Request ?? ????????????, ?????????? ?????????????????? ?????? ????????????????????.\n" +
                "<br>" +
                "2. ???? ???????????? /employee/remove?firstName=Ivan&lastName=Ivanov&patronymic=Ivanovich ???????????? ?????????????????? ???????????? Employee ?? ?????????????? JSON, ??. ??. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\"... }, ?????? ???????????????????? ???? ???????????????? 404 Not Found, ???????? ?????????????????? ??????????????????????.\n" +
                "<br>" +
                "3. ???? ???????????? /employee/find?firstName=Ivan&lastName=Ivanov&patronymic=Ivanovich ???????????? ?????????????????? ???????????? Employee ?? ?????????????? JSON, ??. ??. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\" ...}, ?????? ???????????????????? ???? ???????????????? 404 Not Found, ???????? ?????????? ?????????????????? ??????????????????????.\n";
    }

}
