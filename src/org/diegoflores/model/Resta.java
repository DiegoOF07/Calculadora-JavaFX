
package org.diegoflores.model;

/**
 *
 * @author Diego Oswaldo Flores Rivas <dflores-2020010@kinal.edu.gt>
 * @date 21/04/2021
 * @time 09:10:12
 */
public class Resta extends Operaciones {

    @Override
    public float operar(float numero1, float numero2) {
        this.setNumero1(numero1);
        this.setNumero2(numero2);
        this.setOperador("-");
        this.setResultado(this.getNumero1()-this.getNumero2());
        return this.getResultado();
    }
    

}
