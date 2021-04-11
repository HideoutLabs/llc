package com.hideoutlabs.inahurry.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name="Customer")
@Table(name="Customer",
        uniqueConstraints = {
        @UniqueConstraint(name="customer_ip_unique",columnNames = "customer_ip"),
                @UniqueConstraint(name="customer_email_unique",columnNames = "customer_email")
        }

)

public class Customer extends Person{
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
            nullable=false,
            columnDefinition = "TEXT"

    )
    private  String cusFirstName;


    @Column( name ="cus_last_name",
            nullable=false,
            columnDefinition = "TEXT"

    )
    private  String cusLastName;

    @Column( name ="customer_ip",
            nullable=false

    )
    private  String cusIP;

    @Column( name ="customer_email",
            nullable=false,
            columnDefinition = "VARCHAR(256)"

    )
    private  String cusEmail;

    public Customer(Long cusId, String cusFirstName,String cusLastName,String cusIP,String cusEmail){
        this.cusId=cusId;
        this.cusFirstName=cusFirstName;
        this.cusLastName=cusLastName;
        this.cusIP=cusIP;
        this.cusEmail=cusEmail;
    }



    public String getFirstCusName() {
        return cusFirstName;
    }

    public String getLastCusName() {
        return cusLastName;
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

    public Customer() {

    }


}
