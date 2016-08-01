package it.redhat.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 01/08/16
 */
public class Expense {

    private Date day;
    private BigDecimal amount;
    private String type;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
