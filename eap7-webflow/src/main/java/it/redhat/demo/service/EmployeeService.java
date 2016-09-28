package it.redhat.demo.service;

import it.redhat.demo.domain.Employee;
import org.springframework.stereotype.Service;

/**
 * Created by fabio on 27/09/16.
 */
@Service
public class EmployeeService {

    public Employee create() {

        return new Employee("Fabio Massimo", "Ercoli");

    }

}
