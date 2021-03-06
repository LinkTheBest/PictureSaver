package com.vk.lincharageniy.main.classes;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller {

    private ImageOperations io = new ImageOperations();
    private Web web = new Web();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField urlFIeld;

    @FXML
    private Button cleanButton;

    @FXML
    private ImageView imageView;

    @FXML
    private Button viewButton;

    @FXML
    private Button savingButton;

    @FXML
    private Button webButton;

    @FXML
    private Button set_as_wallpaper;


    @FXML
    protected void initialize() {

        viewButton.setOnAction(event -> {
            io.viewNetImage(urlFIeld.getText(), imageView);
            io.checkDimension(imageView);
        });

        cleanButton.setOnAction(event -> {
            io.cleanArea(urlFIeld, imageView);


        });

        savingButton.setOnAction(event -> {
            io.creatingImageName();
            io.setFullPath();
            io.saveImage(imageView);
            io.updatingName();
        });

        webButton.setOnAction(event -> {
            web.webWindow(urlFIeld.getText());
        });

        set_as_wallpaper.setOnAction(event -> {
            io.setWallpaper();

        });


    }
}
