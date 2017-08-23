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
public class Enemigo {

    public String descripcion, imgPath, nombre;
    public int vida, destruir;

    public Enemigo(String nombre, String imgPath, String descripcion, int vida, int destruir) {
        this.nombre = nombre;
        this.imgPath = imgPath;
        this.descripcion = descripcion;
        this.vida = vida;
        this.destruir = destruir;
    }

    public boolean isDead() {
        return vida <= 0;
    }
}
