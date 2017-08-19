/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi1_proyecto1;

import java.util.ArrayList;

/**
 *
 * @author Mac
 */
public class Compi1_Proyecto1 {

    public static ArrayList<Design> TodosDesigns = new ArrayList<>();
    public static ArrayList<String> ErroresSemanticos = new ArrayList<>();
    public static ArrayList<Background> TodosBackrounds = new ArrayList<>();
    public static ArrayList<Heroe> TodosHeroes = new ArrayList<>();
    public static ArrayList<Enemigo> TodosEnemigos = new ArrayList<>();

    public static ArrayList<Pared> TodasParedes = new ArrayList<>();
    public static ArrayList<EnemigoAct> EnemigosActivos = new ArrayList<>();
    public static ArrayList<HeroeAct> HeroesActivos = new ArrayList<>();
    public static ArrayList<ExtraAct> ExtrasActivos = new ArrayList<>();
    public static ArrayList<compi1_proyecto1.Error> erroresLex1 = new ArrayList<>();
    public static ArrayList<compi1_proyecto1.Error> erroresLex2 = new ArrayList<>();

    public static String nombreActual = "", imgPathActual = "", tipoActual = "", descripcion = "Personaje aburrido, sin ninguna descripcion interesante.";
    public static int vidaActual = 100, destruirActual = 0, creditosAct = 0;
    public static String categoriaActual = "";
    public static Meta meta = null;

    public static int anchoAct = -1, altoAct = -1, Xini = -1, Xfinal = -1, Yini = -1, Yfinal = -1;
    public static String nombreParedAct = "";
    public static Object[][] tablero;
    public static String[][] tableroImagenes;
    public static Background fondo;
    public static String strHTML2 = "", strHTML1 = "";

    public static void doerroresLex2(compi1_proyecto1.Error e) {
        erroresLex2.add(e);
    }

    public static void otroArch2(){
        HeroesActivos.clear();
        ExtrasActivos.clear();
        EnemigosActivos.clear();
        TodasParedes.clear();
    }
    
    public static void clearListas(){
        TodosDesigns.clear();
        TodosBackrounds.clear();
        TodosEnemigos.clear();
        TodosHeroes.clear();
        
    }
    
    public static void saveFondo(String nombre) {
        nombre = nombre.trim();
        String nomA = nombre.replace(nombre.substring(nombre.length() - 1), "");
        String nom = nomA.substring(1);
        boolean flag = false;
        for (int i = 0; i < TodosBackrounds.size(); i++) {
            if (TodosBackrounds.get(i).nombre.equalsIgnoreCase(nom)) {
                fondo = TodosBackrounds.get(i);
                System.out.println("fondo:" + fondo.nombre + ". " + fondo.imgPath);
                flag = true;
                i = TodosDesigns.size() + 1;
            }
        }
        if (flag == false) {
            ErroresSemanticos.add("El background escogido no existe.");
        }
    }

    public static void setMeta() {
        boolean flag = false;
        for (int i = 0; i < TodosDesigns.size(); i++) {
            if (TodosDesigns.get(i).nombre.equalsIgnoreCase(nombreActual) && TodosDesigns.get(i).tipo.equalsIgnoreCase("x-meta")
                    && Xini >= 0 && Xini <= anchoAct && Yini >= 0 && Yini <= altoAct) {
                meta = new Meta(TodosDesigns.get(i), Xini, Yini);
                flag = true;
                System.out.println("DESIGN META =>" + TodosDesigns.get(i).nombre);
                i = TodosDesigns.size() + 1;
            }
        }
        if (flag == false) {
            ErroresSemanticos.add("La meta no tiene un fondo existente.");
        }
        resetAllNew();

    }

    public static void setAncho(String ancho) {
        int x = Integer.parseInt(ancho);
        anchoAct = x;
    }

    public static void setAlto(String alto) {
        int x = Integer.parseInt(alto);
        altoAct = x;
        if (altoAct == anchoAct) {
            tablero = new Object[altoAct][altoAct];
            tableroImagenes = new String[altoAct][altoAct];
        }
    }

    public static void activarArma() {
//        System.out.println("ACTIVAR ARMA: " + nombreActual + ". " + Xini + ". " + Yini);
        boolean flag = false;
        for (Design TodosDesign : TodosDesigns) {
            if (TodosDesign.nombre.equalsIgnoreCase(nombreActual)) {
                if (TodosDesign.tipo.equalsIgnoreCase("x-bomba")) {
                    ExtrasActivos.add(new ExtraAct(TodosDesign, Xini, Yini, "bomba"));
                } else {
                    ExtrasActivos.add(new ExtraAct(TodosDesign, Xini, Yini, "arma"));
                }
                flag = true;
            }

        }
        if (flag == false) {
            ErroresSemanticos.add("El arma " + nombreActual + " no existe.");
        }
    }

    public static void activarBonus() {
//        System.out.println("ACTIVAR BONUS: " + nombreActual + ". " + Xini + ". " + Yini);
        boolean flag = false;
        for (Design TodosDesign : TodosDesigns) {
            if (TodosDesign.nombre.equalsIgnoreCase(nombreActual)) {
                ExtrasActivos.add(new ExtraAct(TodosDesign, Xini, Yini, "bonus"));
                flag = true;
            }

        }
        if (flag == false) {
            ErroresSemanticos.add("El bonus " + nombreActual + " no existe.");
        }
    }

    public static void activarHeroe() {
        //System.out.println("ACTIVAR HEROE: " + nombreActual + ". " + Xini + ". " + Yini);
        boolean flag = false;
        for (Heroe TodosHeroe : TodosHeroes) {
            if (TodosHeroe.nombre.equalsIgnoreCase(nombreActual)) {
                Heroe temp = new Heroe(nombreActual, imgPathActual, descripcion, Xini);
                HeroesActivos.add(new HeroeAct(TodosHeroe, Xini, Yini));
                flag = true;
            }
        }
        if (flag == false) {
            ErroresSemanticos.add("El heroe " + nombreActual + " no existe.");
        }
    }

    public static void activarEnemigo() {
        //System.out.println("ACTIVAR ENEMIGO: " + nombreActual + ". " + Xini + ". " + Yini);
        boolean flag = false;
        for (Enemigo TodosEnemigo : TodosEnemigos) {
            if (TodosEnemigo.nombre.equalsIgnoreCase(nombreActual)) {
                EnemigosActivos.add(new EnemigoAct(TodosEnemigo, Xini, Yini));
                flag = true;
            }
        }
        if (flag == false) {
            ErroresSemanticos.add("El enemigo " + nombreActual + " no existe.");
        }
    }

    public static void setNamePared(String nombre) {
        nombre = nombre.trim();
        String nomA = nombre.replace(nombre.substring(nombre.length() - 1), "");
        nombreParedAct = nomA;
    }

    public static void nuevaPared() {
        boolean flag = false;
        for (int i = 0; i < TodosDesigns.size(); i++) {
            if (TodosDesigns.get(i).nombre.equalsIgnoreCase(nombreParedAct) && TodosDesigns.get(i).tipo.equalsIgnoreCase("x-bloque")) {
                TodasParedes.add(new Pared(TodosDesigns.get(i), Xini, Xfinal, Yini, Yfinal));
                flag = true;
                i = TodosDesigns.size() + 1;
            }
        }
        if (flag == false) {
            ErroresSemanticos.add("La pared " + nombreParedAct + " no tiene un fondo existente.");
        }
        resetAllNew();
    }

    public static void setXini(String X) {
        Xini = Integer.parseInt(X);
    }

    public static void setXfinal(String X) {
        Xfinal = Integer.parseInt(X);
    }

    public static void setYini(String Y) {
        Yini = Integer.parseInt(Y);
    }

    public static void setYfinal(String Y) {
        Yfinal = Integer.parseInt(Y);
    }

    public static void resetAllNew() {
        nombreActual = "";
        Xini = -1;
        Xfinal = -1;
        Yini = -1;
        Yfinal = -1;
        categoriaActual = "";
    }

    public static void doSomething() {
        switch (categoriaActual) {
            case "back":
                crearBack();
                break;
            case "figure":
                crearPersonaje();
                break;
            case "design":
                crearDesign();
                break;
        }
        resetAll();
    }

    public static void mostrar() {
//        System.out.println("BACKGROUNDS ----------------------------");
//        for (int i = 0; i < TodosBackrounds.size(); i++) {
//            System.out.println(TodosBackrounds.get(i).nombre + ". " + TodosBackrounds.get(i).imgPath);
//        }
//        System.out.println("HEROES ----------------------------");
//        for (int i = 0; i < TodosHeroes.size(); i++) {
//            System.out.println(TodosHeroes.get(i).nombre + ". " + TodosHeroes.get(i).imgPath);
//        }
//        System.out.println("ENEMIGOS ----------------------------");
//        for (int i = 0; i < TodosEnemigos.size(); i++) {
//            System.out.println(TodosEnemigos.get(i).nombre + ". " + TodosEnemigos.get(i).imgPath);
//        }
//        System.out.println("DESIGNS ----------------------------");
//        for (int i = 0; i < TodosDesigns.size(); i++) {
//            System.out.println(TodosDesigns.get(i).nombre + ". " + TodosDesigns.get(i).imgPath + ". " + TodosDesigns.get(i).tipo);
//        }
    }

    public static void crearDesign() {
        if (imgPathActual.trim().equals("") || nombreActual.trim().equals("") || tipoActual.trim().equals("")) {

        } else {
            if (tipoActual.trim().equalsIgnoreCase("x-bonus")) {
                TodosDesigns.add(new Design(nombreActual, imgPathActual, tipoActual, destruirActual, creditosAct));
            } else {
                TodosDesigns.add(new Design(nombreActual, imgPathActual, tipoActual, destruirActual));
            }
        }

    }

    public static void crearPersonaje() {
        if (imgPathActual.trim().equals("") || nombreActual.trim().equals("") || tipoActual.trim().equals("")) {

        } else {
            if (tipoActual.equalsIgnoreCase("x-enemigo") && destruirActual > 0 && destruirActual < 101
                    && (destruirActual % 10 == 0) && (vidaActual % 10 == 0) && vidaActual > 0 && vidaActual < 101) {
                TodosEnemigos.add(new Enemigo(nombreActual, imgPathActual, descripcion, vidaActual, destruirActual));
            } else if (tipoActual.equalsIgnoreCase("x-heroe") && (vidaActual % 10 == 0) && vidaActual > 0 && vidaActual < 101
                    && destruirActual == 0) {
                TodosHeroes.add(new Heroe(nombreActual, imgPathActual, descripcion, vidaActual));
            }
        }

    }

    public static void crearBack() {
        if (imgPathActual.trim().equals("") || nombreActual.trim().equals("")) {

        } else {
            TodosBackrounds.add(new Background(nombreActual, imgPathActual));
        }
    }

    public static void resetAll() {
        nombreActual = "";
        imgPathActual = "";
        tipoActual = "";
        descripcion = "Personaje aburrido, sin ninguna descripcion interesante.";
        vidaActual = 100;
        destruirActual = 0;
        creditosAct = 0;
    }

    public static void updateCreditos(String c) {
        int x = Integer.parseInt(c);
        creditosAct = x;
    }

    public static void updateCategoria(String cat) {
        categoriaActual = cat;
    }

    public static void updateNameArch2(String nombre) {
        nombre = nombre.trim();
        String nomA = nombre.replace(nombre.substring(nombre.length() - 1), "");
        nombreActual = nomA;
    }

    public static void updateName(String nombre) {
        nombre = nombre.trim();
        String nomA = nombre.replace(nombre.substring(nombre.length() - 1), "");
        String nom = nomA.substring(1);
        nombreActual = nom;
    }

    public static void updateImg(String path) {
        path = path.trim();
        String nomA = path.replace(path.substring(path.length() - 1), "");
        String nomB = nomA.replace(nomA.substring(nomA.length() - 1), "");
        imgPathActual = nomB;
    }

    public static void updateTipo(String tipo) {
        tipoActual = tipo;
    }

    public static void updateDescripcion(String des) {
        des = des.trim();
        if (des.startsWith("\"")) {
            String nomA = des.replace(des.substring(des.length() - 1), "");
            String nomB = nomA.replace(nomA.substring(nomA.length() - 1), "");
            descripcion = nomB;
        } else {
            descripcion = des;
        }
    }

    public static void updateVida(String vida) {
        int x = Integer.parseInt(vida);
        vidaActual = x;
    }

    public static void updateDestruir(String destruir) {
        int x = Integer.parseInt(destruir);
        destruirActual = x;
    }

    public static void main(String[] args) {
        Menu.start();
        //Juego.start(0);
    }

}
