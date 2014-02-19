package controller.login;
import javafx.fxml.FXMLLoader;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.DriverManager;

import javafx.stage.Stage;
import model.UserLogin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import  org.sqlite.JDBC;

import java.awt.*;
import java.io.IOException;
import java.sql.*;

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
            System.out.println("successfully saved");
            //getting values from form Login
            //String user = username.getText();
            //String pwd = password.getText();

            //create a database connection sqlite

            messageLabel.setText("1");


            //creating configuration object
            Configuration cfg=new Configuration();
            messageLabel.setText("2");
            cfg.configure("resources/hibernate.cfg.xml");//populates the data of the configuration file
            messageLabel.setText("3");
            //creating session factory object
            SessionFactory factory=cfg.buildSessionFactory();
            messageLabel.setText("4");
            //creating session object
            Session session=factory.openSession();
            messageLabel.setText("5");
            //creating transaction object
            Transaction t=session.beginTransaction();
            messageLabel.setText("6");
            UserLogin e1;
            messageLabel.setText("7");
            e1 = new UserLogin();
            messageLabel.setText("8");
            e1.setId(115);
            e1.setUsername("admin");
            e1.setPassword("admin");
            messageLabel.setText("9");
            session.persist(e1);//persisting the object
            messageLabel.setText("10");
            t.commit();//transaction is commited
            messageLabel.setText("11");
            session.close();
            messageLabel.setText("12");


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
