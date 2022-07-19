
package org.diegoflores.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
 * @date 16/04/2021
 * @time 16:55:37
 */
public class Principal extends Application{

    
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       Parent root= FXMLLoader.load(getClass().getResource("../org/diegoflores/view/FXMLvista.fxml"));
       Scene scene=new Scene(root);
       
       stage.setTitle("Calculator");
       stage.setResizable(false);
       stage.setScene(scene);
       stage.show();
    }

}
