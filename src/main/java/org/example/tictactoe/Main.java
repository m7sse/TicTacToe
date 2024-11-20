package org.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.tictactoe.controller.TicTacToeController;
import org.example.tictactoe.model.TicTacToeModel;
import org.example.tictactoe.model.Player;
import org.example.tictactoe.model.Computer;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        //  scenen med layouten från FXML
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);

        // spelmodellen, spelaren och datorn
        TicTacToeModel model = new TicTacToeModel();
        Player playerX = new Player('X');
        Computer computerO = new Computer('O');

        // controllern från FXML och sätter spelparametrar
        TicTacToeController controller = fxmlLoader.getController();
        controller.setGameParameters(model, playerX, computerO);

        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
