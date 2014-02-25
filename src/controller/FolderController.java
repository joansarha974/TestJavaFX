package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jline.internal.Log;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

/**
 * Created by joanperny on 17/02/2014.
 */
public class FolderController {

    public ListView gender;
    public TextField folderNumber;
    public TextField name;
    public TextField surname;
    public TextField birthdayDate;
    public TextField address1;
    public TextField address2;
    public TextField district;
    public TextField postalCode;
    public TextField city;
    public TextField phone1;
    public TextField phone2;
    public TextField nationality;
    public TextField birthCountry;
    public TextField firstEntryFranceDate;
    public TextField maritalStatus;
    public TextField professionalStatus;
    public TextArea remarks;
    public TextField created;
    public TextField lastModified;
    public ListView visits;
    public Label messageLabel;

    public void onListFolder(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        String nameText = name.getText();
        String surnameText = surname.getText();

        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;

        connection = getConnection("jdbc:sqlite:Database.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        if (surname.getText().isEmpty() && name.getText().isEmpty()){
            //message
            messageLabel.setText("Fields is missing");
        }
        else {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet res = meta.getTables(null, null, "folder", null);
            if (res.next())
            {
                //Table exists
                Log.info("Existing table folder");
                //inserting data
                ResultSet rs = statement.executeQuery("SELECT * FROM user_login  WHERE  username='"+user+"' and password='"+pwd+"'");
                if(rs.next())
                {
                    Log.info("user identified");
                    messageLabel.setText("user identified");
                }
                else
                {
                    Log.info("user not identified");
                    messageLabel.setText("user not identified");
                }
                statement.close();

            }
            else {
                //Table does not exists
                //Table does not exists
                statement.executeUpdate("create table user_login(id integer primary key autoincrement, username varchar(30)," +
                        "password varchar(30), created date, lastModified date);");
                Log.info("Created table user_login");
                //inserting data
                statement.executeUpdate("INSERT INTO user_login (username, password, created, lastModified)" +
                        "VALUES (user,pwd, dateCreated,dateLastModified)");
                statement.close();
                Log.info("Table folder does not exists");
            }
            connection.close();

        }

    }
}
