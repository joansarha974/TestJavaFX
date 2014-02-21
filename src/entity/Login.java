package entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by joanperny on 17/02/2014.
 */


public class Login implements Serializable {

    private String username;
    private String password;
    private Long id;
    private Date created;
    private Date lastModified;

    public Login() {
        // this form used by Hibernate
    }

    public Login(Date created, Date lastModified, String username, String password) {
        // for application use, to create new logins
        this.created = created;
        this.lastModified = lastModified;
        this.username = username;
        this.password = password;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
