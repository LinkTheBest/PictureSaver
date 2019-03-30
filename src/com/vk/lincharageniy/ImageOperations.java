package com.vk.lincharageniy;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class ImageOperations {


    protected static final String firstPartPath = "C:\\Users\\";
    protected static final String secondPartPath = "\\Downloads\\";
    protected static final String userName = System.getProperty("user.name");
    protected static String pictureRandomName = "";
    protected static String fullPath = "";
    private static boolean flag;

    //creating random picture name
    protected static String creatingImageName() {
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        final int MAX_LENGHT = 9;
        StringBuilder sb = new StringBuilder(MAX_LENGHT);
        for (int i = 0; i < MAX_LENGHT; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        pictureRandomName = sb.toString();
        return pictureRandomName;
    }

    //Setting fullPath to null, because we need to create new name every time for the new image
    protected static String updatingName() {
        fullPath = "";
        return fullPath;
    }

    //Now we know the user name! It's time to create full path for saving
    protected static String setFullPath() {
        fullPath = fullPath.concat(firstPartPath + userName + secondPartPath + creatingImageName() + ".jpg");
        //System.out.println(fullPath);
        return fullPath;
    }


    // viewing the image in the window
    protected static void viewNetImage(String url, ImageView iv) {
        String str = url;
        try {
            Image image = new Image(str);
            iv.setImage(image);
        } catch (Throwable e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Enter valid url!");
            alert.show();
        }
    }

    // cleaning area (except users name)
    protected static void cleanArea(TextField url, ImageView imageView) {
        url.setText(null);
        imageView.setImage(null);
    }

    //Saving image
    protected static void saveImage(ImageView imageView) {
        Image buffImage = imageView.getImage();
        BufferedImage endImage = SwingFXUtils.fromFXImage(buffImage, null);
        try {
            ImageIO.write(endImage, "jpg", new File(fullPath));
        } catch (Throwable e) {
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setHeaderText(null);
            warnAlert.setTitle("Warning!");
            warnAlert.setHeaderText("IncorrectImage or filepath");
            warnAlert.show();
        }


    }

    // new function which checks if image resolution matches ur screen resolution
    protected static void checkDimension(ImageView imageView) {

        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
        int vert = screen_size.height;
        int hor = screen_size.width;

        BufferedImage buff_image;
        int image_height = 0;
        int image_width = 0;

        try {
            Image temp_image = imageView.getImage();
            buff_image = SwingFXUtils.fromFXImage(temp_image, null);
            image_height = buff_image.getHeight();
            image_width = buff_image.getWidth();
        } catch (Exception e) {
        }

        if ((vert <= image_height) && (hor <= image_width)) {
            flag = true;
        } else {
            flag = false;
        }

        System.out.println(image_height);
        System.out.println(image_width);
        System.out.println("==========");
        System.out.println(vert);
        System.out.println(hor);
        System.out.println("==========");
        System.out.println(vert <= image_height);
    }


    protected static void setWallpaper() {

        // check if picture dimension matches ur screen dimension
        if (true) {
            WallpaperSetter wallpaper_setter = new WallpaperSetter();
            wallpaper_setter.setWallpaper(setFullPath());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Picture dimension does not match your screeen dimension!");
            alert.setHeaderText("Warning!");
            alert.showAndWait();

        }

    }


}



