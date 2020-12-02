package org.itstep;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App extends Application {

    @Override
    public void start(Stage stage) {
//        ImageView logoView = new ImageView();
//
//        Image image = new Image(pathToCard("itstep-logo.png"));
//
//        logoView.setImage(image);
//        logoView.setPreserveRatio(true);
//        logoView.setFitWidth(100);
//
//        playAnimation(logoView);
        // корневой узел
        Pane rootNode = new Pane();

        // метка - текст
        Label label = new Label("Hello World");
        label.setFont(Font.font("Arial", 25));
        label.setBackground(new Background(new BackgroundFill(Paint.valueOf("red"), null, null)));
        label.setTextFill(Paint.valueOf("white"));
        label.relocate(10, 10); // указываем местоположение метки - отступ по 10px сверху и слева

        // изображение
        Image image = new Image(pathToCard("cards/ace_of_clubs.png")); // загружаем изображение
        ImageView imageView = new ImageView(image);
        imageView.relocate(200, 10);
        imageView.setPreserveRatio(true); // сохраняем пропорции
        imageView.setFitWidth(100); // задаем размер изображения

        // поле ввода
        TextField textField = new TextField();
        textField.relocate(10, 80);

        // кнопки
        Button button = new Button("Push me");
        button.relocate(10, 130);
        button.setOnAction((event) -> label.setText(textField.getText()));

        // прямоугольник
        Rectangle rectangle = new Rectangle(150, 50);
        rectangle.setFill(Paint.valueOf("green"));

        // добавить метку в корневой узел
        rootNode.getChildren().add(rectangle);
        rootNode.getChildren().add(label);
        rootNode.getChildren().add(imageView);
        rootNode.getChildren().add(button);
        rootNode.getChildren().add(textField);

        // создать сцену
        Scene scene = new Scene(rootNode, 640, 480);

        // установить сцену в окне
        stage.setScene(scene);
        stage.setTitle("Simple application in JavaFX");
        stage.getIcons().add(new Image("icon.png"));
        stage.show();
    }

    private String pathToCard(String cardFilename) {
        if(cardFilename == null) return null;
        String[] parts = cardFilename.split("/");
        return App.class.getClassLoader().getResource(parts[0]) + (parts.length == 2 ? parts[1] : "");
    }

    private void playAnimation(ImageView logoView) {
        //Creating scale Transition
        FadeTransition fadeTransition = new FadeTransition();
        ScaleTransition scaleTransition = new ScaleTransition();

        final Duration duration = Duration.millis(1500);

        //Setting the duration for the transition
        scaleTransition.setDuration(duration);
        fadeTransition.setDuration(duration);

        //Setting the node for the transition
        scaleTransition.setNode(logoView);
        fadeTransition.setNode(logoView);

        //Setting the dimensions for scaling
        scaleTransition.setByY(2);
        scaleTransition.setByX(2);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        //Setting the cycle count for the translation
        //scaleTransition.setCycleCount(50);

        //Setting auto reverse value to true
        scaleTransition.setAutoReverse(true);

        scaleTransition.play();
        fadeTransition.play();
    }

    public static void main(String[] args) throws URISyntaxException {
        launch();
    }

}