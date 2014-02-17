package model;

/**
 * Created by joanperny on 17/02/2014.
 */
public class UserLogin {
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

    public String getLastName(String perny) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
