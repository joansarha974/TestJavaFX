package controller;

import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by joanperny on 28/02/2014.
 */
public class MenuController extends Parent {
    public MenuController() throws ParseException, SQLException, ClassNotFoundException {
        BorderPane borderPane = new BorderPane();

        TabPane tabPaneGeneral = new TabPane();
        Tab tabHome = new Tab();
        Tab tabFolder = new Tab();
        Tab tabHotline = new Tab();
        Tab tabAnnuaire = new Tab();
        Tab tabDo = new Tab();
        Tab tabUser = new Tab();

        TabPane tabPaneFolder = new TabPane();
        Tab tabFolderFilter = new Tab();
        Tab tabFolderHome = new Tab();

        tabPaneGeneral.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPaneFolder.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPaneGeneral.setPrefWidth(1980.0);

        tabAnnuaire.setText("ANNUAIRE");
        tabDo.setText("A FAIRE");
        tabFolder.setText("DOSSIER");
        tabFolderFilter.setText("RECHERCHE / TRI / FILTRE");
        tabFolderHome.setText("DOSSIER");
        tabHotline.setText("HOTLINE");
        tabHome.setText("ACCEUIL");
        tabUser.setText("UTILISATEUR");

        // Menu Annuaire
        tabAnnuaire.setContent(new Rectangle(1980,760, Color.BLACK));

        // Menu A faire
        tabDo.setContent(new Rectangle(1980, 760, Color.BLACK));

        // Menu Folder filter
        tabFolderFilter.setContent(new Rectangle(1980, 760, Color.BLUE));

        // Menu Folder Home
            //tabFolderHome.setContent(new FolderController());

        // Menu Hotline
        tabHotline.setContent(new Rectangle(1980, 760, Color.ANTIQUEWHITE));

        // Menu Acceuil
        tabHome.setContent(new Rectangle(1980, 760, Color.ALICEBLUE));

        // Menu User
        tabUser.setContent(new Rectangle(1980, 760, Color.RED));

        // Sous Menu Folder

        tabPaneFolder.getTabs().addAll(tabFolderFilter, tabFolderHome);

        tabFolder.setContent(tabPaneFolder);

        // Menu General

        tabPaneGeneral.getTabs().addAll(tabHome, tabFolder, tabHotline, tabAnnuaire, tabDo, tabUser);

        borderPane.setCenter(tabPaneGeneral);

        // Add a view

        this.getChildren().add(borderPane);
    }
}
