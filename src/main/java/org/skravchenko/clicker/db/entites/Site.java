package org.skravchenko.clicker.db.entites;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Sites")
public class Site {

    private Long id;
    private String http;
    //private Set<Statistics> statistics = new HashSet<Statistics>(0);


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

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	//public Set<Statistics> getStatictics() {
	//	return this.statistics;
	//}

	//public void setStatistics(Set<Statistics> statistics) {
//		this.statistics = statistics;
//	}


}
