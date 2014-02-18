package controller.login;
import javafx.fxml.FXMLLoader;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
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
        if (username.getText().isEmpty() && password.getText().isEmpty()){
            //message
            messageLabel.setText("Login is missing");
        }
        else {
            //getting values from form Login
            String user = username.getText();
            String pwd = password.getText();

            //create a database connection sqlite

            Connection connection = null;

            try{
                connection = DriverManager.getConnection("jdbc:sqlite:Database.db");
                Statement statement = connection.createStatement();
                statement.setQueryTimeout(30); //set timeout to 30 sec

                //statement.executeUpdate("drop table if exists person");
                //statement.executeUpdate("create table person (id integer, name string)");
                //statement.executeUpdate("insert into person values(1, 'leo')");
                //statement.executeUpdate("insert into person values(2, 'yui')");

                ResultSet rs = statement.executeQuery("select * from User " +
                        "where username == '"+user+"' and password =='"+pwd+"'");
                if(rs.next())
                {
                    // redirige vers dossier.fxml
                    Parent root = FXMLLoader.load(getClass().getResource("view/DossierView.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                }
                else {
                    messageLabel.setText("incorrect details!");
                }
            }catch (SQLException e)
            {
                // if the error message is "out of memory",
                // it probably means no database file is found
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(connection != null)
                        connection.close();
                } catch (SQLException e) {
                    // connection close failed.
                    e.printStackTrace();
                }
            }
        }
    }

    public void onSignOut(ActionEvent actionEvent) {

        //reset les champs
        username.setText("username");
        password.setText("password");

        //indique que les champs sont reset
        messageLabel.setText("Reset values ...");
    }
}
