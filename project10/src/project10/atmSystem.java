
package project10;

import javafx.application.Application;
import javafx.stage.Stage;


public class atmSystem extends Application {
     public static void main (String [] args){
    launch(args); 
    }
     
     @Override
    public void start(Stage primaryStage) throws Exception {
        MyAtm myatm = new MyAtm();
        History history = new History();
        primaryStage.setTitle("Welcome to our ATM");
        LoginForm loginForm = new LoginForm(primaryStage);
        HomeScreen homeScreen = new HomeScreen(primaryStage,myatm,history);
        finalWindow finalwindow = new finalWindow(primaryStage,myatm,history);
        depositWindow depositwindow = new depositWindow(primaryStage,myatm,history);
        finalwindow.prepareScreen();
        loginForm.prepareScene();
        homeScreen.prepareScene();
        depositwindow.prepareScreen();
        loginForm.setHomeScreen(homeScreen);
        homeScreen.setLoginForm(loginForm);
        homeScreen.setFinalWindow(finalwindow);
        finalwindow.setHomeScreen(homeScreen);
        depositwindow.setHomeScreen(homeScreen);
        homeScreen.setdepositWindow(depositwindow);
        primaryStage.setScene(loginForm.getScene());
        primaryStage.show();
    }
}
