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
public class Design {

    public String nombre, imgPath, tipo;
    public int creditos, destruir;

    public Design(String nombre, String imgPath, String tipo, int destruir) {
        this.nombre = nombre;
        this.imgPath = imgPath;
        this.tipo = tipo;
        this.destruir = destruir;
    }

    public Design(String nombre, String imgPath, String tipo, int destruir, int creditos) {
        this.nombre = nombre;
        this.imgPath = imgPath;
        this.tipo = tipo;
        this.destruir = destruir;
        this.creditos = creditos;
    }
}
