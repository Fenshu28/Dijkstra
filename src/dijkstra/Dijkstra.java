/*****************************************************
 * Autor: Cristopher Alexis Zarate Valencia          *
 * Fecha de creación: 5 jun 2023                        *
 * Fecha de actualización: 5 jun 2023                   *
 * Descripción: Clase para 
 *****************************************************/

package dijkstra;

import java.util.ArrayList;
import java.util.List;


public class Dijkstra {
    private static final int INFINITY = 9999;
    
    private int inicio = 0;
    private int i = 0;
    private char v[] = {'a','b','c','f','g','h'};
    private List<Vertice> Sp;
    private List<Vertice> S;
    private List<Integer> distancias;
    private int graf[][];
        
    public Dijkstra(){
        for (int j = 0; j < v.length; j++) {
            graf = new int[v.length][v.length];
        }
        Sp = new ArrayList<>();
        S = new ArrayList<>();
        distancias = new ArrayList<>();
    }
    
    private void setFlesha(int inicio, int fin, int peso){
        graf[inicio][fin] = peso;
    }
    
    private void setDijktran(int inicio){ 
        this.inicio = inicio;
        
        for(int j = 0; j<v.length ; j++){
            // Establecemos valores altos en los pesos de los otros vertices de S'.
            Sp.add(new Vertice(j,v[j],'-',INFINITY));         
        }
               
        // Agregamos el vertice de inicio al conjunto S con 0.
        Sp.get(inicio).setPeso(0);
        S.add(Sp.get(this.inicio));
        Sp.remove(inicio);
        
        /**
         * Si el número de elementos en el conjunto S' es igual a 1 el algoritmo
         * esta resuelto.
         */
        if(Sp.size() == 1){
            System.out.printf("El camino más corto del vertice %c es: %d",
                    S.get(i).getEtiqueta(),S.get(i).getPeso());
        }else{ // Si no, iteramos.
            do{
                System.out.println("**********************************");
                System.out.println("Iteración " + (i+1));   
                System.out.printf("S ={");
                imprimirLista(S);
                System.out.printf("S' ={");
                imprimirLista(Sp);
                
                paso2();              
                paso3();
                
            }while(Sp.size() > 0);            
        }
    }
    
    private void paso2(){
        for(Vertice destino : Sp){
            if(!estaEnS(destino)){
                Vertice actual = S.get(S.size()-1);
                
                System.out.printf("L("+destino.getNombre()+") = min{" + 
                        destino.getPeso()+"," + 
                        graf[actual.getIndex()][destino.getIndex()]+"+"+
                        actual.getPeso()+"} = ");
                
                calMin(destino, actual);   
                
                System.out.printf(destino.getPeso() + "\n");
                
            }
        }
    }
    
    private void paso3(){
        int min = INFINITY;
        Vertice vertAux = null;
        
        if(!sonInfinitos()){
            for (Vertice vertice : Sp) {
                if(vertice.getPeso() < min){
                    vertAux = vertice;
                    min = vertice.getPeso();
                }
            }
            
            S.add(vertAux);
            Sp.remove(vertAux);
            
            i++;
        }
    }
    
    private boolean sonInfinitos(){
        boolean aux = true;
        
        for (Vertice vertice : Sp) {
            if(vertice.getPeso() != INFINITY)
                aux = false;
        }
        
        return aux;
    }
    
    private boolean estaEnS(Vertice vert){
        boolean aux = false;
//        && ve.getNombre() != Sp.get(inicio).getNombre()
        for (Vertice ve : S) {
            if(ve.getNombre()== vert.getNombre())
                aux = true; 
        }
        
        return aux;
    }
    
    private void calMin(Vertice destino, Vertice actual){
        int pSig;
        int pActual;
                
        pSig = destino.getPeso();
        pActual = actual.getPeso() + graf[actual.getIndex()][destino.getIndex()];
        
        destino.setEtiqueta((pSig > pActual) ? destino.getNombre() : 
                actual.getNombre());
        
        destino.setPeso((pSig > pActual) ? pActual : pSig);
    }   
    
    private void imprimirLista(List<Vertice> list){
        for (Vertice vertice : list) {
            System.out.printf(vertice.getNombre()+",");
        }
        System.out.printf("}\n");
    }
    
    private void autoRellenar(){
        for (int j = 0; j < v.length; j++) {
            for (int k = 0; k < v.length; k++) {
                if(graf[j][k] < 1){
                   graf[j][k] = 9999;
                }
            }
        }
    }
    
    private void caminos(){
        System.out.println("Caminos más cortos desde " + v[inicio]);
        for (Vertice vertice : S) {
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        Dijkstra algoritmo1 = new Dijkstra();
        
        algoritmo1.setFlesha(0, 2, 6);
        algoritmo1.setFlesha(0, 1, 5);
        algoritmo1.setFlesha(0, 4, 17);
        algoritmo1.setFlesha(1, 0,3);
        algoritmo1.setFlesha(1, 5, 7);
        algoritmo1.setFlesha(1, 2, 4);
        algoritmo1.setFlesha(1, 0, 3);
        algoritmo1.setFlesha(2,3,6);
        algoritmo1.setFlesha(2,5,11);
        algoritmo1.setFlesha(3,0,11);
        algoritmo1.setFlesha(3,2,7);
        algoritmo1.setFlesha(3,5,4);
        algoritmo1.setFlesha(3,4,9);
        algoritmo1.setFlesha(4,5,5);
        algoritmo1.setFlesha(5,0,11);
        algoritmo1.setFlesha(5,3,9);
        algoritmo1.setFlesha(5,4,4);
        
        algoritmo1.autoRellenar();
        
        algoritmo1.setDijktran(0);
        
    }
}


