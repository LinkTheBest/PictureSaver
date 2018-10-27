package ru.link.picsaver;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.net.URLConnection;

public class Controller {

    private Image netimage;
    private String urlstring;

    @FXML
    private Button downloadbutton;
    @FXML
    private Button cleanButton;
    @FXML
    private TextField urlarea;
    @FXML
    private ImageView iv;



    @FXML
    private void downloadButtonAction(){
        urlstring = urlarea.getText();
        try {
            netimage = new Image(urlstring);
        }catch (Throwable e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Invalid URL!");
            alert.showAndWait();
        }
        iv.setImage(netimage);

    }

    @FXML
    private void cleanButtonAction(){
        urlarea.setText(null);
        iv.setImage(null);

    }


}
