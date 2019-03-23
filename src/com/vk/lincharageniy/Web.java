package com.vk.lincharageniy;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Web {

    protected  void webWindow(){

        StackPane webPane = new StackPane();
        Scene webScene = new Scene(webPane, 720, 400);

        // New window (Stage)
        Stage windows = new Stage();
        windows.getIcons().setAll(new Image("com/vk/lincharageniy/res/Internet-web-browser.png"));
        windows.setTitle("WebView");
        windows.setScene(webScene);
        windows.show();
    }
}
