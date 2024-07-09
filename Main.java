import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create labels for the scroll bars
        Label redLabel = new Label("Red");
        Label greenLabel = new Label("Green");
        Label blueLabel = new Label("Blue");
        Label opacityLabel = new Label("Opacity");

        // Create scroll bars
        ScrollBar redScrollBar = new ScrollBar();
        ScrollBar greenScrollBar = new ScrollBar();
        ScrollBar blueScrollBar = new ScrollBar();
        ScrollBar opacityScrollBar = new ScrollBar();

        // Set scroll bars' properties
        redScrollBar.setMax(255);
        greenScrollBar.setMax(255);
        blueScrollBar.setMax(255);
        opacityScrollBar.setMax(1.0);
        opacityScrollBar.setMin(0.0);

        // Create a label to display the text
        Label text = new Label("Colorful Text");
        text.setStyle("-fx-font-size: 24;");

        // Create a VBox and add the scroll bars and text
        VBox vbox = new VBox(10, redLabel, redScrollBar, greenLabel, greenScrollBar, blueLabel, blueScrollBar, opacityLabel, opacityScrollBar, text);
        vbox.setPadding(new javafx.geometry.Insets(20));

        // Add listeners to the scroll bars to change the text color
        ChangeListener<Number> colorChangeListener = (ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            double red = redScrollBar.getValue();
            double green = greenScrollBar.getValue();
            double blue = blueScrollBar.getValue();
            double opacity = opacityScrollBar.getValue();

            text.setTextFill(Color.rgb((int) red, (int) green, (int) blue, opacity));
        };

        redScrollBar.valueProperty().addListener(colorChangeListener);
        greenScrollBar.valueProperty().addListener(colorChangeListener);
        blueScrollBar.valueProperty().addListener(colorChangeListener);
        opacityScrollBar.valueProperty().addListener(colorChangeListener);

        // Create a scene and place it in the stage
        Scene scene = new Scene(vbox, 500, 350);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}