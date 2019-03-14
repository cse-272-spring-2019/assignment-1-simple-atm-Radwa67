
package project10;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class LoginForm {
    MyAtm myatm = new MyAtm();
    Stage stage;
    Scene scene;
    LoginAuthentication authentication = new LoginAuthentication();
   HomeScreen homeScreen;
    public LoginForm(Stage stage){
    this.stage = stage ;
    }
    
    public void prepareScene() {
        //drawing
        authentication = new LoginAuthentication();
        Label passwordLabel = new Label( "Cardnumber: ");
       
       PasswordField passwordField = new PasswordField();
       Button submit = new Button("enter");
        Label validationLabel = new Label ();
        GridPane grid = new GridPane();
        
        grid.add(passwordLabel,2, 1 );
        
        
        grid.add(passwordField, 2, 2 );
        grid.add(submit,2,3);
        grid.add(validationLabel,5,4);
        //actions
        submit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
            
           String password = passwordField.getText();                    
           boolean valid = authentication.validate(password);
           if(valid){
           //validationLabel.setText("Welcome to our atm" );
           stage.setScene(homeScreen.getScene());
           }
           else{
               validationLabel.setText("Wrong cardnumber");
               validationLabel.setFont(new Font("verdana",20) );
               validationLabel.setStyle("color: red");
           }
            }
        });
        scene = new Scene (grid, 600, 400);
    }
    public Scene getScene(){
    return this.scene;
    }
    public void setHomeScreen(HomeScreen homeScreen){
    this.homeScreen = homeScreen;
    }
}

