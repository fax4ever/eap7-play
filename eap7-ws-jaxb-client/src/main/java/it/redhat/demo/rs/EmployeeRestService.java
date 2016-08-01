package it.redhat.demo.rs;

import it.redhat.demo.EmployeeService;
import it.redhat.demo.EmployeeServiceService;
import it.redhat.demo.ExpenseRequest;
import it.redhat.demo.ExpenseResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 30/07/16
 */

@Path("expenses")
public class EmployeeRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ExpenseResponse findExpenses() {

        EmployeeService port = new EmployeeServiceService().getPort(EmployeeService.class);
        return port.findExpenses(new ExpenseRequest());

    }

}
