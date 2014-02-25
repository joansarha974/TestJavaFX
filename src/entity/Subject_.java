package entity;

import java.util.List;

/**
 * Created by joanperny on 26/02/2014.
 */
public class Subject_ {

    private Long id;
    private boolean terminated;
    private Problematic problematic;
    private List<Action_> actions;
    private Visit visit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    public Problematic getProblematic() {
        return problematic;
    }

    public void setProblematic(Problematic problematic) {
        this.problematic = problematic;
    }

    public List<Action_> getActions() {
        return actions;
    }

    public void setActions(List<Action_> actions) {
        this.actions = actions;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
