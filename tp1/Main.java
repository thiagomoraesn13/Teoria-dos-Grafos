import java.util.Scanner;
import java.util.*;
import java.io.*;

class No{
	int chave;
	char dado;
	No esquerdo;
	No direito;
	No pai;

public No(int chave, char dado, No pai){
	this.chave = chave;
	this.dado = dado;
	this.pai = pai;
	this.esquerdo = null;
	this.direito = null;
}

public int getChave(){
	return chave;
}
public void setChave(int chave){
	this.chave = chave;
}
public char getDado(){
	return dado;
}
public void setDado(char dado){
	this.dado = dado;
}
public No getEsquerdo(){
	return esquerdo;
}
public void setEsquerdo(No esquerdo){
	this.esquerdo = esquerdo;
}
public No getDireito(){
	return direito;
}
public void setDireito(No direito){
	this.direito = direito;
}
public No getPai(){
	return pai;
}
public void setPai(No pai){
	this.pai = pai;
}
}


public class Main {

	No raiz;

	public Main(){
		raiz = null;
	}
	public void insere(int chave, char dado){
		if(raiz == null){
			raiz = new No(chave, dado, null);
			return;
		}
		No atual = raiz;
		No pai = null;
		while(atual!=null){
			pai = atual;
			if(chave < atual.getChave()){
				atual = atual.getEsquerdo();
			}
			else
				if(chave > atual.getChave()){
					atual = atual.getDireito();
				}
				else{
					return;
				}

			}
		No novo = new No(chave,dado,pai);
		if(chave < pai.getChave()){
			pai.setEsquerdo(novo);
		}
		else{
			pai.setDireito(novo);
		}
	}
	public void caminha(){
    caminha_Pos(raiz);
  	} 
  	public void caminha_Pos(No raiz) {
    	if (raiz != null){
      	caminha_Pos(raiz.getEsquerdo());
      	caminha_Pos(raiz.getDireito());
      	System.out.print(raiz.getDado());
   		 }
   	} 
    public static void main(String[] args) {
    Scanner leitura = new Scanner(System.in);
	int casos = leitura.nextInt();	
	int casoinicio,i,j;
	String primeira="";
	String segunda = ""; 
	int tamanho=0;
	for(casoinicio=0;casoinicio<casos;casoinicio++){
		Main aux = new Main();
		tamanho = leitura.nextInt();
		primeira = leitura.next();
		segunda = leitura.next();
		for(i=0;i<tamanho;i++){
   			for(j=0; j<tamanho; j++){
   				if(primeira.charAt(i) == segunda.charAt(j)){
   					aux.insere(j,segunda.charAt(j));
   				}
   			}
   		}
   		aux.caminha();
   		System.out.println();
	}
		
    }
 
}


