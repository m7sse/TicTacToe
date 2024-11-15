module org.example.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.tictactoe to javafx.fxml;
    exports org.example.tictactoe;
    exports org.example.tictactoe.controller;
    opens org.example.tictactoe.controller to javafx.fxml;
    exports org.example.tictactoe.view;
    opens org.example.tictactoe.view to javafx.fxml;
    exports org.example.tictactoe.model;
    opens org.example.tictactoe.model to javafx.fxml;
}
