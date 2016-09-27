package it.redhat.demo.web;

import it.redhat.demo.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fabio on 27/09/16.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        Employee employee = new Employee("Fabio Massimo", "Ercoli");
        model.addAttribute("employee", employee);

        return "employee";

    }

}
