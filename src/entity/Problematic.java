package entity;

import java.util.List;

/**
 * Created by joanperny on 26/02/2014.
 */
public class Problematic {
    private Long id;
    private String name;
    private List<Subject_> subjects;

    public Problematic() {}

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

    public List<Subject_> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject_> subjects) {
        this.subjects = subjects;
    }
}
