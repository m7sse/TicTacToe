module org.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.tictactoe.controller to javafx.fxml;
    opens org.example.tictactoe.model;
    opens org.example.tictactoe.view;
}
