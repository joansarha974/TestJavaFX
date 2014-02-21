package controller.login;

import entity.Login;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import resources.HibernateUtil;

import static resources.HibernateUtil.getSessionFactory;


/**
 * Created by joanperny on 17/02/2014.
 */
public class LoginController {

    public Label messageLabel;
    public TextField username;
    public PasswordField password;
    public Stage stage;

    public void onSignIn(ActionEvent actionEvent) {
        System.out.println("successfully saved");
        if (username.getText().isEmpty() && password.getText().isEmpty()){
            //message
            messageLabel.setText("Login is missing");
        }
        else {
            // A SessionFactory is set up once for an application
            //Configuration configuration = new Configuration();
            //configuration.configure("resources/hibernate.cfg.xml");
            //configuration.buildSessionFactory();

            Session session = getSessionFactory().getCurrentSession();



            // create a couple of events...

            session.beginTransaction();
            session.save(new Login(new java.util.Date(), new java.util.Date(), "admin", "admin"));
            session.save(new Login(new java.util.Date(), new java.util.Date(), "user", "user"));
            session.getTransaction().commit();
            getSessionFactory().close();

            // now lets pull events from the database and list them
            session.beginTransaction();
            java.util.List result = session.createQuery( "from LOGIN " ).list();
            for ( Login userLogin : (java.util.List<Login>) result ) {
                System.out.println( "UserLogin (" + (userLogin.getCreated()) + ") : " + userLogin.getUsername() );
            }
            session.getTransaction().commit();
            getSessionFactory().close();
        }
    }

    public void onSignOut(ActionEvent actionEvent) {

        //reset les champs
        username.setText("username");
        password.setText("password");

        //indique que les champs sont reset
        messageLabel.setText("Reset values ...");
    }

    public void onSignCreate(ActionEvent actionEvent) {
        //Create database

    }
}
