package service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import entity.Login;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;

import resources.*;

/**
 * Created by joanperny on 19/02/2014.
 */


public class LoginServiceImpl implements LoginService {

    private HibernateUtil hibernateUtil = new HibernateUtil();

    public void add(Login dp) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        s.persist( dp );
        s.getTransaction().commit();
        s.close();
    }

    public void update(Login dp) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        s.update( dp );
        s.getTransaction().commit();
        s.close();
    }

    public Login get(long id) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        Login dp = (Login) s.createCriteria( Login.class ).add(
                Restrictions.eq( "id", id ) ).uniqueResult();
        s.getTransaction().commit();
        s.close();
        return dp;
    }

    // Test lazy loading (mainly to make sure the proxy classes work in OSGi)
    public Login load(long id) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        Login dp = (Login) s.load( Login.class, new Long(id) );
        // initialize
        dp.getUsername();
        s.getTransaction().commit();
        s.close();
        return dp;
    }

    public List<Login> getAll() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        List list = s.createQuery( "from LOGIN" ).list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    public Map<Number, DefaultRevisionEntity> getRevisions(long id) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        AuditReader reader = AuditReaderFactory.get(s);
        List<Number> revisionNums = reader.getRevisions( Login.class, id );
        return reader.findRevisions( DefaultRevisionEntity.class, new HashSet<Number>(revisionNums) );
    }

    public void deleteAll() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        s.createQuery( "delete from LOGIN" ).executeUpdate();
        s.getTransaction().commit();
        s.close();
    }
}
