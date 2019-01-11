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


public class ImageOperations {

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

    protected static void cleanArea(TextField url, ImageView imageView) {
        url.setText(null);
        imageView.setImage(null);

    }

    protected static void saveImage(ImageView imageView) {
        Image buffImage = imageView.getImage();
        BufferedImage endImage = SwingFXUtils.fromFXImage(buffImage, null);
        try {
            ImageIO.write(endImage, "jpg", new File("C:/Users/Papa/Downloads/PicSav/Pic.jpg"));
        } catch (IOException e) {
            Alert warnAlert = new Alert(Alert.AlertType.WARNING);
            warnAlert.setHeaderText(null);
            warnAlert.setTitle("Warning!");
            warnAlert.setHeaderText("IncorrectImage");
        }


    }
}



