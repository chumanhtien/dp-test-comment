package views.screen.popup;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import views.screen.BaseScreenHandler;
import views.screen.ViewsConfig;

import java.io.IOException;

// ?? Vi phạm SRP:
// Vi phạm OCP: trong tương lai có thể có thêm nhiều loại Pop up nữa (VD: Warning), nên phải thay đổi mã nguồn trực tiếp (vi phạm close for modify)
// => Giải pháp: một lớp cha (interface) Popup, các lớp con kế thừa và override method của cha
// Vi phạm LSP: Do lớp PopupScreen kế thừa BaseScreenHandler không thể sử dụng các phương thức như getPreviousScreen(), getBController()...
public class PopupScreen extends BaseScreenHandler {

    @FXML
    ImageView icon;

    @FXML
    Label message;

    public PopupScreen(Stage stage) throws IOException{
        super(stage, ViewsConfig.POPUP_PATH);
    }

    private static PopupScreen popup(String message, String imagePath, Boolean undecorated) throws IOException{
        PopupScreen popup = new PopupScreen(new Stage());
        if (undecorated) popup.stage.initStyle(StageStyle.UNDECORATED);
        popup.message.setText(message);
        popup.setImage(imagePath);
        return popup;
    }

    public static void success(String message) throws IOException{
        popup(message, ViewsConfig.IMAGE_PATH + "/" + "tickgreen.png", true)
                .show(true);
    }

    public static void error(String message) throws IOException{
        popup(message, ViewsConfig.IMAGE_PATH + "/" + "tickerror.png", false)
                .show(false);
    }

    public static PopupScreen loading(String message) throws IOException{
        return popup(message, ViewsConfig.IMAGE_PATH + "/" + "loading.gif", true);
    }

    public void setImage(String path) {
        super.setImage(icon, path);
    }

    public void show(Boolean autoClose) {
        super.show();
        if (autoClose) close(0.8);
    }

    public void show(double time) {
        super.show();
        close(time);
    }

    public void close(double time) {
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
    }

    protected void setupData(Object dto) throws Exception {
    }

    protected void setupFunctionality() throws Exception {
    }
}
