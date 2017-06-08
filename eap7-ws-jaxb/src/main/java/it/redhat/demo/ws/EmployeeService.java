package it.redhat.demo.ws;

import it.redhat.demo.model.Employee;
import it.redhat.demo.model.Expense;
import it.redhat.demo.model.ExpenseRequest;
import it.redhat.demo.model.ExpenseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 01/08/16
 */
@WebService
public class EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    public ExpenseResponse findExpenses(ExpenseRequest request) {

        LOG.info("incoming request {}", request);
        if (request!= null) {
            LOG.info("employee code {}", request.getEmployeeCode());
        }

        Expense expense = new Expense();
        expense.setAmount(new BigDecimal("10.30"));
        LocalDate localDate = LocalDate.of(2016, Month.AUGUST, 1);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        expense.setDay(date);
        expense.setType("STAFF_MEAL");

        Expense expense2 = new Expense();
        expense2.setAmount(new BigDecimal("2.11"));
        expense2.setDay(date);
        expense2.setType("TAXI_LIMO");

        ArrayList<Expense> expenses = new ArrayList<>();
        expenses.add(expense);
        expenses.add(expense2);

        Employee employee = new Employee();
        employee.setCode("fercoli");
        employee.setName("Fabio Massimo");
        employee.setSurname("Ercoli");
        LocalDate dayBirth = LocalDate.of(1979, Month.NOVEMBER, 21);
        Date birth = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        employee.setBirth(birth);
        employee.setRank(7);

        ExpenseResponse response = new ExpenseResponse();
        response.setExpenses(expenses);
        response.setEmployee(employee);

        return response;

    }

}
