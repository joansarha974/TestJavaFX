package model;

import org.hibernate.sql.Insert;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by joanperny on 17/02/2014.
 */
@Entity (name = "userLogin")
public class UserLogin {
    @Column (name = "username")
    private String username;
    @Column (name = "password")
    private String password;
    @Id
    private int id;
    @Column (name = "created")
    private Date created;
    @Column (name = "lastModified")
    private Date lastModified;

    public UserLogin() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
