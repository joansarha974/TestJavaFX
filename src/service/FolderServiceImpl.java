package service;

import entity.Folder;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import resources.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by joanperny on 20/02/2014.
 */
public class FolderServiceImpl implements FolderService {

    private HibernateUtil hibernateUtil = new HibernateUtil();


    @Override
    public void add(Folder dp) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        s.persist( dp );
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void update(Folder dp) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        s.update( dp );
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public Folder get(long id) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        Folder dp = (Folder) s.createCriteria( Folder.class ).add(
                Restrictions.eq("id", id) ).uniqueResult();
        s.getTransaction().commit();
        s.close();
        return dp;
    }

    @Override
    public Folder load(long id) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        Folder dp = (Folder) s.load( Folder.class, new Long(id) );
        // initialize
        dp.getSurname();
        s.getTransaction().commit();
        s.close();
        return dp;
    }

    @Override
    public List<Folder> getAll() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        List list = s.createQuery( "from FOLDER" ).list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    @Override
    public Map<Number, DefaultRevisionEntity> getRevisions(long id) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        AuditReader reader = AuditReaderFactory.get(s);
        List<Number> revisionNums = reader.getRevisions( Folder.class, id );
        return reader.findRevisions( DefaultRevisionEntity.class, new HashSet<Number>(revisionNums) );
    }

    @Override
    public void deleteAll() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.getTransaction().begin();
        s.createQuery( "delete from FOLDER" ).executeUpdate();
        s.getTransaction().commit();
        s.close();
    }
}
