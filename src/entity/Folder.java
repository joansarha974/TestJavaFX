package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by joanperny on 17/02/2014.
 */
public class Folder implements Serializable{

    private Gender gender;
    private Long id;
    private String surname;
    private String lastname;
    private Date birthday;
    private Integer numero;
    private String phone;
    private String phone2;
    private Login by_user_login;
    private Date date;
    private String lieu;
    private Sujet sujets;
    private String remarque;
    private Date created;
    private Date lastModified;

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Sujet getSujets() {
        return sujets;
    }

    public void setSujets(Sujet sujets) {
        this.sujets = sujets;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Login getBy_user_login() {
        return by_user_login;
    }

    public void setBy_user_login(Login by_user_login) {
        this.by_user_login = by_user_login;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Folder() {

    }

    public Folder(long l, Gender gender, String user1, String useruser,        Login userLogin, String noDossier, Date aujourdhui) {
        this.id = l;
    }

    public void put(Long id, Folder userFiche) {

    }
}
