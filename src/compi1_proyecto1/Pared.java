/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi1_proyecto1;

/**
 *
 * @author Mac
 */
public class Pared {
    
    public Design fondo;
    public int Xini, Xfinal, Yini, Yfinal;
    
    public Pared(Design fondo, int Xini, int Xfinal, int Yini, int Yfinal){
        this.fondo = fondo;
        this.Xini = Xini;
        this.Xfinal = Xfinal;
        this.Yini = Yini;
        this.Yfinal = Yfinal;
    }
    
}
