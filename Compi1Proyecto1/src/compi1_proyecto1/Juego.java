/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi1_proyecto1;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mac
 */
public class Juego extends javax.swing.JFrame {

    static ExtraAct armaAct;
    static int n = 0;

    public Juego() {
        initComponents();
    }

    static void paintBack() {

        JLabel labl;
        int height = jPanel1.getHeight();
        int width = jPanel1.getWidth();
        String temp = Compi1_Proyecto1.fondo.imgPath;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(temp));
        } catch (IOException e) {
            System.out.println("error :/");
        }
        Image dimg = img.getScaledInstance(width, height,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        labl = new JLabel(imageIcon);
        labl.setSize(width, height);
        labl.setLocation(0, 0);
        jPanel1.add(labl);
    }

    static void eliminarLabel(int x, int y) {
        int height = jPanel4.getHeight();
        int width = jPanel4.getWidth();
        jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
        Compi1_Proyecto1.tableroImagenes[x][y] = null;
        Compi1_Proyecto1.tablero[x][y] = null;
        jPanel4.repaint();
        try {
            jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
            Compi1_Proyecto1.tableroImagenes[x][y] = null;
            Compi1_Proyecto1.tablero[x][y] = null;
            jPanel4.repaint();
        } catch (Exception e) {
        }
    }

    static void dibujarLabels() {
        Runnable runner = new Runnable() {
            public void run() {

                loading.setMaximum((n * n));
                String temp;
                int height = jPanel4.getHeight();
                int width = jPanel4.getWidth();
                JLabel labl;
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i < n; i++) {
                        if (i == 0 && j == 0) {
                            paintBack();
                        }
                        if (Compi1_Proyecto1.tableroImagenes[i][j] != null) {
                            temp = Compi1_Proyecto1.tableroImagenes[i][j];
                            BufferedImage img = null;
                            try {
                                img = ImageIO.read(new File(temp));
                            } catch (IOException e) {
                                System.out.println("error :/");
                            }
                            Image dimg = img.getScaledInstance(width / n, height / n,
                                    Image.SCALE_SMOOTH);
                            ImageIcon imageIcon = new ImageIcon(dimg);
                            labl = new JLabel(imageIcon);
                            labl.setSize(width / n, height / n);
                            labl.setLocation((width / n) * i, (height / n) * j);
                            jPanel4.add(labl);
                        }
                        up();
                    }
                    jPanel4.repaint();
                }
                int i = (int) Math.floor(Math.random() * (Compi1_Proyecto1.EnemigosActivos.size()));
                System.out.println(i + "i");
                moverEnemigoLeft(Compi1_Proyecto1.EnemigosActivos.get(i).X, Compi1_Proyecto1.EnemigosActivos.get(i).Y, Compi1_Proyecto1.EnemigosActivos.get(i).enemigo.imgPath, i);

            }
        };
        Thread t = new Thread(runner, "Code Executer");
        t.start();

    }

    static void moverIzq(final int x, final int y) {
        String temp;
        int height = jPanel4.getHeight();
        int width = jPanel4.getWidth();
        jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
        Compi1_Proyecto1.tableroImagenes[x][y] = null;
        Compi1_Proyecto1.tablero[x][y] = null;
        try {
            jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
            Compi1_Proyecto1.tableroImagenes[x][y] = null;
            Compi1_Proyecto1.tablero[x][y] = null;
        } catch (Exception e) {
        }
        JLabel labl;
        for (int j = (y); j < (y + 1); j++) {
            for (int i = (x - 1); i < (x); i++) {
                try {
                    if (Compi1_Proyecto1.tableroImagenes[i][j] != null) {
                        temp = Compi1_Proyecto1.tableroImagenes[i][j];
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(temp));
                        } catch (IOException e) {
                        }
                        Image dimg = img.getScaledInstance(width / n, height / n,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        labl = new JLabel(imageIcon);
                        labl.setSize(width / n, height / n);
                        labl.setLocation((width / n) * i, (height / n) * j);
                        jPanel4.add(labl);
                    }
                } catch (Exception e) {
                }

                jPanel4.repaint();
            }

        }
    }

    static void moverDer(final int x, final int y) {
        String temp;
        int height = jPanel4.getHeight();
        int width = jPanel4.getWidth();
        jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
        Compi1_Proyecto1.tableroImagenes[x][y] = null;
        Compi1_Proyecto1.tablero[x][y] = null;
        try {
            jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
            Compi1_Proyecto1.tableroImagenes[x][y] = null;
            Compi1_Proyecto1.tablero[x][y] = null;
        } catch (Exception e) {
        }
        JLabel labl;
        for (int j = (y); j < (y + 1); j++) {
            for (int i = (x + 1); i < (x + 2); i++) {
                try {
                    if (Compi1_Proyecto1.tableroImagenes[i][j] != null) {
                        temp = Compi1_Proyecto1.tableroImagenes[i][j];
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(temp));
                        } catch (IOException e) {
                        }
                        Image dimg = img.getScaledInstance(width / n, height / n,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        labl = new JLabel(imageIcon);
                        labl.setSize(width / n, height / n);
                        labl.setLocation((width / n) * i, (height / n) * j);
                        jPanel4.add(labl);
                    }
                } catch (Exception e) {
                }

                jPanel4.repaint();
            }

        }
    }

    static void moverUp(final int x, final int y) {
        String temp;
        int height = jPanel4.getHeight();
        int width = jPanel4.getWidth();
        jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
        Compi1_Proyecto1.tableroImagenes[x][y] = null;
        Compi1_Proyecto1.tablero[x][y] = null;
        try {
            jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
            Compi1_Proyecto1.tableroImagenes[x][y] = null;
            Compi1_Proyecto1.tablero[x][y] = null;
        } catch (Exception e) {
        }
        JLabel labl;
        for (int j = (y - 1); j < (y); j++) {
            for (int i = (x); i < (x + 1); i++) {
                try {
                    if (Compi1_Proyecto1.tableroImagenes[i][j] != null) {
                        temp = Compi1_Proyecto1.tableroImagenes[i][j];
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(temp));
                        } catch (IOException e) {
                        }
                        Image dimg = img.getScaledInstance(width / n, height / n,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        labl = new JLabel(imageIcon);
                        labl.setSize(width / n, height / n);
                        labl.setLocation((width / n) * i, (height / n) * j);
                        jPanel4.add(labl);
                    }
                } catch (Exception e) {
                }

                jPanel4.repaint();
            }

        }
    }

    static void moverDown(final int x, final int y) {
        String temp;
        int height = jPanel4.getHeight();
        int width = jPanel4.getWidth();
        jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
        Compi1_Proyecto1.tableroImagenes[x][y] = null;
        Compi1_Proyecto1.tablero[x][y] = null;
        try {
            jPanel4.remove(jPanel4.getComponentAt((width / n) * x, (height / n) * y));
            Compi1_Proyecto1.tableroImagenes[x][y] = null;
            Compi1_Proyecto1.tablero[x][y] = null;
        } catch (Exception e) {
        }
        JLabel labl;
        for (int j = (y + 1); j < (y + 2); j++) {
            for (int i = (x); i < (x + 1); i++) {
                try {
                    if (Compi1_Proyecto1.tableroImagenes[i][j] != null) {
                        temp = Compi1_Proyecto1.tableroImagenes[i][j];
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(temp));
                        } catch (IOException e) {
                        }
                        Image dimg = img.getScaledInstance(width / n, height / n,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        labl = new JLabel(imageIcon);
                        labl.setSize(width / n, height / n);
                        labl.setLocation((width / n) * i, (height / n) * j);
                        jPanel4.add(labl);
                    }
                } catch (Exception e) {
                }

                jPanel4.repaint();
            }

        }
    }

    static void updateVida() {
        jTextField1.setText("" + Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida);
        if (Compi1_Proyecto1.HeroesActivos.get(0).heroe.isDead() == true) {
            jPanel5.setVisible(false);
            jPanel6.setVisible(false);
            JOptionPane.showMessageDialog(null, "HAS PERDIDO O.o", "PERDISTE", JOptionPane.ERROR_MESSAGE);
        }
    }

    static boolean isEnemigo(Object o) {
        try {
            EnemigoAct e = (EnemigoAct) o;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isExit(Object o) {
        try {
            Meta m = (Meta) o;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean isExtra(Object o) {
        try {
            ExtraAct e = (ExtraAct) o;
            if (e.tipo.equalsIgnoreCase("arma")) {
                armaAct = e;
                armaText.setText(armaAct.extra.nombre);
                ataqueText.setText(armaAct.extra.destruir + "");
                eliminarLabel(e.X, e.Y);
            } else if (e.tipo.equalsIgnoreCase("bonus")) {
                int a = Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida;
                int b = e.extra.creditos;
                Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida = a + b;
                eliminarLabel(e.X, e.Y);
                updateVida();
            } else if (e.tipo.equalsIgnoreCase("bomba")) {
                int a = Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida;
                int b = e.extra.destruir;
                int c = a - b;
                Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida = c;
                eliminarLabel(e.X, e.Y);
                updateVida();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static void up() {
        loading.setStringPainted(true);
        loading.setValue(loading.getValue() + 1);
        jPanel2.repaint();
    }

    static void dispararDer(final int x, final int y) {
        Runnable runner = new Runnable() {
            public void run() {
                boolean detener = false;
                loading.setMaximum((n * n));
                String temp;
                int height = jPanel4.getHeight();
                int width = jPanel4.getWidth();
                JLabel labl;
                for (int i = (x + 1); i < n; i++) {
                    if (Compi1_Proyecto1.tableroImagenes[i][y] == null && detener == false) {
                        temp = armaAct.extra.imgPath;
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(temp));
                        } catch (IOException e) {
                            System.out.println("error :/");
                        }
                        Image dimg = img.getScaledInstance(width / n, height / n,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        labl = new JLabel(imageIcon);
                        labl.setSize(width / n, height / n);
                        labl.setLocation((width / n) * i, (height / n) * y);
                        jPanel4.add(labl);
                        jPanel4.repaint();
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        eliminarLabel(i, y);
                    } else if (detener == false) {
                        try {
                            EnemigoAct e = ((EnemigoAct) Compi1_Proyecto1.tablero[i][y]);
                            System.out.println(e.X + "," + e.Y + "--> e.x,e.y");
                            System.out.println(Compi1_Proyecto1.tablero[i][y]);
                            System.out.println(Compi1_Proyecto1.tableroImagenes[i][y]);
                            e.enemigo.vida = e.enemigo.vida - armaAct.extra.destruir;
                            if (e.enemigo.vida <= 0) {
                                eliminarLabel(i, y);
                            }
                        } catch (Exception e) {
                        }

                        detener = true;
                    }
                }
                jPanel4.repaint();

            }
        };
        Thread t = new Thread(runner, "Code Executer");
        t.start();

    }

    static void dispararIzq(final int x, final int y) {
        Runnable runner = new Runnable() {
            public void run() {
                boolean detener = false;
                loading.setMaximum((n * n));
                String temp;
                int height = jPanel4.getHeight();
                int width = jPanel4.getWidth();
                JLabel labl;
                for (int i = (x - 1); i >= 0; i--) {
                    if (Compi1_Proyecto1.tableroImagenes[i][y] == null && detener == false) {
                        temp = armaAct.extra.imgPath;
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(temp));
                        } catch (IOException e) {
                            System.out.println("error :/");
                        }
                        Image dimg = img.getScaledInstance(width / n, height / n,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        labl = new JLabel(imageIcon);
                        labl.setSize(width / n, height / n);
                        labl.setLocation((width / n) * i, (height / n) * y);
                        jPanel4.add(labl);
                        jPanel4.repaint();
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        eliminarLabel(i, y);
                    } else if (detener == false) {
                        try {
                            EnemigoAct e = ((EnemigoAct) Compi1_Proyecto1.tablero[i][y]);
                            System.out.println(e.X + "," + e.Y + "--> e.x,e.y");
                            System.out.println(Compi1_Proyecto1.tablero[i][y]);
                            System.out.println(Compi1_Proyecto1.tableroImagenes[i][y]);
                            e.enemigo.vida = e.enemigo.vida - armaAct.extra.destruir;
                            if (e.enemigo.vida <= 0) {
                                eliminarLabel(i, y);
                            }
                        } catch (Exception e) {
                        }

                        detener = true;
                    }
                }
                jPanel4.repaint();

            }
        };
        Thread t = new Thread(runner, "Code Executer");
        t.start();

    }

    static void dispararUp(final int x, final int y) {
        Runnable runner = new Runnable() {
            public void run() {
                boolean detener = false;
                loading.setMaximum((n * n));
                String temp;
                int height = jPanel4.getHeight();
                int width = jPanel4.getWidth();
                JLabel labl;
                for (int i = (y - 1); i >= 0; i--) {
                    if (Compi1_Proyecto1.tableroImagenes[x][i] == null && detener == false) {
                        temp = armaAct.extra.imgPath;
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(temp));
                        } catch (IOException e) {
                            System.out.println("error :/");
                        }
                        Image dimg = img.getScaledInstance(width / n, height / n,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        labl = new JLabel(imageIcon);
                        labl.setSize(width / n, height / n);
                        labl.setLocation((width / n) * x, (height / n) * i);
                        jPanel4.add(labl);
                        jPanel4.repaint();
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        eliminarLabel(x, i);
                    } else if (detener == false) {

                        try {
                            EnemigoAct e = ((EnemigoAct) Compi1_Proyecto1.tablero[x][i]);
                            System.out.println(e.X + "," + e.Y + "--> e.x,e.y");
                            System.out.println(Compi1_Proyecto1.tablero[x][i]);
                            System.out.println(Compi1_Proyecto1.tableroImagenes[x][i]);
                            e.enemigo.vida = e.enemigo.vida - armaAct.extra.destruir;
                            if (e.enemigo.vida <= 0) {
                                eliminarLabel(x, i);
                            }
                        } catch (Exception e) {
                        }
                        detener = true;
                    }
                }
                jPanel4.repaint();

            }
        };
        Thread t = new Thread(runner, "Code Executer");
        t.start();

    }

    static void dispararDown(final int x, final int y) {
        Runnable runner = new Runnable() {
            public void run() {
                boolean detener = false;
                loading.setMaximum((n * n));
                String temp;
                int height = jPanel4.getHeight();
                int width = jPanel4.getWidth();
                JLabel labl;
                for (int i = (y + 1); i < n; i++) {
                    if (Compi1_Proyecto1.tableroImagenes[x][i] == null && detener == false) {
                        temp = armaAct.extra.imgPath;
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new File(temp));
                        } catch (IOException e) {
                            System.out.println("error :/");
                        }
                        Image dimg = img.getScaledInstance(width / n, height / n,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);
                        labl = new JLabel(imageIcon);
                        labl.setSize(width / n, height / n);
                        labl.setLocation((width / n) * x, (height / n) * i);
                        jPanel4.add(labl);
                        jPanel4.repaint();
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        eliminarLabel(x, i);
                    } else if (detener == false) {
                        try {
                            EnemigoAct e = ((EnemigoAct) Compi1_Proyecto1.tablero[x][i]);
                            System.out.println(e.X + "," + e.Y + "--> e.x,e.y");
                            System.out.println(Compi1_Proyecto1.tablero[x][i]);
                            System.out.println(Compi1_Proyecto1.tableroImagenes[x][i]);
                            e.enemigo.vida = e.enemigo.vida - armaAct.extra.destruir;
                            if (e.enemigo.vida <= 0) {
                                eliminarLabel(x, i);
                            }
                        } catch (Exception e) {
                        }
                        detener = true;
                    }
                }
                jPanel4.repaint();

            }
        };
        Thread t = new Thread(runner, "Code Executer");
        t.start();

    }

    static void moverEnemigoLeft(final int x, final int y, final String img, final int index) {
        Runnable runner = new Runnable() {
            public void run() {
                loading.setMaximum((n * n));

                int cont = 0;
                for (int i = x - 1; i > -1; i--) {
                    if (Compi1_Proyecto1.tablero[i][y] == null) {
                        Compi1_Proyecto1.tablero[i][y] = Compi1_Proyecto1.tablero[i + 1][y];
                        Compi1_Proyecto1.tableroImagenes[i][y] = Compi1_Proyecto1.tableroImagenes[i + 1][y];
                        Compi1_Proyecto1.EnemigosActivos.get(index).X--;
                        eliminarLabel(i + 1, y);
                        dibujar(i, img, y);
                        jPanel4.repaint();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        cont++;
                        if (i == 0) {
                            moverEnemigoRight(i, y, img, index);
                        }
                    } else {
                        moverEnemigoRight(i + 1, y, img, index);
                        i = 0;
                        try {
                            System.out.println(((EnemigoAct) Compi1_Proyecto1.tablero[i][y]).enemigo.nombre);
                        } catch (Exception e) {
                            try {
                                System.out.println(Compi1_Proyecto1.tablero[i][y]);
                            } catch (Exception ee) {
                            }

                        }
                    }
                }
                System.out.println(cont + "-cont");
                jPanel4.repaint();

            }
        };
        Thread t = new Thread(runner, "Code Executer");
        t.start();

    }

    static void dibujar(int i, String imge, int y) {
        JLabel labl;
        int height = jPanel4.getHeight();
        int width = jPanel4.getWidth();
        String temp = imge;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(temp));
        } catch (IOException e) {
            System.out.println("error :/");
        }
        Image dimg = img.getScaledInstance(width / n, height / n,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        labl = new JLabel(imageIcon);
        labl.setSize(width / n, height / n);
        labl.setLocation((width / n) * i, (height / n) * y);
        jPanel4.add(labl);
    }

    static void moverEnemigoRight(final int x, final int y, final String img, final int index) {
        Runnable runner = new Runnable() {
            public void run() {
                boolean detener = false;
                loading.setMaximum((n * n));

                int cont = 0;
                for (int i = x + 1; i < n; i++) {
                    if (Compi1_Proyecto1.tablero[i][y] == null) {
                        Compi1_Proyecto1.tablero[i][y] = Compi1_Proyecto1.tablero[i - 1][y];
                        Compi1_Proyecto1.tableroImagenes[i][y] = Compi1_Proyecto1.tableroImagenes[i - 1][y];
                        Compi1_Proyecto1.EnemigosActivos.get(index).X++;
                        eliminarLabel(i - 1, y);
                        dibujar(i, img, y);
                        jPanel4.repaint();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (i == (n - 1)) {
                            moverEnemigoLeft(i, y, img, index);
                        }
                        cont++;
                    } else {
                        Compi1_Proyecto1.tablero[i - 1][y] = null;
                        Compi1_Proyecto1.tableroImagenes[i - 1][y] = null;
                        moverEnemigoLeft(i - 1, y, img, index);
                        i = n;
                        try {
                            System.out.println(((EnemigoAct) Compi1_Proyecto1.tablero[i][y]).enemigo.nombre);
                        } catch (Exception e) {
                            try {
                                System.out.println(Compi1_Proyecto1.tablero[i][y]);
                            } catch (Exception ee) {
                            }

                        }
                    }
                }
                System.out.println(cont + "-cont");
                jPanel4.repaint();
            }
        };
        Thread t = new Thread(runner, "Code Executer");
        t.start();
    }

    void pintarHeroe() {
        try {
            int x = Compi1_Proyecto1.HeroesActivos.get(0).X;
            int y = Compi1_Proyecto1.HeroesActivos.get(0).Y;
            Compi1_Proyecto1.tablero[x][y] = Compi1_Proyecto1.HeroesActivos.get(0);
            Compi1_Proyecto1.tableroImagenes[x][y] = Compi1_Proyecto1.HeroesActivos.get(0).heroe.imgPath;
            dibujar(x, Compi1_Proyecto1.HeroesActivos.get(0).heroe.imgPath, y);
            jPanel4.repaint();
        } catch (Exception e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        loading = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        armaText = new javax.swing.JTextField();
        ataqueText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(610, 640, 10, 10);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setOpaque(false);
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });
        jPanel1.setLayout(null);

        jPanel4.setOpaque(false);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 10, 580, 580);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 50, 600, 600);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(null);

        loading.setFont(new java.awt.Font("SF Atarian System", 0, 30)); // NOI18N
        loading.setFocusable(false);
        loading.setRequestFocusEnabled(false);
        loading.setStringPainted(true);
        jPanel2.add(loading);
        loading.setBounds(5, 5, 590, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 600, 40);

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setLayout(null);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        jLabel2.setFont(new java.awt.Font("SF Atarian System", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ViDa");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(10, 10, 240, 40);

        jTextField1.setFont(new java.awt.Font("AR CHRISTY", 0, 60)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("100");
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jTextField1.setEnabled(false);
        jTextField1.setOpaque(false);
        jPanel5.add(jTextField1);
        jTextField1.setBounds(10, 70, 240, 60);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(650, 50, 260, 160);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        jLabel3.setFont(new java.awt.Font("SF Atarian System", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PUNTOS ATAQUE");
        jPanel6.add(jLabel3);
        jLabel3.setBounds(10, 150, 240, 40);

        armaText.setFont(new java.awt.Font("AR CHRISTY", 0, 60)); // NOI18N
        armaText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        armaText.setText("----");
        armaText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        armaText.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        armaText.setEnabled(false);
        armaText.setOpaque(false);
        jPanel6.add(armaText);
        armaText.setBounds(10, 70, 240, 60);

        ataqueText.setFont(new java.awt.Font("AR CHRISTY", 0, 60)); // NOI18N
        ataqueText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ataqueText.setText("0");
        ataqueText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(255, 255, 255)));
        ataqueText.setDisabledTextColor(new java.awt.Color(0, 0, 102));
        ataqueText.setEnabled(false);
        ataqueText.setOpaque(false);
        jPanel6.add(ataqueText);
        ataqueText.setBounds(10, 200, 240, 70);

        jLabel4.setFont(new java.awt.Font("SF Atarian System", 0, 48)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ARMA");
        jPanel6.add(jLabel4);
        jLabel4.setBounds(10, 10, 240, 40);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(650, 300, 260, 300);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 970, 670);

        setSize(new java.awt.Dimension(964, 696));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        dibujarLabels();
        updateVida();

        KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(final KeyEvent ev) {
                if (ev.getID() == KeyEvent.KEY_TYPED) {
                    if (loading.getValue() == loading.getMaximum() && Compi1_Proyecto1.HeroesActivos.get(0).heroe.isDead() == false) {
                        String caracter = Character.toString(ev.getKeyChar());
                        int x = Compi1_Proyecto1.HeroesActivos.get(0).X;
                        int y = Compi1_Proyecto1.HeroesActivos.get(0).Y;
                        System.out.println(x + "," + y);

                        if (caracter.equals("w")) {
                            try {
                                if (Compi1_Proyecto1.tablero[x][y - 1] == null) {
                                    Compi1_Proyecto1.tablero[x][y - 1] = Compi1_Proyecto1.tablero[x][y];
                                    Compi1_Proyecto1.tableroImagenes[x][y - 1] = Compi1_Proyecto1.tableroImagenes[x][y];
                                    Compi1_Proyecto1.tableroImagenes[x][y] = null;
                                    Compi1_Proyecto1.tablero[x][y] = null;
                                    Compi1_Proyecto1.HeroesActivos.get(0).Y--;
                                    moverUp(x, y);
                                } else {
                                    if (isEnemigo(Compi1_Proyecto1.tablero[x][y - 1]) == true) {
                                        EnemigoAct e = (EnemigoAct) Compi1_Proyecto1.tablero[x][y - 1];
                                        int a = Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida;
                                        int b = e.enemigo.destruir;
                                        int c = a - b;
                                        Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida = c;
                                        updateVida();
                                    } else if (isExit(Compi1_Proyecto1.tablero[x][y - 1]) == true) {
                                        jPanel5.setVisible(false);
                                        jPanel6.setVisible(false);
                                        JOptionPane.showMessageDialog(null, "HAS GANADO :D", "GANASTE", JOptionPane.INFORMATION_MESSAGE);
                                        Compi1_Proyecto1.HeroesActivos.get(0).heroe.quitarVida(200);
                                    } else if (isExtra(Compi1_Proyecto1.tablero[x][y - 1]) == true) {
                                        Compi1_Proyecto1.tablero[x][y - 1] = Compi1_Proyecto1.tablero[x][y];
                                        Compi1_Proyecto1.tableroImagenes[x][y - 1] = Compi1_Proyecto1.tableroImagenes[x][y];
                                        Compi1_Proyecto1.tableroImagenes[x][y] = null;
                                        Compi1_Proyecto1.tablero[x][y] = null;
                                        Compi1_Proyecto1.HeroesActivos.get(0).Y--;
                                        moverUp(x, y);
                                    }
                                }
                                pintarHeroe();
                            } catch (Exception o) {
                            }
                        } else if (caracter.equals("a")) {
                            try {
                                if (Compi1_Proyecto1.tablero[x - 1][y] == null) {
                                    Compi1_Proyecto1.tablero[x - 1][y] = Compi1_Proyecto1.tablero[x][y];
                                    Compi1_Proyecto1.tableroImagenes[x - 1][y] = Compi1_Proyecto1.tableroImagenes[x][y];
                                    Compi1_Proyecto1.tableroImagenes[x][y] = null;
                                    Compi1_Proyecto1.tablero[x][y] = null;
                                    Compi1_Proyecto1.HeroesActivos.get(0).X--;
                                    moverIzq(x, y);
                                } else {
                                    if (isEnemigo(Compi1_Proyecto1.tablero[x - 1][y]) == true) {
                                        EnemigoAct e = (EnemigoAct) Compi1_Proyecto1.tablero[x - 1][y];
                                        int a = Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida;
                                        int b = e.enemigo.destruir;
                                        int c = a - b;
                                        Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida = c;
                                        updateVida();
                                    } else if (isExit(Compi1_Proyecto1.tablero[x - 1][y]) == true) {
                                        jPanel5.setVisible(false);
                                        jPanel6.setVisible(false);
                                        JOptionPane.showMessageDialog(null, "HAS GANADO :D", "GANASTE", JOptionPane.INFORMATION_MESSAGE);
                                        Compi1_Proyecto1.HeroesActivos.get(0).heroe.quitarVida(200);
                                    } else if (isExtra(Compi1_Proyecto1.tablero[x - 1][y]) == true) {
                                        Compi1_Proyecto1.tablero[x - 1][y] = Compi1_Proyecto1.tablero[x][y];
                                        Compi1_Proyecto1.tableroImagenes[x - 1][y] = Compi1_Proyecto1.tableroImagenes[x][y];
                                        Compi1_Proyecto1.tableroImagenes[x][y] = null;
                                        Compi1_Proyecto1.tablero[x][y] = null;
                                        Compi1_Proyecto1.HeroesActivos.get(0).X--;
                                        moverIzq(x, y);
                                    }
                                }
                                pintarHeroe();
                            } catch (Exception o) {
                            }
                        } else if (caracter.equals("d")) {
                            try {
                                if (Compi1_Proyecto1.tablero[x + 1][y] == null) {
                                    Compi1_Proyecto1.tablero[x + 1][y] = Compi1_Proyecto1.tablero[x][y];
                                    Compi1_Proyecto1.tableroImagenes[x + 1][y] = Compi1_Proyecto1.tableroImagenes[x][y];
                                    Compi1_Proyecto1.tableroImagenes[x][y] = null;
                                    Compi1_Proyecto1.tablero[x][y] = null;
                                    Compi1_Proyecto1.HeroesActivos.get(0).X++;
                                    moverDer(x, y);
                                } else {
                                    if (isEnemigo(Compi1_Proyecto1.tablero[x + 1][y]) == true) {
                                        EnemigoAct e = (EnemigoAct) Compi1_Proyecto1.tablero[x + 1][y];
                                        int a = Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida;
                                        int b = e.enemigo.destruir;
                                        int c = a - b;
                                        Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida = c;
                                        updateVida();
                                    } else if (isExit(Compi1_Proyecto1.tablero[x + 1][y]) == true) {
                                        jPanel5.setVisible(false);
                                        jPanel6.setVisible(false);
                                        JOptionPane.showMessageDialog(null, "HAS GANADO :D", "GANASTE", JOptionPane.INFORMATION_MESSAGE);
                                        Compi1_Proyecto1.HeroesActivos.get(0).heroe.quitarVida(200);
                                    } else if (isExtra(Compi1_Proyecto1.tablero[x + 1][y]) == true) {
                                        Compi1_Proyecto1.tablero[x + 1][y] = Compi1_Proyecto1.tablero[x][y];
                                        Compi1_Proyecto1.tableroImagenes[x + 1][y] = Compi1_Proyecto1.tableroImagenes[x][y];
                                        Compi1_Proyecto1.tableroImagenes[x][y] = null;
                                        Compi1_Proyecto1.tablero[x][y] = null;
                                        Compi1_Proyecto1.HeroesActivos.get(0).X++;
                                        moverDer(x, y);
                                    }
                                }
                                pintarHeroe();
                            } catch (Exception o) {
                            }
                        } else if (caracter.equals("s")) {
                            try {
                                if (Compi1_Proyecto1.tablero[x][y + 1] == null) {
                                    Compi1_Proyecto1.tablero[x][y + 1] = Compi1_Proyecto1.tablero[x][y];
                                    Compi1_Proyecto1.tableroImagenes[x][y + 1] = Compi1_Proyecto1.tableroImagenes[x][y];
                                    Compi1_Proyecto1.tableroImagenes[x][y] = null;
                                    Compi1_Proyecto1.tablero[x][y] = null;
                                    Compi1_Proyecto1.HeroesActivos.get(0).Y++;
                                    moverDown(x, y);
                                } else {
                                    if (isEnemigo(Compi1_Proyecto1.tablero[x][y + 1]) == true) {
                                        EnemigoAct e = (EnemigoAct) Compi1_Proyecto1.tablero[x][y + 1];
                                        int a = Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida;
                                        int b = e.enemigo.destruir;
                                        int c = a - b;
                                        Compi1_Proyecto1.HeroesActivos.get(0).heroe.vida = c;
                                        updateVida();
                                    } else if (isExit(Compi1_Proyecto1.tablero[x][y + 1]) == true) {
                                        jPanel5.setVisible(false);
                                        jPanel6.setVisible(false);
                                        JOptionPane.showMessageDialog(null, "HAS GANADO :D", "GANASTE", JOptionPane.INFORMATION_MESSAGE);
                                        Compi1_Proyecto1.HeroesActivos.get(0).heroe.quitarVida(200);
                                    } else if (isExtra(Compi1_Proyecto1.tablero[x][y + 1]) == true) {
                                        Compi1_Proyecto1.tablero[x][y + 1] = Compi1_Proyecto1.tablero[x][y];
                                        Compi1_Proyecto1.tableroImagenes[x][y + 1] = Compi1_Proyecto1.tableroImagenes[x][y];
                                        Compi1_Proyecto1.tableroImagenes[x][y] = null;
                                        Compi1_Proyecto1.tablero[x][y] = null;
                                        Compi1_Proyecto1.HeroesActivos.get(0).Y++;
                                        moverDown(x, y);
                                    }
                                }
                                pintarHeroe();
                            } catch (Exception o) {
                            }
                        } else if (caracter.equals("l")) {
                            if (!armaText.getText().equalsIgnoreCase("----")) {
                                dispararDer(Compi1_Proyecto1.HeroesActivos.get(0).X, Compi1_Proyecto1.HeroesActivos.get(0).Y);
                            }
                        } else if (caracter.equals("j")) {
                            if (!armaText.getText().equalsIgnoreCase("----")) {
                                dispararIzq(Compi1_Proyecto1.HeroesActivos.get(0).X, Compi1_Proyecto1.HeroesActivos.get(0).Y);
                            }
                        } else if (caracter.equals("i")) {
                            if (!armaText.getText().equalsIgnoreCase("----")) {
                                dispararUp(Compi1_Proyecto1.HeroesActivos.get(0).X, Compi1_Proyecto1.HeroesActivos.get(0).Y);
                            }
                        } else if (caracter.equals("k")) {
                            if (!armaText.getText().equalsIgnoreCase("----")) {
                                dispararDown(Compi1_Proyecto1.HeroesActivos.get(0).X, Compi1_Proyecto1.HeroesActivos.get(0).Y);
                            }
                        }
                    }
                }
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);

    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed

    }//GEN-LAST:event_jPanel1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pintarHeroe();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void start(int n) {
        Juego.n = n;

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField armaText;
    private static javax.swing.JTextField ataqueText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JPanel jPanel4;
    private static javax.swing.JPanel jPanel5;
    private static javax.swing.JPanel jPanel6;
    private static javax.swing.JTextField jTextField1;
    public static javax.swing.JProgressBar loading;
    // End of variables declaration//GEN-END:variables
}
