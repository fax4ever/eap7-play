package it.redhat.demo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fabio.ercoli@redhat.com on 14/01/17.
 */

@Entity
public class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fromLocation;
    private String toLocation;

    @Temporal(TemporalType.DATE)
    private Date moment;

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    @Override
    public String toString() {
        return "MoveEntity{" +
                "id=" + id +
                ", fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", moment=" + moment +
                '}';
    }

}
