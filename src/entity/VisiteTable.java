package entity;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by joanperny on 03/03/2014.
 */
public class VisiteTable {

    private ObservableList<Visit> visits;

    public VisiteTable(ObservableList<Visit> visit)
    {
        this.visits = visit;
    }

    public Node createTable(){
        TableView tableView = new TableView();
        ObservableList columns = tableView.getColumns();
        columns.add(createColumn("id", "ID"));
        columns.add(createColumn("date", "DATE"));
        columns.add(createColumn("remarks", "REMARKS"));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(this.visits);
        return tableView;
    }

    private TableColumn createColumn(String name, String caption) {
        TableColumn column = new TableColumn(caption);
        column.setCellValueFactory((new PropertyValueFactory<Visit, String>(name)));
        return column;
    }
}
