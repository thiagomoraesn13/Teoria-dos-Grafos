/*
source de estudo: https://ideone.com/Ps60wK
C++ program for Prim's and Kurskal's Algorithms for MSTs.
adjacency matrix used for both algorithms.
*/

#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

#define MAXN 200005

vector< pair< int, pair <int, int> > > g; // [w (u, v)] 	format
int parent[MAXN];

int findset(int x) {
	if(x != parent[x])
		parent[x] = findset(parent[x]);
	return parent[x];
}

int kruskal(int e) {
	int i, pInicio, pFinal, total;
	sort(g.begin(), g.end());			 		  // ordenar o vector
	for(i = total = 0; i < e; i++) {
		// adiciona os pesos
		pInicio = findset(g[i].second.first);
		pFinal 	= findset(g[i].second.second);
		if(pInicio != pFinal) {
			total += g[i].first; 	    		  // add edge cost
			parent[pInicio] = parent[pFinal];     // link
		}
	}
	return total;
}

void reset(int n) {
	g.clear();
	for(int i = 0; i <= n; i++) parent[i] = i;
}

int main() {
	int m, n, v, a, w;
	while(scanf("%d %d", & m, & n)) {
		
		if((m && n) == 0) break;
		
		int soma = 0;
		reset(n); //limpa e cria novo vector;
	
		for(int i = 0; i < n; i++) {
			scanf("%d %d %d", & v, & a, & w);  // Vertice, Aresta, Peso
			soma += w;
			g.push_back(pair< int, pair <int, int> >(w, pair <int, int>(v, a)));
		}
		printf("%d\n", soma - kruskal(n));
	}
	return 0;
}
