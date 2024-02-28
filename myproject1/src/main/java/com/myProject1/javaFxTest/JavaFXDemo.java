package com.myProject1.javaFxTest;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JavaFXDemo extends Application {
    private TextFlow textFlow;
    private FileChooser fileChooser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 创建选择文件标签
        Label label = new Label("选择文件：");

        // 创建文本域
        textFlow = new TextFlow();
        textFlow.setPrefWidth(400);
        textFlow.setPrefHeight(300);

        // 创建滚动面板，并将文本域添加到其中
        ScrollPane scrollPane = new ScrollPane(textFlow);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        // 创建选择文件按钮
        Button button = new Button("选择文件");

        // 创建水平布局，将选择文件标签和选择文件按钮添加到其中
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(label, button);

        // 创建边界布局，并将水平布局和滚动面板添加到其中
        BorderPane root = new BorderPane();
        root.setTop(hbox);
        root.setCenter(scrollPane);

        // 创建一个Scene，并将边界布局设置为根节点
        Scene scene = new Scene(root, 400, 350);

        // 创建文件选择器
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        // 添加事件处理程序来选择文件并更新文本域内容
        button.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                updateTextArea(file);
            }
        });

        // 设置初始Scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Demo");
        primaryStage.show();
    }

    private void updateTextArea(File file) {
        textFlow.getChildren().clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                Text text = new Text(line + "\n");
                text.setFont(Font.font("Arial", 12));
                textFlow.getChildren().add(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}