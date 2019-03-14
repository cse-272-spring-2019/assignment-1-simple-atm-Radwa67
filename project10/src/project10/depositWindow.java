
package project10;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class depositWindow {
    History history;
    MyAtm myatm;
    Stage stage;
    Scene scene;
    HomeScreen homeScreen;
    public depositWindow(Stage stage, MyAtm myatm, History history){
    this.stage= stage;
    this.myatm = myatm;
    this.history = history;
    }
    public void prepareScreen(){
    Label Deposit = new Label ("Deposit here");
    Button enter = new Button("enter");
    Button back = new Button ("back to home");
     TextField deposit = new TextField();
   String m = deposit.getText();
    GridPane grid = new GridPane();
    grid.add(deposit,1,2);
    grid.add(enter,1,5);
    grid.add(Deposit,1,1);
    grid.add(back,1,9);
    
    scene = new Scene(grid, 600, 400);
       deposit.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event){
           
        stage.setScene(homeScreen.getScene());
        
    }
     });
    enter.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent event){
              int value = Integer.parseInt(deposit.getText());
            double Value = (double)value;
            myatm.deposit(Value);
            history.historyNavigation.add("Deposit "+Value);
            history.i++;
            stage.setScene(homeScreen.getScene());  
        }
    }
    );
    back.setOnAction(new EventHandler<ActionEvent>(){
        public void handle (ActionEvent event){
            stage.setScene(homeScreen.getScene());
        }
    });
    }
     public Scene getScene(){
    return scene;
    }
public void setHomeScreen (HomeScreen homeScreen){
this.homeScreen = homeScreen;
}  

}
