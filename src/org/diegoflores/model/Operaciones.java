
package org.diegoflores.model;

/**
 *
 * @author Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
 * @date 21/04/2021
 * @time 08:29:01
 */
public abstract class Operaciones {
    //Atributos
    private float numero1, numero2, resultado;
    private String operador;
    
    //Constructores
    public Operaciones() {
    }

    public Operaciones(float numero1, float numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
    // Getter and Setter
    public float getNumero1() {
        return numero1;
    }

    protected void setNumero1(float numero1) {
        this.numero1 = numero1;
    }

    public float getNumero2() {
        return numero2;
    }

    protected void setNumero2(float numero2) {
        this.numero2 = numero2;
    }

    public float getResultado() {
        return resultado;
    }

    protected void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public String getOperador() {
        return operador;
    }

    protected void setOperador(String operador) {
        this.operador = operador;
    }
    
    public abstract float operar(float numero1, float numero2);
    
    @Override
    public String toString(){
        return " "+numero1+" "+operador+" "+numero2+"="+resultado;
    }
}
