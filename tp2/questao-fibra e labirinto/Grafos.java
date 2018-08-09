import java.util.Scanner;
import java.util.*;
import java.io.*;

class No{
	int dado;
	No prox;
	public No(int dado){
	 	this.dado = dado;
	 	this.prox = null;
	}
	public void setDado(int dado){
		this.dado =dado;
	}
	public int getDado(){
		return dado;
	}
	public No getProx(){
		return prox;
	}
	public void setProx(No prox){
		this.prox = prox;
	}
	}

 class ListaEncadeada{
	No topo;

	public ListaEncadeada(){
		topo = null;
	}
	public No getTopo(){
		return topo;
	}
	public void insere(int palavra){
		No aux = new No(palavra);
		aux.setProx(topo);
		topo = aux;
	}
}

public class Main{
  ListaEncadeada[] listaAdjacente;
  int vertices;
  int arestas;

  public Main(int vertices) {
    this.vertices = vertices;
    this.arestas = 0;
    this.listaAdjacente = new ListaEncadeada[vertices];
    
    int i;
    for(i=0;i<vertices;i++){
    	listaAdjacente[i] = new ListaEncadeada();
    }
  }
  public void insere_Aresta(int vertice1, int vertice2) {
   if(vertice1<0 || vertice1>=vertices || vertice2 < 0 || vertice2>=vertices){
      throw new IndexOutOfBoundsException();
   }
    listaAdjacente[vertice1].insere(vertice2);   
   	arestas++;
  }

  public int dfs_visita(int inicial, int cont){
  	int[] cor = new int[vertices]; 
  	int[] pred = new int[vertices];
  	return dfs(inicial, cor, cont);
  }

public int dfs(int inicial, int[] cor, int cont){
  	cor[inicial] = 1;
  	No aux = listaAdjacente[inicial].getTopo();	
  	while(aux!=null){
  		if(cor[aux.getDado()]==0){
  			cont++;
  			cont = dfs(aux.getDado(),cor, cont); 
  		}
  		aux=aux.getProx();			
 	}
  	return cont;
}
public static void main (String args[]){
		Scanner leitura = new Scanner(System.in);
		int casos = leitura.nextInt();
		int arestas;
		int vertices;
		int inicial;
		int ind = 0;
		int are = 0;
	for(int i=0;i<casos;i++){
		inicial = leitura.nextInt(); 
		vertices =  leitura.nextInt();
		Main grafo = new Main(vertices+1);
		arestas = leitura.nextInt();
		while(arestas>0){
			ind = leitura.nextInt();
			are = leitura.nextInt();
			grafo.insere_Aresta(ind,are);
			grafo.insere_Aresta(are,ind);
		arestas--;
		}
		int cont=0;
		System.out.println(grafo.dfs_visita(inicial,cont)*2);
	
	}
}
}