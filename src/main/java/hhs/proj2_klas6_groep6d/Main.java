package hhs.proj2_klas6_groep6d;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {//Applicatie kan gestart worden vanaf LoginScherm class
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }//Dit verwijderen in Master

    public static void main(String[] args) {
        RewardsList rewardsList = new RewardsList();
        ArrayList<Rewards> arrayRewards = new ArrayList<>();
        arrayRewards.add(new Rewards("toilet", "twee minuten naar het toilet onder werktijd", 1, 4));
        arrayRewards.add(new Rewards("koffie", "een koffie betaald door werk", 2, 5));
        arrayRewards.add(new Rewards("uitje", "een uitje betaald door werk", 3, 70));
        rewardsList.addRewards(arrayRewards);
        rewardsList.printRewardLijst();
        launch();
    }//Verwijderen in master
}