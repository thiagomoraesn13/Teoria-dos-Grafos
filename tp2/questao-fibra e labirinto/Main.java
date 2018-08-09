import java.util.Scanner;
import java.util.*;
import java.io.*;
 
class Funcoes{
public void Floyd(int vertice, int matriz[][]){
    int k,i,j;
  for(k=0;k<vertice;k++){
      for(i=0;i<vertice;i++){
        for(j=0;j<vertice;j++){
           matriz[i][j] |=(matriz[i][k]&matriz[k][j]);        
      	}
     }
  }
}
public int converte(String vet){
    int recebe=0;
    for(int i=0;i<vet.length();i++){
        recebe |= 1 << vet.charAt(i)-97;
    }
    return recebe;
}
public void des(int valor){
    if(valor == 0){
        System.out.println("-");
        return;
    }
    for(int i=0;i<26;i++){
        if((valor&(1<<i))!=0){
            System.out.printf("%c",i+97);
        }
    }
    System.out.println();
}
}
public class Main{
    public static void main(String args[]){
    Funcoes bankai = new Funcoes();
    int vertice, i,j, caso=1, a, b, valor=1;
    String bala = "";
    Scanner leitura = new Scanner(System.in);
    while(caso!=0){
        vertice= leitura.nextInt();
       
        if(vertice==0){ 
        	break; 
        }
        int matriz[][] = new int[vertice][vertice];
        while(valor == 1){
            a = leitura.nextInt();
            b = leitura.nextInt();
            if(a == 0 &&  b == 0){
                valor++;
                break;  
            }
            bala = leitura.next();
            matriz[--a][--b] = bankai.converte(bala);
        }
        bankai.Floyd(vertice,matriz);
        while(valor == 2 ){
            a = leitura.nextInt();
            b = leitura.nextInt();
            if((a == 0 &&  b == 0)){
                valor++;
                break;  
            }
            bankai.des(matriz[--a][--b]);
        }
        valor = 1;
        System.out.println();
    }
}
}