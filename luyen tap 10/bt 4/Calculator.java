package btjava4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {
    
    private TextField display;
    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";
    private boolean startNewInput = true;
    
    @Override
    public void start(Stage primaryStage) {
        // Tạo màn hình hiển thị
        display = new TextField();
        display.setFont(Font.font("Arial", 24));
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setEditable(false);
        display.setPrefHeight(80);
        display.setStyle("-fx-background-color: #f0f0f0; -fx-text-fill: #000000;");
        
        // Tạo grid chứa các nút
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        // Mảng các nút
        String[][] buttons = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", "C", "=", "+"},
            {".", "√", "%", "CE"}
        };
        
        // Thêm các nút vào grid
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                String buttonText = buttons[i][j]; // Lưu giá trị vào biến
                Button button = new Button(buttonText);
                button.setFont(Font.font("Arial", 18));
                button.setPrefSize(80, 60);
                button.setStyle("-fx-background-color: #e0e0e0; -fx-text-fill: #000000;");
                
                // Style đặc biệt cho nút toán tử
                if (buttonText.equals("+") || buttonText.equals("-") ||
                    buttonText.equals("*") || buttonText.equals("/") ||
                    buttonText.equals("=")) {
                    button.setStyle("-fx-background-color: #ff9800; -fx-text-fill: white;");
                } else if (buttonText.equals("C") || buttonText.equals("CE")) {
                    button.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
                } else if (buttonText.equals("√") || buttonText.equals("%")) {
                    button.setStyle("-fx-background-color: #4caf50; -fx-text-fill: white;");
                }
                
                // Sửa lỗi ở đây: dùng buttonText thay vì buttons[i][j]
                button.setOnAction(e -> handleButtonClick(buttonText));
                grid.add(button, j, i);
            }
        }
        
        // Layout chính
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(display, grid);
        
        // Tạo scene và hiển thị
        Scene scene = new Scene(root, 400, 500);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    private void handleButtonClick(String value) {
        // Xử lý số và dấu thập phân
        if (value.matches("[0-9]") || value.equals(".")) {
            if (startNewInput) {
                display.clear();
                startNewInput = false;
            }
            display.setText(display.getText() + value);
        }
        // Xử lý toán tử
        else if (value.equals("+") || value.equals("-") || 
                 value.equals("*") || value.equals("/")) {
            if (!startNewInput) {
                num1 = Double.parseDouble(display.getText());
                operator = value;
                startNewInput = true;
            }
        }
        // Xử lý dấu =
        else if (value.equals("=")) {
            if (!startNewInput && !operator.isEmpty()) {
                num2 = Double.parseDouble(display.getText());
                double result = calculate();
                display.setText(String.valueOf(result));
                startNewInput = true;
                operator = "";
            }
        }
        // Xử lý xóa (C)
        else if (value.equals("C")) {
            display.clear();
            num1 = num2 = 0;
            operator = "";
            startNewInput = true;
        }
        // Xử lý xóa hết (CE)
        else if (value.equals("CE")) {
            display.clear();
            startNewInput = true;
        }
        // Xử lý căn bậc 2
        else if (value.equals("√")) {
            try {
                double num = Double.parseDouble(display.getText());
                if (num >= 0) {
                    double result = Math.sqrt(num);
                    display.setText(String.valueOf(result));
                    startNewInput = true;
                } else {
                    display.setText("Lỗi: Số âm");
                }
            } catch (Exception e) {
                display.setText("Lỗi");
            }
        }
        // Xử lý phần trăm
        else if (value.equals("%")) {
            try {
                double num = Double.parseDouble(display.getText());
                double result = num / 100;
                display.setText(String.valueOf(result));
                startNewInput = true;
            } catch (Exception e) {
                display.setText("Lỗi");
            }
        }
    }
    
    private double calculate() {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    display.setText("Lỗi: Chia cho 0");
                    return 0;
                }
            default:
                return 0;
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}