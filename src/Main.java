import entity.Folder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Parent root = FXMLLoader.load(getClass().getResource("view/HomeView.fxml"));
        //root.getStylesheets().add("view/css/home.css");
        //primaryStage.setTitle("PAPPU");
        //primaryStage.setScene(new Scene(root, 1980, 760));
        //primaryStage.show();

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        final ObservableList<Folder> items = FXCollections.<Folder> observableArrayList();


        primaryStage.setTitle("Poppu");
        Group root = new Group();
        Scene scene = new Scene(root, 1980, 760, Color.AZURE);

        Folder folder = new Folder();


        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
