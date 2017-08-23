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
public class Heroe {

    public String descripcion, imgPath, nombre;
    public int vida;

    public Heroe(String nombre, String imgPath, String descripcion, int vida) {
        this.nombre = nombre;
        this.imgPath = imgPath;
        this.descripcion = descripcion;
        this.vida = vida;
    }

    public void quitarVida(int a) {
        this.vida = this.vida - a;
    }

    public boolean isDead() {
        return vida <= 0;
    }

}
