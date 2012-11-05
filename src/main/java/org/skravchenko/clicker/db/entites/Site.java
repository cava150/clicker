package org.skravchenko.clicker.db.entites;
import javax.persistence.*;


@Entity
@Table(name = "Sites")
public class Site {

    private Long id;
    private String http;

    @Id
    @GeneratedValue
    @Column(name="Id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="url")
    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }
}
