package model;

import controller.dossier.SujetsController;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Created by joanperny on 17/02/2014.
 */
@Entity
@Table(name="Client")
public class UserFiche implements Serializable{

    private Gender gender;
    private long id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String noDossier;
    private Integer phone;
    private Integer phone2;
    private UserLogin acceuilli_by;
    private java.util.Date date;
    private String lieu;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="CLIENT_SUJETS", joinColumns = {@JoinColumn(name="CLIENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SUJET_ID")})
    private Set<SujetsController> listViewSujet = new HashSet<SujetsController>();


    private String remarques;

    public UserFiche(long id,Gender gender, String firstName, String lastName, UserLogin acceuilli_by,
                     String noDossier, Date date)
    {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.acceuilli_by = acceuilli_by;
        this.noDossier = noDossier;
        this.date = date;
    }

    public UserFiche(long id,Gender gender, String firstName, String lastName,
                     String birthday, String noDossier, Integer phone, Integer phone2,
                     UserLogin acceuilli_by, Date date, String lieu,
                     SujetsController listViewSujet, String remarques)
    {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.noDossier = noDossier;
        this.phone = phone;
        this.phone2 = phone2;
        this.acceuilli_by = acceuilli_by;
        this.date = date;
        this.lieu = lieu;
        this.listViewSujet = (Set<SujetsController>) listViewSujet;
        this.remarques = remarques;
    }

    @Column(name="CLIENT_LASTNAME", nullable=false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="CLIENT_FIRSTNAME", nullable=false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Id
    @GeneratedValue
    @Column(name="CLIENT_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="CLIENT_BIRTHDAY", nullable=false)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void put(long id, UserFiche userFiche) {
    }

    @Column(name="CLIENT_NODOSSIER", nullable=false)
    public String getNoDossier() {
        return noDossier;
    }

    public void setNoDossier(String noDossier) {
        this.noDossier = noDossier;
    }

    @Column(name="CLIENT_PHONE", nullable=false)
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Column(name="CLIENT_PHONE2", nullable=false)
    public Integer getPhone2() {
        return phone2;
    }

    public void setPhone2(Integer phone2) {
        this.phone2 = phone2;
    }


    public UserLogin getAcceuilli_by() {
        return acceuilli_by;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="CLIENT_ACCEUILLYBYUSER", nullable=false)
    public void setAcceuilli_by(UserLogin acceuilli_by) {
        this.acceuilli_by = acceuilli_by;
    }

    @Column(name="CLIENT_DATE", nullable=false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="CLIENT_LIEU", nullable=false)
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Column(name="CLIENT_REMARQUES", nullable=false)
    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Set<SujetsController> getListViewSujet() {
        return listViewSujet;
    }

    public void setListViewSujet(Set<SujetsController> listViewSujet) {
        this.listViewSujet = listViewSujet;
    }
}
