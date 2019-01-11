package lincharageniy;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller {

    private ImageOperations io = new ImageOperations();

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
    protected void initialize() {

        viewButton.setOnAction(event -> {
            io.viewNetImage(urlFIeld.getText(), imageView);
        });

        cleanButton.setOnAction(event -> {
            io.cleanArea(urlFIeld, imageView);
        });

        savingButton.setOnAction(event -> {
            io.saveImage(imageView);
        });



    }
}
