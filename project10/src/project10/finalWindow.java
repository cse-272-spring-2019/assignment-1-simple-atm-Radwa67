
package project10;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class finalWindow {
    History history;
   MyAtm myatm ;
    Stage stage;
    Scene scene;
    HomeScreen homeScreen;
    public finalWindow(Stage stage,MyAtm myatm,History history){
        this.stage = stage;
        this.myatm = myatm;
        this.history = history;
}
    public void prepareScreen(){
    Label ENTER = new Label ("Withdraw here");
    Label Amount = new Label( "Amount ");
    Button enter = new Button("enter");
    Label failed = new Label ();
    
    Button back = new Button ("back to home");
   TextField withdraw = new TextField();
   String k = withdraw.getText();
   
    GridPane grid = new GridPane();
    grid.add(ENTER, 0, 0);
    grid.add(enter, 1, 5);
    grid.add(Amount, 1, 1);
    grid.add(withdraw, 1, 2);
    grid.add(failed,1,7);
    grid.add(back, 1, 9);
    
    scene = new Scene(grid, 600, 400);
    
    enter.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event){
           
            int value = Integer.parseInt(withdraw.getText());
            double Value = (double)value;
            if(Value > myatm.getBalance()){
             failed.setText("INSUFFECIENT FUNDS!!");
             failed.setFont(new Font("verdana",20) );
              failed.setStyle("color: red");
              
            }else{
               
            myatm.withdraw(Value);
            history.historyNavigation.add("withdraw "+Value);
            history.i++;
            stage.setScene(homeScreen.getScene());
            
            }
         
            }
    
     });
    withdraw.setOnAction(new EventHandler<ActionEvent>(){
    public void handle(ActionEvent event){
    stage.setScene(homeScreen.getScene());
    }
    } );
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