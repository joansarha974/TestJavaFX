package entity;

import java.util.Date;

/**
 * Created by joanperny on 26/02/2014.
 */
public class Action_ {

    private Long id;
    private Date date;
    private String detail;
    private ActionType_ actionType;
    private Subject_ subject;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ActionType_ getActionType() {
        return actionType;
    }

    public void setActionType(ActionType_ actionType) {
        this.actionType = actionType;
    }

    public Subject_ getSubject() {
        return subject;
    }

    public void setSubject(Subject_ subject) {
        this.subject = subject;
    }
}
