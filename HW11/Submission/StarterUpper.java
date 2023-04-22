//I worked on the homework assignment alone, using only course materials.
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

/**
 * StarterUpper is a JavaFX application that allows users to create a list of
 * startup ideas and save them to a file.
 * @author Sagnik Nandi
 * @version 1.0
 */
public class StarterUpper extends Application {
    private final ArrayList<StartUpIdea> ideas = new ArrayList<StartUpIdea>();
    private final File file = new File("ideas.txt");
    /**
     * Launches the JavaFX application
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Adds a new StartUpIdea to the list of ideas
     * @param primaryStage current stage
     */
    public void start(Stage primaryStage) {

        int offset = 4;

        primaryStage.setTitle("Problem Ideation Form.");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        Label problemL = new Label("What is the problem?");
        grid.add(problemL, 0, 0);
        TextField problemTF = new TextField();
        grid.add(problemTF, 1, 0);
        Label custL = new Label("Who is the target customer?");
        grid.add(custL, 0, 1);
        TextField custTF = new TextField();
        grid.add(custTF, 1, 1);
        Label needL = new Label("How badly does the customer NEED this problem fixed (1-10)?");
        grid.add(needL, 0, 2);
        TextField needTF = new TextField();
        grid.add(needTF, 1, 2);
        Label effectL = new Label("How many people do you know who might experience this problem?");
        grid.add(effectL, 0, 3);
        TextField effectTF = new TextField();
        grid.add(effectTF, 1, 3);
        Label marketL = new Label("How big is the target market?");
        grid.add(marketL, 0, 4);
        TextField marketTF = new TextField();
        grid.add(marketTF, 1, 4);
        Label compL = new Label("Who are the competitors/existing solutions?");
        grid.add(compL, 0, 5);
        TextField compTF = new TextField();
        grid.add(compTF, 1, 5);

        Button addIdeaBtn = new Button();
        addIdeaBtn.setText("Add Current Idea");
        addIdeaBtn.setOnAction(
            event -> addIdeaEvent(problemTF.getText(), custTF.getText(), needTF.getText(), effectTF.getText(),
                marketTF.getText(), compTF.getText()));
        grid.add(addIdeaBtn, 0, 5 + offset);

        Button sortIdeaBtn = new Button();
        sortIdeaBtn.setText("Sort");
        sortIdeaBtn.setOnAction(event -> Collections.sort(ideas));
        grid.add(sortIdeaBtn, 1, 6 + offset);

        Button resetFeildBtn = new Button();
        resetFeildBtn.setText("Reset");
        resetFeildBtn.setOnAction(event -> {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setTitle("Confirm");
                a.setHeaderText("File Delete?");
                a.setContentText("Are you sure you want to delete this file and the list of ideas?");
                Optional<ButtonType> result = a.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    try {
                        file.delete();
                    } catch (Exception e) {
                        assert false;
                    }
                    problemTF.clear();
                    custTF.clear();
                    needTF.clear();
                    effectTF.clear();
                    marketTF.clear();
                    compTF.clear();
                    ideas.clear();
                }
            }
        );

        grid.add(resetFeildBtn, 0, 6 + offset);
        Button saveBtn = new Button();
        saveBtn.setText("Save Ideas");
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileUtil.saveIdeasToFile(ideas, file);
            }
        });
        grid.add(saveBtn, 1, 5 + offset);

        Scene scene = new Scene(grid, 600, 400);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Adds a new idea to the list of ideas
     * @param problem What is the problem?
     * @param targetCustomer Who is the target customer?
     * @param customerNeed How badly does the customer NEED this problem fixed (1-10)?
     * @param knownPeopleWithProblem How many people do you know who might experience this problem?
     * @param targetMarketSize How big is the target market?
     * @param competitors Who are the competitors/existing solutions?
     */
    public void addIdeaEvent(String problem, String targetCustomer, String customerNeed, String knownPeopleWithProblem,
                             String targetMarketSize, String competitors) {
        if (problem.equals("")
            || targetCustomer.equals("")
            || customerNeed.equals("")
            || knownPeopleWithProblem.equals("")
            || targetMarketSize.equals("")
            || competitors.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Bad Input");
            a.setHeaderText(null);
            a.setContentText("Please fill out all fields");
            a.showAndWait();
            return;
        }
        try {
            int cust = Integer.parseInt(customerNeed);
            int effect = Integer.parseInt(knownPeopleWithProblem);
            int market = Integer.parseInt(targetMarketSize);
            if (cust < 1 || cust > 10) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Bad Input");
                a.setHeaderText(null);
                a.setContentText("Customer Need must be between 1 and 10");
                a.showAndWait();
                return;
            }
            ideas.add(new StartUpIdea(problem, targetCustomer, cust, effect, market, competitors));
        } catch (NumberFormatException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Bad Input");
            a.setHeaderText(null);
            a.setContentText(e.getMessage());
            a.showAndWait();
        }
    }
}