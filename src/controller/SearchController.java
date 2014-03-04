package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by joanperny on 17/02/2014.
 */
public class SearchController implements Initializable {
    public VBox search_by;
    public AnchorPane search_label;
    public CheckBox check_todo;
    public CheckBox check_mine;
    public CheckBox check_all;
    public BorderPane borderPane_folder;
    public RadioButton radioFolder;
    public RadioButton radioVisit;
    public RadioButton radioSujectsActions;
    public TableView tableViewSearchFolder;
    public TableView tableViewSearchVisit;
    public TableView tableViewSearchSubjectsActions;
    public TableColumn tableViewSearchFolderDateVisite;
    public TableColumn tableViewSearchFolderNoFolder;
    public TableColumn tableViewSearchFolderNameSurname;
    public TableColumn tableViewSearchFolderBirthday;
    public TableColumn tableViewSearchFolderUserBy;
    public TableColumn tableViewSearchFolderVisiteType;
    public TableColumn tableViewSearchFolderToDo;
    public TableColumn tableViewSearchFolderAction;
    public TableColumn tableViewSearchVisitDate;
    public TableColumn tableViewSearchVisitNameSurname;
    public TableColumn tableViewSearchVisitPlace;
    public TableColumn tableViewSearchVisitType;
    public TableColumn tableViewSearchVisitUserBy;
    public TableColumn tableViewSearchVisitNoFolder;
    public TableColumn tableViewSearchVisitPourcent;
    public TableColumn tableViewSearchVisitToDo;
    public TableColumn tableViewSearchVisitAction;
    public TableColumn tableViewSearchSADateVisite;
    public TableColumn tableViewSearchSANameSurname;
    public TableColumn tableViewSearchSAProblematic;
    public TableColumn tableViewSearchSAActionDo;
    public TableColumn tableViewSearchSAUserBy;
    public TableColumn tableViewSearchSAPourcent;
    public TableColumn tableViewSearchSAToDo;
    public TableColumn tableViewSearchSAAction;

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
