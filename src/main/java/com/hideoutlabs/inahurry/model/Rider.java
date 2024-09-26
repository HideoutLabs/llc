

package com.hideoutlabs.inahurry.model;


import javax.persistence.*;

@Entity(name="Rider")
@Table(name="Rider",   uniqueConstraints = {
        @UniqueConstraint(name="rider_ip_unique",columnNames = "rider_ip"),
        @UniqueConstraint(name="rider_email_unique",columnNames = "rider_email")
})
public class Rider extends AppUser{

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rider_sequence"
    )
    @Id
    private Long riderId;


    @Column(name = "rider_first_name",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String riderFirstName;

    public void setId(Long id) {
        this.riderId = id;
    }


    @Column(name = "rider_last_name",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String riderLastName;

    @Column(name = "rider_ip",
            nullable = false

    )
    private String riderIP;

    @Column(name = "rider_email",
            nullable = false,
            columnDefinition = "VARCHAR(256)"

    )


    private String riderEmail;

    public Rider(Long rId, String rFirstName, String rLastName, String rIP, String rEmail) {
        super();
        this.riderId = rId;
        this.riderFirstName = rFirstName;
        this.riderLastName = rLastName;
        this.riderIP = rIP;
        this.riderEmail = rEmail;
    }

    public Long getRiderId() {
        return riderId;
    }

    public String getRiderFirstName() {
        return riderFirstName;
    }

    public String getRiderLastName() {
        return riderLastName;
    }

    public String getRiderIP() {
        return riderIP;
    }

    public String getRiderEmail() {
        return riderEmail;
    }

   public Rider(){

   }

}


