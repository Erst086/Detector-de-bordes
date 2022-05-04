/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectobordes;

public class CalculaUmbral {
    int media,anterior,siguiente;
    double PrimeraMitad,SegundaMitad;
    public int CalcularUmbral(int[]histograma){
         media=histograma.length/2;//punto inicial
         anterior=-1;
         siguiente=media;
         PrimeraMitad=0.0;
         SegundaMitad=0.0;
        do{
            anterior=siguiente;
            //Calcula el promedio para la primera mitad
            PrimeraMitad=CalcularMedio(histograma,0,siguiente);
            //Calcula el promedio para la segunda mitad
           SegundaMitad=CalcularMedio(histograma,siguiente,histograma.length);
        if(PrimeraMitad==0.0){//ajuste de valores en caso de no existir pixeles en alguna de las mitades
        PrimeraMitad=SegundaMitad;
        }
        if(SegundaMitad==0.0){
        SegundaMitad=PrimeraMitad;
        }
        //El valor del umbral se calcula como el promedio
        //de los valores para los promedios de cada mitad
        
        siguiente=(int)((PrimeraMitad+SegundaMitad)*0.5);
        }while (anterior!=siguiente);
       
        return siguiente;
    }//fin metodo
   
    public double CalcularMedio(int[]histograma,int inicio,int fin){
        int n=0;
        int sum=0;
        for(int i=inicio;i<fin;i++){
            sum+=(i*histograma[i]);//acumula valores freq(i)*n;
            n+=histograma[i];//contando la cantidad de pixeles
        }//fin for
        if(n==0){//si erango no se encontro se regresa 0
        return 0.0;
        }
        return (((double)sum)/((double)n));//promedio aritmetico   
    }//fin calcula medio
    }//fin clase
