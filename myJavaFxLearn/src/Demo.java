import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Demo extends Application {

    private static final int CIRCLE_RADIUS = 50;
    private static final int CIRCLE_SPEED = 5;

    private Circle redCircle;
    private Circle blueCircle;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.WHITE);

        redCircle = new Circle(CIRCLE_RADIUS, Color.RED);
        redCircle.setCenterX(scene.getWidth() / 2);
        redCircle.setCenterY(scene.getHeight() / 2);

        blueCircle = new Circle(CIRCLE_RADIUS, Color.BLUE);
        blueCircle.setCenterX(scene.getWidth() / 2);
        blueCircle.setCenterY(scene.getHeight() / 2);

        root.getChildren().addAll(redCircle, blueCircle);

        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));
        scene.setOnKeyReleased(event -> handleKeyRelease(event.getCode()));

        primaryStage.setScene(scene);
        primaryStage.show();

        Thread redCircleThread = new Thread(() -> {
            while (true) {
                // 红色圆的其他逻辑处理

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        redCircleThread.setDaemon(true);
        redCircleThread.start();

        Thread blueCircleThread = new Thread(() -> {
            while (true) {
                // 蓝色圆的其他逻辑处理

                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        blueCircleThread.setDaemon(true);
        blueCircleThread.start();
    }

    private void handleKeyPress(KeyCode keyCode) {
        switch (keyCode) {
            case W:
                blueCircle.setCenterY(blueCircle.getCenterY() - CIRCLE_SPEED);
                break;
            case S:
                blueCircle.setCenterY(blueCircle.getCenterY() + CIRCLE_SPEED);
                break;
            case A:
                blueCircle.setCenterX(blueCircle.getCenterX() - CIRCLE_SPEED);
                break;
            case D:
                blueCircle.setCenterX(blueCircle.getCenterX() + CIRCLE_SPEED);
                break;
            case UP:
                redCircle.setCenterY(redCircle.getCenterY() - CIRCLE_SPEED);
                break;
            case DOWN:
                redCircle.setCenterY(redCircle.getCenterY() + CIRCLE_SPEED);
                break;
            case LEFT:
                redCircle.setCenterX(redCircle.getCenterX() - CIRCLE_SPEED);
                break;
            case RIGHT:
                redCircle.setCenterX(redCircle.getCenterX() + CIRCLE_SPEED);
                break;
        }
    }

    private void handleKeyRelease(KeyCode keyCode) {
        // 处理按键释放事件的逻辑
    }

    public static void main(String[] args) {
        launch(args);
    }
}