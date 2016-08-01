package it.redhat.demo.ws;

import it.redhat.demo.*;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 01/08/16
 */
@WebService(endpointInterface = "it.redhat.demo.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public ExpenseResponse findExpenses(ExpenseRequest request) {

        Expense expense = new Expense();
        expense.setAmount(new BigDecimal("10.30"));
        expense.setType("STAFF_MEAL");

        Expense expense2 = new Expense();
        expense2.setAmount(new BigDecimal("2.11"));
        expense2.setType("TAXI_LIMO");

        try {
            GregorianCalendar day = new GregorianCalendar(2016, Calendar.AUGUST, 1);
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(day);
            expense.setDay(xmlGregorianCalendar);
            expense2.setDay(xmlGregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        Employee employee = new Employee();
        employee.setCode("fercoli");
        employee.setName("Fabio Massimo");
        employee.setSurname("Ercoli");
        employee.setRank(7);

        try {
            GregorianCalendar day = new GregorianCalendar(1979, Calendar.NOVEMBER, 21);
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(day);
            employee.setBirth(xmlGregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        ExpenseResponse response = new ExpenseResponse();
        response.setEmployee(employee);
        response.getExpenses().add(expense);
        response.getExpenses().add(expense2);

        return response;

    }

}
