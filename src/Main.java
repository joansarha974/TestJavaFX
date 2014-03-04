import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("view/HomeView.fxml"));
        root.getStylesheets().add("view/css/home.css");
        primaryStage.setTitle("Poppu");
        primaryStage.setScene(new Scene(root, 1980, 760));
        //primaryStage.show();

        //primaryStage.setTitle("Poppu");
        //Group root = new Group();
        //Scene scene = new Scene(root, 1980, 760, Color.AZURE);
        //MenuController menu = new MenuController();
        //root.getChildren().add(menu);
        //primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
