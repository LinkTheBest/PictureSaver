package com.vk.lincharageniy.main.classes;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Web {

    protected void webWindow(String url) {

        // creating a "browser"
        WebView web_page = new WebView();
        WebEngine web_engine = web_page.getEngine();
        web_engine.load(url);

        //setting new scene parameters
        StackPane webPane = new StackPane();
        webPane.getChildren().add(web_page);
        Scene webScene = new Scene(webPane, 1280, 720);

        // New window (Stage)
        Stage windows = new Stage();
        windows.getIcons().setAll(new Image("com/vk/lincharageniy/res/Internet-web-browser.png"));
        windows.setTitle("WebView");
        windows.setResizable(false);
        windows.initModality(Modality.APPLICATION_MODAL);
        windows.setScene(webScene);
        windows.showAndWait();
    }
}
