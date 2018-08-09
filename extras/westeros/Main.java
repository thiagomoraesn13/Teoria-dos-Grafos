import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
    Scanner leitura = new Scanner(System.in);
	int casos = leitura.nextInt();
	String[] vetor = new String[casos+2];
	int casoinicio;
	int i=1;
	int cont = 1;
	int saida[]= new int[casos*2];
	int visi[]= new int[casos*2];
	int segundo=0;
	int contador = 0;
	int b=0;
	for(casoinicio=1;casoinicio<=casos;casoinicio++){
		vetor[casoinicio] = leitura.next();
	}
	for(int primeiro = 1;primeiro<=casos;primeiro++){		
		if(vetor[primeiro+1]!=null){
		segundo = primeiro+1;
		while(segundo<=casos){
			if(vetor[primeiro].equals(vetor[segundo]) && visi[segundo] == 0){
 				cont++;
				saida[i] = cont;
				visi[segundo] = 1;
				if(contador == b){
					contador++;
				}
				visi[segundo] =1;
				visi[primeiro] = 1;
			}
			segundo++;
		}
		b=contador;
		i++;
		cont=1;
		}	
	}
	if(contador == 0){
		System.out.print(-1);	
	}
	else{	
		for(int j = 1;j<=casos;j++){
				if(visi[j] == 0){
					saida[i] = 1;
					i++;
					contador++;
				}
		}		
		System.out.println(contador);
			int inicio,termino;
  			int pivot;
  			//ORDENACAO
  			for(inicio=2; inicio < saida.length; inicio++) {
    			pivot = saida[inicio];
    			for(termino = inicio-1; termino >= 1; termino--){
      				if(pivot > saida[termino]) {
						saida[termino+1] = saida[termino];
      				}
      				else{
					break;
      			}
   			 }
    		saida[termino+1]= pivot;
  			}
			for(i=1;i<saida.length;i++){
				if(saida[i]!=0){
					System.out.print(saida[i]+" ");
				}
			}
	}		
	System.out.println();						
}
}

