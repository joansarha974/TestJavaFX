package entity;

import java.util.List;

/**
 * Created by joanperny on 26/02/2014.
 */
public class VisitType {

    private Long id;
    private String name;
    private List<Visit> visits;

    public VisitType() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
