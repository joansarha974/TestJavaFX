package service;
import model.UserLogin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Basic;

/**
 * Created by joanperny on 20/02/2014.
 */
public class AddToDB {
    @Basic
    int i = 0;
    public static void main(String[] args) {
        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("resources/hibernate.cfg.xml");//populates the data of the configuration file
        //creating seession factory object
        SessionFactory factory=cfg.buildSessionFactory();
        //creating session object
        Session session=factory.openSession();
        //creating transaction object
        Transaction t=session.beginTransaction();
        UserLogin e1;
        e1 = new UserLogin();
        e1.setId(115);
        e1.setUsername("admin");
        e1.setPassword("admin");
        session.persist(e1);//persisting the object
        t.commit();//transaction is commited
        session.close();
        System.out.println("successfully saved");
    }

}
