package com.hideoutlabs.inahurry.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


@Entity(name="Customer")
@Table(name="Customer",
        uniqueConstraints = {
        @UniqueConstraint(name="customer_ip_unique",columnNames = "customer_ip"),
                @UniqueConstraint(name="customer_email_unique",columnNames = "customer_email")
        }

)

public class Customer extends AppUser{
    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusFirstName='" + this.getFirstCustomerName() + '\'' +
                ", cusLastName='" + this.getLastCustomerName() + '\'' +
                ", cusIP='" + cusIP + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                '}';
    }

    @Id
    @SequenceGenerator(

            name="customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cutomer_sequence"
    )
    private  Long cusId;

    @Column( name ="cus_first_name",
            nullable=false


    )
    private  String customerFirstName;


    @Column( name ="cus_last_name",
            nullable=false,
            columnDefinition = "VARCHAR(256)"

    )
    private  String customerLastName;

    @Column( name ="customer_ip",
            nullable=false

    )
    private  String cusIP;

    @Column( name ="customer_email",
            nullable=false,
            columnDefinition = "VARCHAR(256)",
            unique=true

    )
    private  String cusEmail;

    public Customer(Long cusId, String cusFirstName,String cusLastName,String cusIP,String cusEmail){
        super();
        this.cusId=cusId;
        this.customerFirstName=cusFirstName;
        this.customerLastName=cusLastName;
        this.cusIP=cusIP;
        this.cusEmail=cusEmail;
    }

    public void setCustomerFirstName(String cusFirstName) {
        this.customerFirstName = cusFirstName;
    }

    public void setCustomerLastName(String cusLastName) {
        this.customerLastName = cusLastName;
    }

    public void setCusIP(String cusIP) {
        this.cusIP = cusIP;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getFirstCustomerName() {
        return customerFirstName;
    }

    public String getLastCustomerName() {
        return customerLastName;
    }

    public Long getCusId() {
        return cusId;
    }

    public String getCusIP() {
        return cusIP;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public Customer(){

    }


}
