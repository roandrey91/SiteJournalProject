package com.sitejournal.data;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Muresan Andrei
 * */

@Entity
@Table(name = "employee_review")
public class EmployeeReview {

    @Id
    @Column(name = "employee_reviw_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private Date presentDate;
    private String reviewText;
    private boolean isPresent;

    public EmployeeReview() {
    }

    public EmployeeReview(Employee employee, String reviewText, boolean isPresent, Date presentDate){
        this.employee = employee;
        this.reviewText = reviewText;
        this.isPresent = isPresent;
        this.presentDate = presentDate;
    }

    public long getId() {
        return id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getPresentDate() {
        return presentDate;
    }

    public void setPresentDate(Date presentDate) {
        this.presentDate = presentDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    @Override
    public String toString() {
        return "EmployeeReview{" +
                "id=" + id +
                ", employee=" + employee +
                ", presentDate=" + presentDate +
                ", reviewText='" + reviewText + '\'' +
                ", isPresent=" + isPresent +
                '}';
    }
}
