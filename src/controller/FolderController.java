package controller;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.PGNode;
import entity.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jline.internal.Log;

import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static java.sql.DriverManager.getConnection;

/**
 * Created by joanperny on 17/02/2014.
 */
public class FolderController implements Initializable{

    public static Stage dialog1;

    @FXML
    public Label genderLabel;
    @FXML
    public Label folderNumberLabel;
    @FXML
    public Label nameLabel;
    @FXML
    public Label surnameLabel;
    @FXML
    public Label birthdayDateLabel;
    @FXML
    public Label address1Label;
    @FXML
    public Label address2Label;
    @FXML
    public Label districtLabel;
    @FXML
    public Label postalCodeLabel;
    @FXML
    public Label cityLabel;
    @FXML
    public Label phone1Label;
    @FXML
    public Label phone2Label;
    @FXML
    public Label nationalityLabel;
    @FXML
    public Label birthCountryLabel;
    @FXML
    public Label firstEntryFranceDateLabel;
    @FXML
    public Label maritalStatusLabel;
    @FXML
    public Label professionalStatusLabel;
    @FXML
    public Label remarksLabel;
    @FXML
    public Label createdLabel;
    @FXML
    public Label lastModifiedLabel;
    @FXML
    public Label visitsLabel;

    public ListView gender;
    @FXML
    public TextField folderNumber;
    @FXML
    public TextField name;
    @FXML
    public TextField surname;
    @FXML
    public TextField birthdayDate;
    @FXML
    public TextField address1;
    @FXML
    public TextField address2;
    @FXML
    public TextField district;
    @FXML
    public TextField postalCode;
    @FXML
    public TextField city;
    @FXML
    public TextField phone1;
    @FXML
    public TextField phone2;
    @FXML
    public TextField nationality;
    @FXML
    public TextField birthCountry;
    @FXML
    public TextField firstEntryFranceDate;
    @FXML
    public TextField maritalStatus;
    @FXML
    public TextField professionalStatus;
    @FXML
    public TextArea remarks;
    @FXML
    public TextField created;
    @FXML
    public TextField lastModified;

    public ListView visits;
    @FXML
    public Label messageLabel;
    @FXML
    public Button addFolderButton;

    @FXML
    public AnchorPane content_folder;
    @FXML
    public ScrollPane scFolderPane;


    // DEFINE TABLE

    @FXML
    TableView<Visit> tableVisitID;
    @FXML
    TableColumn<Visit, Integer> tVisitID;
    @FXML
    TableColumn<Visit, String> tVisitDate;
    @FXML
    TableColumn<Visit, String> tVisitRemarks;
    @FXML
    TableColumn<Visit, Subject_> tVisitSubjects;
    @FXML
    TableColumn<Visit, User_> tVisitUser;
    @FXML
    TableColumn<Visit, Place> tVisitPlace;
    @FXML
    TableColumn<Visit, VisitType> tVisitType;
    @FXML
    TableColumn<Visit, Folder> tVisitFolder;

    // DEFINE FORM INSERT TABLEVIEW VISITE

    @FXML
    TextField dateInpu;
    @FXML
    TextField remarkInpu;
    @FXML
    Button submit;

    // DEFINE VARIABLES
    private  int iNumber = 1;


    //CREATE TABLE DATA

    ObservableList<Visit> dataVisit = FXCollections.observableArrayList(
        new Visit(iNumber++, "21-08-1984", "remark1"),
        new Visit(iNumber++, "30-04-2007", "remark2"),
        new Visit(iNumber++, "30-08-2013", "remark3")
    );

    //Recently I have created a database in SQLite with tables that has foreign keys
    // ON DELETE CASCADE actions. To my surprise when I deleted the parent key each
    // row of the child table associated with the parent key are not deleted.
    // The answer is that by default in SQLite  foreign key support is turned off
    // for compatibility. To enable foreign keys using Xerial SQLite JDBC Driver
    // We have to enforce foreign key support every time we make a query.

    public static final String DB_URL ="jdbc:sqlite:Database.db";
    public static final String DRIVER = "org.sqlite.JDBC";


    //public static Connection getConnection() throws ClassNotFoundException {
    //    Class.forName(DRIVER);
    //    Connection connection = null;
    //    try {
    //        SQLiteConfig config = new SQLiteConfig();
    //        config.enforceForeignKeys(true);
    //        connection = DriverManager.getConnection(DB_URL, config.toProperties());
    //    }
    //    catch (SQLException ex) {}
    //    return connection;
    //}

    //
    // Function management Date
    //

    public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public static java.util.Date stringToDate(String sDate) throws ParseException {
        return formatter.parse(sDate);
    }

    public static Timestamp toDBDateFormat(String sDate) throws ParseException {
        return new Timestamp(stringToDate(sDate).getTime());
    }

    public static String dateToString(Date date) {
        return formatter.format(date);

    }


    //
    // FILTER FOR FOLDER BY NAME, SURNAME, numberFOLDER, DATABIRTH
    //

    public void onSearchFolder(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, ParseException {

        String nameText = name.getText();
        String surnameText = surname.getText();
        String birthdayDateText = birthdayDate.getText();
        Date birthdayDateDate = (Date) stringToDate(birthdayDateText);
        String folderNumberText = folderNumber.getText();



        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        //connection = getConnection();
        connection = getConnection("jdbc:sqlite:Database.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        //VERIFY IF TABLE FOLDER EXIST - database normally already exists
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet res = meta.getTables(null, null, "folder", null);

            //if fields is empty
        if (surname.getText().isEmpty() && name.getText().isEmpty() && birthdayDate.getText().isEmpty() && folderNumber.getText().isEmpty())
        {
            //return all folder
            if (res.next())
            {
                ResultSet rs = statement.executeQuery("SELECT * FROM folder");
                statement.close();
                connection.close();
            }
            else {
                //Table does not exists
                //Created table folder and relation one2many visit
                statement.executeUpdate("create table folder(id integer primary key autoincrement, " +
                        "gender varchar(30),"+
                        "folderNumber varchar(30),"+
                        "name varchar(30),"+
                        "surname varchar(30),"+
                        "birthdayDate date,"+
                        "address1 varchar(30),"+
                        "address2 varchar(30),"+
                        "district varchar(30),"+
                        "postalCode varchar(30),"+
                        "city varchar(30),"+
                        "phone1 varchar(30),"+
                        "phone2 varchar(30),"+
                        "nationality varchar(30),"+
                        "birthCountry varchar(30),"+
                        "firstEntryFranceDate date,"+
                        "maritalStatus varchar(30),"+
                        "professionalStatus varchar(30),"+
                        "remarks varchar(30),"+
                        "created date,"+
                        "lastModified date);");

                //Created table folder_visit (many2one)
                //CREATE TABLE "folder_visit" ("folder_id" INTEGER REFERENCES "folder" ("id"), "visit_id" INTEGER REFERENCES "visit" ("id"));
                statement.executeUpdate("create table folder_visit(" +
                        "folder_id integer, " +
                        "visit_id integer," +
                        "FOREIGN KEY (folder_id) REFERENCES folder(id)," +
                        "FOREIGN KEY (visit_id) REFERENCES visit(id));");

                //Created table visit and relation one2many Subject
                statement.executeUpdate("create table visit(id integer primary key autoincrement, " +
                        "date_ date," +
                        "remarks varchar(30), " +
                        "user integer," +
                        "place integer," +
                        "visitType integer," +
                        "folder integer," +
                        "FOREIGN KEY (user) REFERENCES user(id)," +
                        "FOREIGN KEY (place) REFERENCES place(id)," +
                        "FOREIGN KEY (visitType) REFERENCES visiteType(id)," +
                        "FOREIGN KEY (folder) REFERENCES folder(id))");

                //Created table user and relation one2many visit
                statement.executeUpdate("create table user(id integer primary key autoincrement, " +
                        "gender varchar(30),"+
                        "name varchar(30),"+
                        "surname varchar(30))");

                //Created table visit_subject many2one
                statement.executeUpdate("create table visit_subject(" +
                        "visit_id integer, " +
                        "subject_id integer," +
                        "FOREIGN KEY (visit_id) REFERENCES visit(id),"+
                        "FOREIGN KEY (subject_id) REFERENCES subject(id));");

                //Created table user_visit many2one
                statement.executeUpdate("create table user_visit(" +
                        "user_id integer, " +
                        "visit_id integer,"+
                        "FOREIGN KEY (user_id) REFERENCES user(id),"+
                        "FOREIGN KEY (visit_id) REFERENCES visit(id));");

                //Created table place
                statement.executeUpdate("create table place(id integer primary key autoincrement, " +
                        "name varchar(30))");

                //Created table place_visit many2one
                statement.executeUpdate("create table place_visit(" +
                        "place_id integer, " +
                        "visit_id integer,"+
                        "FOREIGN KEY (place_id) REFERENCES place(id),"+
                        "FOREIGN KEY (visit_id) REFERENCES visit(id));");

                //Created table Subject and relation one2many Action_
                statement.executeUpdate("create table subject(id integer primary key autoincrement, " +
                        "terminated boolean," +
                        "problematic integer," +
                        "visit integer)");

                //Created table subject_action many2one
                statement.executeUpdate("create table subject_action(" +
                        "subject_id integer, " +
                        "action_id integer," +
                        "FOREIGN KEY (visit_id) REFERENCES visit(id));");

                //Created table problematic_subject many2one
                statement.executeUpdate("create table problematic_subject(" +
                        "problematic_id integer, " +
                        "subject_id integer,"+
                        "FOREIGN KEY (problematic_id) REFERENCES problematic(id),"+
                        "FOREIGN KEY (subject_id) REFERENCES subject(id));");

                //Created table problematic
                statement.executeUpdate("create table problematic(id integer primary key autoincrement, " +
                        "name varchar(30))");

                //Created table visiteType and relation one2many visit
                statement.executeUpdate("create table visiteType(id integer primary key autoincrement, " +
                        "name varchar(30))");

                //Created table visiteType_visit many2one
                statement.executeUpdate("create table visiteType_visit(" +
                        "visiteType_id integer, " +
                        "visit_id integer,"+
                        "FOREIGN KEY (visit_id) REFERENCES visit(id));");

                //Created table Action
                statement.executeUpdate("CREATE TABLE action (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "date_ DATE, " +
                        "detail VARCHAR(30), " +
                        "actionType integer, " +
                        "subject integer," +
                        "FOREIGN KEY (actionType) REFERENCES actionType(id)," +
                        "FOREIGN KEY (subject) REFERENCES subject(id))");

                //Created table actionType and relation one2many action
                statement.executeUpdate("create table actionType(id integer primary key autoincrement, " +
                        "name varchar(30))");

                //Created table actionType_action many2one
                statement.executeUpdate("create table actionType_action(" +
                        "actionType_id integer, " +
                        "action_id integer,"+
                        "FOREIGN KEY (actionType_id) REFERENCES actionType(id)," +
                        "FOREIGN KEY (action_id) REFERENCES action(id))");

                //return a value empty

                ResultSet rs = statement.executeQuery("SELECT * FROM folder");

                statement.close();
                connection.close();
            }
        }
        else
        {
            if (res.next())
            {
                ResultSet rs = statement.executeQuery("SELECT * FROM folder " +
                        "where folderNumber like '%"+ folderNumberText + "%'"+
                        "and name like '%"+ nameText + "%'" +
                        "and surname like '%"+ surnameText + "%'" +
                        "and birthdayDate like '%"+ birthdayDateDate + "%'");
                statement.close();
                connection.close();
            }
        }
    }

    //
    // ADD FOLDER
    //


    public void onAddFolder(ActionEvent actionEvent) throws ParseException, ClassNotFoundException, SQLException
    {

        String nameText = name.getText();
        String surnameText = surname.getText();
        String birthdayDateText = birthdayDate.getText();
        //Date birthdayDateDate = (Date) stringToDate(birthdayDateText);
        String folderNumberText = folderNumber.getText();
        //ObservableList genderItems = gender.getItems();
        String address1Text = address1.getText();
        String address2Text = address2.getText();
        String districtText = district.getText();
        String postalCodeText = postalCode.getText();
        String cityText = city.getText();
        String phone1Text = phone1.getText();
        String phone2Text = phone2.getText();
        String nationalityText = nationality.getText();
        String birthCountryText = birthCountry.getText();
        String firstEntryFranceDateText = firstEntryFranceDate.getText();
        String maritalStatusText = maritalStatus.getText();
        String professionalStatusText = professionalStatus.getText();
        //String remarksText = remarks.getText();
        //String createdText = created.getText();
        String remarksText = "01-01-2000";
        String createdText = "01-01-2000";
        //Date createdDate = (Date) stringToDate(createdText);
        String lastModifiedText = "01-01-2000";
        //Date lastModifiedDate = (Date) stringToDate(lastModifiedText);
        //ObservableList visitsItems = visits.getItems();

        // load the sqlite-JDBC driver using the current class loader
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;

        //connection = getConnection();
        connection = getConnection("jdbc:sqlite:Database.db");
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        DatabaseMetaData meta = connection.getMetaData();
        ResultSet res = meta.getTables(null, null, "folder", null);

        if (res.next())
        {
            String Requete_SQL = "INSERT INTO folder"
                    + " (gender, folderNumber, name, surname,"
                    + " birthdayDate, address1, address2, district,"
                    + " postalCode, city, phone1, phone2,"
                    + " nationality, birthCountry, firstEntryFranceDate, maritalStatus,"
                    + " professionalStatus, remarks, created, lastModified)"
                    + " VALUES ('" + "femme" + "','" + folderNumberText + "' , '" + nameText + "' , '" + surnameText + "' "
                    + " ,'" + birthdayDateText + "','" + address1Text + "','" + address2Text + "','" + districtText + "' "
                    + " ,'" + postalCodeText + "','" + cityText + "','" + phone1Text + "','" + phone2Text + "' "
                    + " ,'" + nationalityText + "','" + birthCountryText + "','" + firstEntryFranceDateText + "' , '" + maritalStatusText + "' "
                    + " ,'" + professionalStatusText + "','" + remarksText + "','" + createdText + "','" + lastModifiedText + "')";

            statement.executeUpdate(Requete_SQL);
            statement.close();
            connection.close();
            Log.info("OK");
        }
    }


    public  void onAddItem(ActionEvent actionEvent)
    {
        Log.info("dateInpu : "+dateInpu.getText());
        Log.info("RemarkInpu : "+remarkInpu.getText());
        // add the data any time and the table will be updates
        Visit entry = new Visit(iNumber, dateInpu.getText(), remarkInpu.getText());
        iNumber++;
        Log.info("entry : "+entry.getDateVisite() + " " + entry.getRemarks() + " " + entry.getId());
        // insert date in table
        dataVisit.add(entry);

        //clear TextFields
        clearForm();
    }

    private void clearForm() {
        dateInpu.clear();
        remarkInpu.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* Tableview visit */

        tVisitID.setCellValueFactory(new PropertyValueFactory<Visit, Integer>("id"));
        tVisitDate.setCellValueFactory(new PropertyValueFactory<Visit, String>("dateVisite"));
        tVisitRemarks.setCellValueFactory(new PropertyValueFactory<Visit, String>("remarks"));
        tVisitSubjects.setCellValueFactory(new PropertyValueFactory<Visit, Subject_>("subjects"));
        tVisitUser.setCellValueFactory(new PropertyValueFactory<Visit, User_>("user"));
        tVisitPlace.setCellValueFactory(new PropertyValueFactory<Visit, Place>("place"));
        tVisitType.setCellValueFactory(new PropertyValueFactory<Visit, VisitType>("visitType"));
        tVisitFolder.setCellValueFactory(new PropertyValueFactory<Visit, Folder>("folder"));

        tableVisitID.setItems(dataVisit);

        /* Scroller */


        /*scFolderPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scFolderPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scFolderPane.setVmax(900);
        scFolderPane.setPrefSize(760.0, 760.0);*/
    }


    //
    // UPDATE FOLDER
    //



    //
    // REMOVE FOLDER
    //
}