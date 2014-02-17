package model;

import controller.dossier.Sujets;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by joanperny on 17/02/2014.
 */
public class UserFiche {

    private Gender gender;
    private long id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String NoDossier;
    private Integer Phone;
    private Integer Phone2;
    private UserLogin Acceuilli_by;
    private java.util.Date Date;
    private String Lieu;
    private Sujets ListViewSujet;
    private String Remarques;

    public UserFiche(long id,Gender gender, String firstName, String lastName, UserLogin Acceuilli_by,
                     String NoDossier, Date Date)
    {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Acceuilli_by = Acceuilli_by;
        this.NoDossier = NoDossier;
        this.Date = Date;
    }

    public UserFiche(long id,Gender gender, String firstName, String lastName,
                     String birthday, String NoDossier, Integer Phone, Integer Phone2,
                     UserLogin Acceuilli_by, Date Date, String Lieu,
                     Sujets ListViewSujet, String Remarques)
    {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.NoDossier = NoDossier;
        this.Phone = Phone;
        this.Phone2 = Phone2;
        this.Acceuilli_by = Acceuilli_by;
        this.Date = Date;
        this.Lieu = Lieu;
        this.ListViewSujet = ListViewSujet;
        this.Remarques = Remarques;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNoDossier() {
        return NoDossier;
    }

    public void setNoDossier(String noDossier) {
        NoDossier = noDossier;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public Integer getPhone2() {
        return Phone2;
    }

    public void setPhone2(Integer phone2) {
        Phone2 = phone2;
    }

    public UserLogin getAcceuilli_by() {
        return Acceuilli_by;
    }

    public void setAcceuilli_by(UserLogin acceuilli_by) {
        Acceuilli_by = acceuilli_by;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String lieu) {
        Lieu = lieu;
    }

    public Sujets getListViewSujet() {
        return ListViewSujet;
    }

    public void setListViewSujet(Sujets listViewSujet) {
        ListViewSujet = listViewSujet;
    }

    public String getRemarques() {
        return Remarques;
    }

    public void setRemarques(String remarques) {
        Remarques = remarques;
    }

    public void put(long id, UserFiche userFiche) {
    }
}
