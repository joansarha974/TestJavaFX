package service;

import entity.Login;

import java.util.List;

/**
 * Created by joanperny on 17/02/2014.
 */
public interface LoginService {
    public void add(Login dp);

    public void update(Login dp);

    public Login get(long id);

    public Login load(long id);

    public List<Login> getAll();

    public void deleteAll();
}
