package com.vk.lincharageniy;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Web {

    protected  void webWindow(){

        StackPane webPane = new StackPane();
        Scene webScene = new Scene(webPane, 720, 400);

        // New window (Stage)
        Stage windows = new Stage();
        windows.getIcons().setAll();
        windows.setTitle("WebView");
        windows.setScene(webScene);
        windows.show();
    }
}
