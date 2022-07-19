/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.diegoflores.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.diegoflores.model.Division;
import org.diegoflores.model.Multiplicacion;
import org.diegoflores.model.Operaciones;
import org.diegoflores.model.Resta;
import org.diegoflores.model.Suma;
import org.diegoflores.model.Porcentaje;

/**
 * FXML Controller class
 *
 * @author Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
 */
public class FXMLvistaController implements Initializable {
   
    
    private float resultado=0, numero=0;
    private int contadorOperadores=0;
    private String operadorAnterior;
    private boolean ingresoNuevo=false;

    @FXML
    private Button btnAC;
    @FXML
    private Button btnMasMenos;
    @FXML
    private Button btnPorCiento;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnSiete;
    @FXML
    private Button btnOcho;
    @FXML
    private Button btnNueve;
    @FXML
    private Button btnMulti;
    @FXML
    private Button btnCuatro;
    @FXML
    private Button btnCinco;
    @FXML
    private Button btnSeis;
    @FXML
    private Button btnMenos;
    @FXML
    private Button btnUno;
    @FXML
    private Button btnDos;
    @FXML
    private Button btnTres;
    @FXML
    private Button btnMas;
    @FXML
    private Button btnCero;
    @FXML
    private Button btnPunto;
    @FXML
    private Button btnIgual;
    @FXML
    private Label lblOperacion;
    @FXML
    private Label lblResultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicAC(ActionEvent event) {
        limpiar();
    }
    
    public void limpiar(){
        lblOperacion.setText("");
        lblResultado.setText("");
        resultado=0;
        numero=0;
        operadorAnterior="";
        contadorOperadores=0;
    }

    @FXML
    private void clicMasMenos(ActionEvent event) {
        resultado=Float.parseFloat(lblResultado.getText());
        resultado=resultado*-1;
        lblResultado.setText(String.valueOf(this.resultado));
    }

    @FXML
    private void clicPorCiento(ActionEvent event) {
        calcular("%");
    }

    @FXML
    private void clicDiv(ActionEvent event) {
         calcular("÷");
    }

    @FXML
    private void clicSiete(ActionEvent event) {
         actualizarPantalla("7");
    }

    @FXML
    private void clicOcho(ActionEvent event) {
         actualizarPantalla("8");
    }

    @FXML
    private void clicNueve(ActionEvent event) {
        actualizarPantalla("9");
    }

    @FXML
    private void clicMulti(ActionEvent event) {
        calcular("×");
        
    }

    @FXML
    private void clicCuatro(ActionEvent event) {
        actualizarPantalla("4");
    }

    @FXML
    private void clicCinco(ActionEvent event) {
        actualizarPantalla("5");
    }

    @FXML
    private void clicSeis(ActionEvent event) {
       actualizarPantalla("6");
    }

    @FXML
    private void clicMenos(ActionEvent event) {
        calcular("-");
        // lblOperacion.setText(lblOperacion.getText()+"-");
    }

    @FXML
    private void clicUno(ActionEvent event) {
        actualizarPantalla("1");
    }

    @FXML
    private void clicDos(ActionEvent event) {
        actualizarPantalla("2");
    }

    @FXML
    private void clicTres(ActionEvent event) {
        actualizarPantalla("3");
    }

    @FXML
    private void clicMas(ActionEvent event) {
        calcular("+");
        //lblOperacion.setText(lblOperacion.getText()+"+");
        
    }

    @FXML
    private void clicCero(ActionEvent event) {
       actualizarPantalla("0");
    }

    @FXML
    private void clicPunto(ActionEvent event) {
        agregarPunto();
    }

    public void agregarPunto(){
        String cadena=lblOperacion.getText();
        System.out.print(cadena);
        if((cadena.length()<=0)){
            actualizarPantalla("0.");
        }else if(!(lblOperacion.getText().contains("."))){
            actualizarPantalla(".");
        }
        
    }

    @FXML
    private void clicIgual(ActionEvent event) {
        calcular(this.operadorAnterior);
        lblResultado.setText(String.valueOf(this.resultado));
        
    }
    
    public void actualizarPantalla(String digito){
        if(ingresoNuevo){
            lblOperacion.setText("");
        }
        lblOperacion.setText(lblOperacion.getText().concat(digito));
        ingresoNuevo=false;
    }
    
    public void calcular(String operador){
        
        if(!(lblOperacion.getText().equals(""))){
            
            String strPantallaOPeracion=lblOperacion.getText();
            
            if(ingresoNuevo==false){
                
                this.numero=Float.parseFloat(strPantallaOPeracion);
                contadorOperadores++;
                
                if(contadorOperadores==1){
                    
                    this.resultado=numero;
                }else if(contadorOperadores>=2){
                    
                    Operaciones op;
                    switch(this.operadorAnterior){
                        case "+":
                            op=new Suma();
                            this.resultado=op.operar(resultado, numero);
                            lblOperacion.setText(op.toString());
                            break;
                        case "-":
                            op=new Resta();
                            this.resultado=op.operar(resultado, numero);
                            lblOperacion.setText(op.toString());
                            break;
                        case "×":
                            op=new Multiplicacion();
                            this.resultado=op.operar(resultado, numero);
                            lblOperacion.setText(op.toString());
                            break;
                        case "÷":
                            op=new Division();
                            this.resultado=op.operar(resultado, numero);
                            lblOperacion.setText(op.toString());
                            break;
                        case "%":
                            op=new Porcentaje();
                            this.resultado=op.operar(resultado, numero);
                            lblOperacion.setText(op.toString());
                            break;
                    }
                    
                    lblResultado.setText(String.valueOf(this.resultado));
                }
            }
            this.operadorAnterior=operador;
        }
       ingresoNuevo=true;
    }
    
  
}
