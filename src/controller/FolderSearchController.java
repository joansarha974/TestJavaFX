package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by joanperny on 17/02/2014.
 */
public class FolderSearchController implements Initializable {

    public AnchorPane search_label;
    public CheckBox check_todo;
    public CheckBox check_mine;
    public CheckBox check_all;
    public RadioButton radioFolder;
    public RadioButton radioVisit;
    public RadioButton radioSujectsActions;
    public TableView tableViewSearchFolder;
    public TableView tableViewSearchVisit;
    public TableView tableViewSearchSubjectsActions;
    public TableColumn tableColumnSearchFolderDateVisite;
    public TableColumn tableColumnSearchFolderNoFolder;
    public TableColumn tableColumnSearchFolderNameSurname;
    public TableColumn tableColumnSearchFolderBirthday;
    public TableColumn tableColumnSearchFolderUserBy;
    public TableColumn tableColumnSearchFolderVisiteType;
    public TableColumn tableColumnSearchFolderToDo;
    public TableColumn tableColumnSearchFolderAction;
    public TableColumn tableColumnSearchVisitDate;
    public TableColumn tableColumnSearchVisitNameSurname;
    public TableColumn tableColumnSearchVisitPlace;
    public TableColumn tableColumnSearchVisitType;
    public TableColumn tableColumnSearchVisitUserBy;
    public TableColumn tableColumnSearchVisitNoFolder;
    public TableColumn tableColumnSearchVisitPourcent;
    public TableColumn tableColumnSearchVisitToDo;
    public TableColumn tableColumnSearchVisitAction;
    public TableColumn tableColumnSearchSADateVisite;
    public TableColumn tableColumnSearchSANameSurname;
    public TableColumn tableColumnSearchSAProblematic;
    public TableColumn tableColumnSearchSAActionDo;
    public TableColumn tableColumnSearchSAUserBy;
    public TableColumn tableColumnSearchSAPourcent;
    public TableColumn tableColumnSearchSAToDo;
    public TableColumn tableColumnSearchSAAction;
    public BorderPane borderPane_folder_search;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        radioFolder.setSelected(true);
        tableViewSearchFolder.setVisible(true);
        tableViewSearchVisit.setVisible(false);
        tableViewSearchSubjectsActions.setVisible(false);
        check_all.setSelected(true);
    }


    public void onRadioFolder(ActionEvent actionEvent) {
        radioFolder.setSelected(true);
        radioVisit.setSelected(false);
        radioSujectsActions.setSelected(false);
        tableViewSearchFolder.setVisible(true);
        tableViewSearchVisit.setVisible(false);
        tableViewSearchSubjectsActions.setVisible(false);
    }

    public void onRadioVisit(ActionEvent actionEvent) {
        radioFolder.setSelected(false);
        radioVisit.setSelected(true);
        radioSujectsActions.setSelected(false);
        tableViewSearchFolder.setVisible(false);
        tableViewSearchVisit.setVisible(true);
        tableViewSearchSubjectsActions.setVisible(false);
    }

    public void onRadioSubjects(ActionEvent actionEvent) {
        radioFolder.setSelected(false);
        radioVisit.setSelected(false);
        radioSujectsActions.setSelected(true);
        tableViewSearchFolder.setVisible(false);
        tableViewSearchVisit.setVisible(false);
        tableViewSearchSubjectsActions.setVisible(true);
    }

    public void onCheckAll(ActionEvent actionEvent) {
        check_all.setSelected(true);
        check_mine.setSelected(false);
        check_todo.setSelected(false);
    }

    public void onCheckMine(ActionEvent actionEvent) {
        check_all.setSelected(false);
        check_mine.setSelected(true);
        check_todo.setSelected(false);
    }

    public void onCheckToDo(ActionEvent actionEvent) {
        check_all.setSelected(false);
        check_mine.setSelected(false);
        check_todo.setSelected(true);

    }
}
