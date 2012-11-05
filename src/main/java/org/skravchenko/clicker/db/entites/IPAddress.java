package org.skravchenko.clicker.db.entites;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "IpAddress")
public class IPAddress {

    private Long id;
    private String ipAddress;
    private Date time;

    @Column(name="time",unique = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Column(name="IpAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Id
    @GeneratedValue
    @Column(name="Id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
