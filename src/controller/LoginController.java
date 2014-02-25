package controller;

import entity.Login;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jline.internal.Log;

import java.sql.*;

import static java.sql.DriverManager.*;


/**
 * Created by joanperny on 17/02/2014.
 */
public class LoginController {

    public Label messageLabel;
    public TextField username;
    public PasswordField password;
    public Stage stage;

    public void onSignIn(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        String user = username.getText();
        String pwd = password.getText();

        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;

        connection = getConnection("jdbc:sqlite:Database.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        if (username.getText().isEmpty() && password.getText().isEmpty()){
            //message
            messageLabel.setText("Login is missing");
        }
        else {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet res = meta.getTables(null, null, "user_login", null);
            if (res.next())
            {
                //Table exists
                Log.info("Existing table user_login");
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
                Log.info("Table does not exists");
            }
            connection.close();

        }
    }

    public void onSignOut(ActionEvent actionEvent) {

        //reset fields
        username.setText("username");
        password.setText("password");

        //indique que les champs sont reset
        messageLabel.setText("Reset values ...");
    }

    public void onSignCreate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //get fields username and password
        String user = username.getText();
        String pwd = password.getText();
        java.util.Date created = new java.util.Date();
        java.util.Date lastModified = new java.util.Date();

        //
        // Create Table Login if not exist
        //
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:Database.db");
            Statement stat = con.createStatement();
            stat.setQueryTimeout(30);

            //
            // Check if table exist
            //
            //DatabaseMetaData meta = con.getMetaData();
            //ResultSet res = meta.getTables(null, null,null, new String[]{"TABLE"});
            //while (res.next ()) {
            //    Log.info ("" + res.getString ("TABLE_CAT")
            //                    + "," + res.getString ("TABLE_SCHEM")
            //                    + "," + res.getString ("nom de table")
            //                    + "," + res.getString ("TABLE_TYPE"));
            //}

            DatabaseMetaData meta = con.getMetaData();
            ResultSet res = meta.getTables(null, null, "user_login", null);
            if (res.next())
            {
                //Table exists
                Log.info("Existing table user_login");
                //inserting data
                stat.executeUpdate("INSERT INTO user_login " +
                        "(username, password, created, lastModified)" +
                        "VALUES ('"+user+"','"+pwd+"','"+created+"','"+lastModified+"')");
                stat.close();
                Log.info("user created into table user_login");
            }
            else {
                //Table does not exists
                stat.executeUpdate("create table user_login(id integer primary key autoincrement, username varchar(30)," +
                        "password varchar(30), created date, lastModified date);");
                Log.info("Created table user_login");
                //inserting data
                stat.executeUpdate("INSERT INTO user_login (username, password, created, lastModified)" +
                        "VALUES (user,pwd, dateCreated,dateLastModified)");
                stat.close();
                Log.info("user created into table user_login");
            }

            //drop table
            //stat.executeUpdate("drop table user_login");
        }
        catch (SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(con != null)
                    con.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }

    }
}
