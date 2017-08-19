/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compi1_proyecto1;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CsvClass {

    public static JFileChooser csv;
    public static JFileChooser txt;
    public static String xStrPath;
    public static String[][] ArrayPrincipal, ArrayPrincipalCadena;
    public static int Rowc = 0;
    public static int Row = 0;
    public static int RowArch = 0;
    public static int RowCadena = 0;
    public static int Colc = 0;
    public static int Col = 0;
    public static File archivo;

    public static void getTamaño(String path) {
        try {
            Scanner scanIn;
            String InputLine;
            scanIn = new Scanner(new BufferedReader(new FileReader(path)));
            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split("");
                Row++;
                int colTemp = InArray.length;
                if (colTemp > Col) {
                    Col = colTemp;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CsvClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void getTamaño() {
        try {
            Scanner scanIn;
            String InputLine;

            csv = new JFileChooser();
            FileFilter filtro = new FileNameExtensionFilter("Archivo xconf", "xconf");
            csv.setFileFilter(filtro);
            csv.showOpenDialog(csv);
            archivo = csv.getSelectedFile();
            scanIn = new Scanner(new BufferedReader(new FileReader(archivo)));
            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split("");
                Row++;
                int colTemp = InArray.length;
                if (colTemp > Col) {
                    Col = colTemp;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CsvClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//C:\Users\Mac\Documents\NetBeansProjects\Compi1Proyecto1
    public static String leer(String path) {
        getTamaño(path);
        ArrayPrincipal = new String[Row][Col];
        Scanner scanIn;
        String InputLine;
        String resultado = "";
        try {
            scanIn = new Scanner(new BufferedReader(new FileReader(path)));
            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split("GGFDG2j");
                System.arraycopy(InArray, 0, ArrayPrincipal[Rowc], 0, InArray.length);
                Rowc++;
            }
            RowArch = Row;
            for (int i = 0; i < Row; i++) {
                if (ArrayPrincipal[i][0] != null) {
//                    Menu.arch.setText(Menu.arch.getText() + ArrayPrincipal[i][0] + "\n");
//                    Menu.paneText.setText(Menu.paneText.getText() + ArrayPrincipal[i][0] + "\n");
                    resultado += ArrayPrincipal[i][0];
                }
            }
            return resultado;
//            Menu.paneText.setText(Menu.arch.getText());
        } catch (FileNotFoundException | HeadlessException e) {
        }
        return null;
    }
    
    public static String leer() {
        getTamaño();
        ArrayPrincipal = new String[Row][Col];
        Scanner scanIn;
        String InputLine;
        try {
            scanIn = new Scanner(new BufferedReader(new FileReader(archivo)));
            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split("GGFDG2j");
                System.arraycopy(InArray, 0, ArrayPrincipal[Rowc], 0, InArray.length);
                Rowc++;
            }
            RowArch = Row;
            for (int i = 0; i < Row; i++) {
                if (ArrayPrincipal[i][0] != null) {
//                    Menu.arch.setText(Menu.arch.getText() + ArrayPrincipal[i][0] + "\n");
                    Menu.paneText.setText(Menu.paneText.getText() + ArrayPrincipal[i][0] + "\n");
                    
                }
            }
            return Menu.paneText.getText();
//            Menu.paneText.setText(Menu.arch.getText());
        } catch (FileNotFoundException | HeadlessException e) {
        }
        return null;
    }
    
    public static void guardar() {
        String temp = Menu.paneText.getText();
        int cont = 0;
        try {
            txt = new JFileChooser();
            txt.showSaveDialog(txt);
            File guarda = txt.getSelectedFile();
            if (guarda != null) {
                File output = new File(guarda + ".xconf");
                FileWriter writer = new FileWriter(output);
                BufferedWriter buf = new BufferedWriter(writer);
                while (cont < temp.length()) {
                    if ("\n".equals(Character.toString(temp.charAt(cont)))) {
                        buf.write("\r");
                    }
                    buf.write(Character.toString(temp.charAt(cont)));
                    cont++;
                }
                buf.flush();
                buf.close();
                writer.close();
                JOptionPane.showMessageDialog(null, "El archivo se ha guardado exitosamente!",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
