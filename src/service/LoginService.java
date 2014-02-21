package service;

import entity.Login;
import org.hibernate.envers.DefaultRevisionEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by joanperny on 17/02/2014.
 */
public interface LoginService {
    public void add(Login dp);

    public void update(Login dp);

    public Login get(long id);

    public Login load(long id);

    public List<Login> getAll();

    public Map<Number, DefaultRevisionEntity> getRevisions(long id);

    public void deleteAll();
}
