package com.fullstack.electricity.bill.Model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Bill")
@Table(name = "electricity_bills")
public class Bill {

    @Id
    @SequenceGenerator(
            name = "bill_sequence",
            sequenceName = "bill_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"
    )
    @Column(name = "bill_id", updatable = false)
    private Long bill_id;

    @Column(name = "consumer_id")
    private String consumer_id;

    @Column(name = "consumer_name")
    private String consumer_name;

    @Column(name = "unit_consumed")
    private Long unit_consumed;

    @Column(name = "amount")
    private Long Amount;

    @Column(name = "bill_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bill_date;

    @Column(name = "paid_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date paid_date;

    @Column(name = "paid")
    private Boolean paid;

    public Bill() {
    }

    public Long getBill_id() {
        return bill_id;
    }

    public void setBill_id(Long bill_id) {
        this.bill_id = bill_id;
    }

    public String getConsumer_id() {
        return consumer_id;
    }

    public void setConsumer_id(String consumer_id) {
        this.consumer_id = consumer_id;
    }

    public String getConsumer_name() {
        return consumer_name;
    }

    public void setConsumer_name(String consumer_name) {
        this.consumer_name = consumer_name;
    }

    public Long getUnit_consumed() {
        return unit_consumed;
    }

    public void setUnit_consumed(Long unit_consumed) {
        this.unit_consumed = unit_consumed;
    }

    public Long getAmount() {
        return Amount;
    }

    public void setAmount(Long amount) {
        Amount = amount;
    }

    public Date getBill_date() {
        return bill_date;
    }

    public void setBill_date(Date bill_date) {
        this.bill_date = bill_date;
    }

    public Date getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(Date paid_date) {
        this.paid_date = paid_date;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Bill{" +
                ", consumer_id='" + consumer_id + '\'' +
                ", consumer_name='" + consumer_name + '\'' +
                ", unit_consumed=" + unit_consumed +
                ", Amount=" + Amount +
                ", bill_date=" + bill_date +
                ", paid_date=" + paid_date +
                ", paid=" + paid +
                '}';
    }
}
