package entity;

import java.util.List;

/**
 * Created by joanperny on 26/02/2014.
 */
public class ActionType_ {

    private Long id;
    private String name;
    private List<Action_> actions;

    public ActionType_() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Action_> getActions() {
        return actions;
    }

    public void setActions(List<Action_> actions) {
        this.actions = actions;
    }
}
