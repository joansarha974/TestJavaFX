package controller.database;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.sql.DriverManager;

import javafx.stage.Stage;
import  org.sqlite.JDBC;

/**
 * Created by joanperny on 19/02/2014.
 */
public class DatabaseController {
    public TextField dbname;

    public void onSignCreate(ActionEvent actionEvent) {
        //Create database
        //super(applicationcontext, "androidsqlite.db", null, 1);
        //Log.d(LOGCAT,"Created");

    }

    public void onSignUpdate(ActionEvent actionEvent) {
        //Update database

    }

    public void onSignRemove(ActionEvent actionEvent) {
        //Remove database

    }
}
