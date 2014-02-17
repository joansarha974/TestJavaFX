package controller.login;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by joanperny on 17/02/2014.
 */
public class Login {
    public TextField LoginField;
    public Label messageLabel;

    public void onSignIn(ActionEvent actionEvent) {
        if (LoginField.getText().isEmpty()){
            messageLabel.setText("Login is missing");
        } else {
            messageLabel.setText("");
        }
    }
}
