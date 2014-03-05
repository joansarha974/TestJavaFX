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
 * Created by joanperny on 05/03/2014.
 */
public class HotlineSearchController implements Initializable {
    public TableView tableViewSearchHotlineStructure;
    public TableColumn tableColumnSearchHotlineDate;
    public TableColumn tableColumnSearchHotlineStructure;
    public TableColumn tableColumnSearchHotlineRefE;
    public TableColumn tableColumnSearchHotlineUserBy;
    public TableColumn tableColumnSearchHotlineTypeEntretien;
    public TableColumn tableColumnSearchHotlineToDo;
    public TableColumn tableColumnSearchFolderAction;
    public CheckBox check_all;
    public CheckBox check_mine;
    public CheckBox check_todo;
    public RadioButton radioStructure;
    public RadioButton radioEvent;
    public RadioButton radioSujectsActions;
    public AnchorPane search_label;
    public BorderPane borderPane_hotline_search;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

    public void onRadioStructure(ActionEvent actionEvent) {
        radioStructure.setSelected(true);
        radioEvent.setSelected(false);
        radioSujectsActions.setSelected(false);
        tableViewSearchHotlineStructure.setVisible(true);
    }

    public void onRadioEvent(ActionEvent actionEvent) {
        radioStructure.setSelected(false);
        radioEvent.setSelected(true);
        radioSujectsActions.setSelected(false);
    }

    public void onRadioSubjects(ActionEvent actionEvent) {
        radioStructure.setSelected(false);
        radioEvent.setSelected(false);
        radioSujectsActions.setSelected(true);
    }
}
