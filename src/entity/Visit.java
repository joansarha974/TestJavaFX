package entity;

import java.util.Date;
import java.util.List;

/**
 * Created by joanperny on 26/02/2014.
 */
public class Visit {

    private Long id;
    private Date date;
    private String remarks;
    private User_ user;
    private Place place;
    private VisitType visitType;
    private List<Subject_> subjects;
    private Folder folder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public VisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }

    public List<Subject_> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject_> subjects) {
        this.subjects = subjects;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}
