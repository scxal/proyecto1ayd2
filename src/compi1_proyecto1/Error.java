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
public class Error {
    public String id;
    public int line, column;
    
    public Error(String id, int column, int line){
        this.id = id;
        this.line = line;
        this.column = column;
        
    }
}
