
package project10;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class HomeScreen {
    
    History history;
    Stage stage;
    Scene scene;
    LoginForm loginForm;
    finalWindow finalwindow;
   depositWindow depositwindow;
    MyAtm myatm;
    public HomeScreen(Stage stage, MyAtm myatm,History history){
        this.stage = stage;   
        this.myatm = myatm;
        this.history = history;
    }
    public void prepareScene(){
        
       Label Welcome = new Label ("welcome to the ATM machine");
       Label balance = new Label();
    Button logout = new Button("Logout");
    Button withdraw = new Button ("withdraw");
    Button deposit = new Button ("Deposit");
    Button BalanceInquiry = new Button ("your balance");
    Label result = new Label ();
    //Label next = new Label ();
    Button prev1 = new Button ("prev");
    Button next1 = new Button ("next");
            
    
    GridPane grid = new GridPane();
    grid.add(Welcome, 0, 0);
    grid.add(logout, 1, 8);
    grid.add(withdraw, 1, 3);
    grid.add(deposit,1,4);
    grid.add(BalanceInquiry,1,5);
    grid.add(result,2,6);
    //grid.add(next,2,7);
    grid.add(balance, 2,5 );
    grid.add(prev1, 1, 6);
    grid.add(next1, 1, 7);
    withdraw.setOnAction(new EventHandler <ActionEvent>(){
    
    public void handle(ActionEvent event){
        stage.setScene(finalwindow.getScene());
    }   });
    logout.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event){
        stage.setScene(loginForm.getScene());
        } });
    withdraw.setOnAction(new EventHandler<ActionEvent>(){
    
    public void handle(ActionEvent event){
        history.i = history.historyNavigation.size();
        stage.setScene(finalwindow.getScene());
    }});
     deposit.setOnAction(new EventHandler <ActionEvent>(){
    
    public void handle(ActionEvent event){
        history.i = history.historyNavigation.size();
        stage.setScene(depositwindow.getScene());
        
    }   });
    BalanceInquiry.setOnAction(new EventHandler <ActionEvent>(){
    
    public void handle(ActionEvent event){
        history.i = history.historyNavigation.size();
        
        double x = myatm.getBalance();
        history.historyNavigation.add("Balance Inquiry:  "+x);
        balance.setText("  "+x);
        
        
    }   });
    next1.setOnAction(new EventHandler<ActionEvent>(){
    public void handle (ActionEvent event){
        if(history.i<history.historyNavigation.size()-1)
        {
            history.i++;
        result.setText(history.historyNavigation.get(history.i));   
        }
        else 
        {
            
            result.setText("no more operations");
            history.i++;
        }
        
        
    }});
    prev1.setOnAction(new EventHandler<ActionEvent>(){
    
    public void handle(ActionEvent event){
        if (history.i>0)
        {
                    history.i--;
        result.setText(history.historyNavigation.get(history.i));
        }
        else
        {
            
            result.setText("This was the last Transaction");
            history.i--;
        }
        
    }});
    
    scene = new Scene (grid, 600, 400);        
    }
    public Scene getScene(){
    return this.scene;
    }
public void setLoginForm (LoginForm loginForm){
this.loginForm = loginForm;
}  
    public void setFinalWindow(finalWindow finalwindow) {
        this.finalwindow = finalwindow;
    }

    void setdepositWindow(depositWindow depositwindow) {
        this.depositwindow = depositwindow;
    }

    
}
