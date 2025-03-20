package fr.studi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//On utilise "start" pour commencer, pas le main classique

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //try/catch pour prévenir un éventuel problème au chargement du FXML
        try {
            //Chargement du fichier FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/calculator.fxml"));
            //FXML envoyé vers root
            Parent root = loader.load();
            //Création et initialisation de la scène = UI
            Scene scene = new Scene(root);
            //Ajout de la scene à l'exécution en cours
            stage.setTitle("Calculator app");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
