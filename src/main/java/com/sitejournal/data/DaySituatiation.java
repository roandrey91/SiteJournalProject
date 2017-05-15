package com.sitejournal.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "daysit")
public class DaySituatiation implements Serializable {

    @Id
    @Column(name = "daysit_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String dayDate;
    private String describeDay;

    public DaySituatiation(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }

    public String getDescribe() {
        return describeDay;
    }

    public void setDescribe(String describe) {
        this.describeDay = describe;
    }

    @Override
    public String toString() {
        return "DaySituatiation{" +
                "id=" + id +
                ", dayDate='" + dayDate + '\'' +
                ", describe='" + describeDay + '\'' +
                '}';
    }
}
