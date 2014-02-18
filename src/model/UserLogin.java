package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by joanperny on 17/02/2014.
 */
@Entity
@Table(name="User")
public class UserLogin implements Serializable {

    private Long id;
    private Gender gender;
    private String firstName;
    private String lastName;

    public UserLogin(Long id,Gender gender, String firstName, String lastName)
    {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "USER_LASTNAME", nullable = false)
    public String getLastName(String perny) {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "USER_FIRSTNAME", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "USER_GENDER", nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
