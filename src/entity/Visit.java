package entity;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

/**
 * Created by joanperny on 26/02/2014.
 */
public class Visit {

    private final IntegerProperty id;
    private final StringProperty dateVisite;
    private final  StringProperty remarks;

    public Visit(int id1, String dateVisite, String remarks1) {
        this.id = new SimpleIntegerProperty(id1);
        this.dateVisite = new SimpleStringProperty(dateVisite);
        this.remarks = new SimpleStringProperty(remarks1);

    }


    private ObjectProperty<Place> place;
    private ObjectProperty<User_> user;
    private ObjectProperty<VisitType> visitType;
    private ListProperty<Subject_> subjects;
    private ObjectProperty<Folder> folder;

    public Visit(int id1, String dateVisit, String remarks1, Place place, User_ user, VisitType visitType,
                 ObservableList<Subject_> subjects, Folder folder1) {

        this.id = new SimpleIntegerProperty(id1);
        this.dateVisite = new SimpleStringProperty(dateVisit);
        this.remarks = new SimpleStringProperty(remarks1);
        this.place = new SimpleObjectProperty<Place>(place);
        this.user = new SimpleObjectProperty<User_>(user);
        this.visitType = new SimpleObjectProperty<VisitType>(visitType);
        this.subjects = new SimpleListProperty<Subject_>(subjects);
        this.folder = new SimpleObjectProperty<Folder>(folder1);

    }

    public Integer getId() {
        return id == null ? null : id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getRemarks() {
        return remarks == null ? null : remarks.get();
    }

    public void setRemarks(String remarks) {
        this.remarks.set(remarks);
    }

    public void setDateVisite(String dateVisite) {
        this.dateVisite.set(dateVisite);
    }

    public String getDateVisite() {
        return dateVisite == null ? null : dateVisite.get();
    }

    public ObjectProperty<Place> getPlace() {
        return place;
    }

    public void setPlace(ObjectProperty<Place> place) {
        this.place = place;
    }

    public ObjectProperty<User_> getUser() {
        return user;
    }

    public void setUser(ObjectProperty<User_> user) {
        this.user = user;
    }

    public ObjectProperty<VisitType> getVisitType() {
        return visitType;
    }

    public void setVisitType(ObjectProperty<VisitType> visitType) {
        this.visitType = visitType;
    }

    public ListProperty<Subject_> getSubjects() {
        return subjects;
    }

    public void setSubjects(ListProperty<Subject_> subjects) {
        this.subjects = subjects;
    }

    public ObjectProperty<Folder> getFolder() {
        return folder;
    }

    public void setFolder(ObjectProperty<Folder> folder) {
        this.folder = folder;
    }
}
