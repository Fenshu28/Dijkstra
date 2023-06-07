/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 5 jun 2023                        *
 * Fecha de actualización: 5 jun 2023                   *
 * Descripción: Clase para 
 *****************************************************/

package dijkstra;


public class Vertice {
    private int index;
    private char nombre;
    private char etiqueta;
    private int peso;
    
    public Vertice(){
        
    }
    
    public Vertice(int index,char nombre, char etiqueta, int peso) {
        this.index = index;
        this.nombre = nombre;
        this.etiqueta = etiqueta;
        this.peso = peso;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }    
    
    public char getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(char etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
