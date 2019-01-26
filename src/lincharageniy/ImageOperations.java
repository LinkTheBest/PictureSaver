package lincharageniy;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class ImageOperations {


    protected static final String firstPartPath = "C:/Users/";
    protected static final String secondPartPath = "/Downloads/";
    protected static String pictureRandomName = "";
    protected static String fullPath = "";
    protected static String pathUserName = "";

    //Getting users name
    protected void setPathUserName(String pathUserName) {
        this.pathUserName = pathUserName;

    }

    //creating random picture name
    protected static String creatingImageName() {
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        final int MAX_LENGHT = 6;
        StringBuilder sb = new StringBuilder(MAX_LENGHT);
        for (int i = 0; i < MAX_LENGHT; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        pictureRandomName = sb.toString();
        return pictureRandomName;
    }

    //Now we know the user name! It's time to create full path for saving
    protected static String setFullPath() {
        fullPath = fullPath.concat(firstPartPath + pathUserName + secondPartPath + creatingImageName()+ ".jpg");
        System.out.println(fullPath);
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
        } catch (IOException e) {
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setHeaderText(null);
            warnAlert.setTitle("Warning!");
            warnAlert.setHeaderText("IncorrectImage or filepath");
        }


    }
}



