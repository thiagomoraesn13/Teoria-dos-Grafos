#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <vector>
#include <algorithm>
 
using namespace std;
 
char adj[1002][1002];
int seen[1002], vet[1003], cmp, n;
vector<int> cs[1003];
 
void dfs(int u) {
    if(seen[u]) return;
    seen[u] = 1;
    cs[cmp].push_back(u);
    for(int i = 0; i < n; i++)
        if(adj[u][i] == 'S')
            dfs(i);
}
 
int main() {
    int i, j, k;
    scanf("%d", & n);
 
    for(i = 0; i < n; i++)
        for(j = 0; j < n; j++)
            scanf(" %c", & adj[i][j]);
 
    for(i = 0; i < n; i++)
        if(!seen[i]) {
            dfs(i);
            cmp++;
        }
 
    for(i = 0; i < cmp; i++) {
        for(j = 0; j < cs[i].size(); j++)
            for(k = 0; k < cs[i].size(); k++)
                if(adj[cs[i][j]][cs[i][k]] != 'S') {
                    puts("-1");
                    return 0;
                }
        vet[i] = cs[i].size();
    }
 
    sort(vet, vet + cmp);
 
    printf("%d\n%d", cmp, vet[cmp - 1]);
     
    for(i = cmp - 2; i >= 0; i--)
        printf(" %d", vet[i]);
 
    putchar('\n');
 
    return 0;
}