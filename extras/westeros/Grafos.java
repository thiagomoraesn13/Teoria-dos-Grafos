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

public class Grafos{
  ListaEncadeada[] listaAdjacente;
  int vertices;
  int arestas;

  public Grafos(int vertices) {
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

  public int dfs_visita(int inicial){
  	int[] cor = new int[vertices]; 
  	int[] pred = new int[vertices];  
  	return dfs_grafos(inicial, cor);
  }

  public int extra(String primeira, int u){
  	int i;
  	pre[inicio] = u;
  	No aux = listaAdjacente[primeira.charAt(u)]; 

  	}

  }

public int dfs_grafos(int inicial, int[] cor){
  	cor[inicial] = 1;
  	No aux = listaAdjacente[inicial].getTopo();	
  	while(aux!=null){

  		if(cor[aux.getDado()] == 1){
  			return 1;
  		}
  		else{
  			if(cor[aux.getDado()] == 0){
  				if(dfs_grafos(aux.getDado(),cor) == 1){
  					return 1;
  				}
  			}
  		}
 	aux=aux.getProx();
 	}
 	cor[inicial] = 2;	
  	return 0;
}
public static void main (String args[]){
	Scanner leitura = new Scanner(System.in);
	System.out.println("Digite a quantidade de casos");
	int casos = leitura.nextInt(), flag;
	for(int i=0;i<casos;i++){
		flag=0;
	int arestas;
	int vertices;
	System.out.println("Digite a quanti de vertices");
	vertices =  leitura.nextInt();
	Grafos grafos = new Grafos(vertices+1);
	
	System.out.println("digite aarestas");
	arestas = leitura.nextInt();
	int ind = 0;
	int are = 0;
	//System.out.println("primeiro");
	//ind = leitura.nextInt();
	while(arestas>0){
		ind = leitura.nextInt();
		are = leitura.nextInt();
		grafos.insere_Aresta(ind,are);
	arestas--;
	}
	for(int j=0;j<vertices+1;j++){
		if(flag==0){
	if(grafos.dfs_visita(j) == 1){
		flag=1;
	}
	}
	else{
		break;
	}
	}
	if(flag==1){
		System.out.println("SIM");
	}
	else{
		System.out.println("NAO");
	}

}
}
}