package caminhamento;
import java.util.Scanner;

public class Caminhamento {

    public static void main(String[] args) {
        int c, n, k, l,m,o,v=0, flag, raiz=0;
        String pre, in, s, res[];
        char aberto[], pos[];
        Scanner ler = new Scanner(System.in);
        c = ler.nextInt();
        res = new String[c];
        for(int i=0;i<c;i++){
           k=1;l=0;m=0;o=0;s="";
           n = ler.nextInt();
           pre = ler.next();
           in = ler.next();
           aberto = new char[n+n];
           pos = new char[n];
           for(int d=0;d<n;d++){
               if(in.charAt(d)==pre.charAt(o)){
                   raiz = d;
               }
           }
           while(k<=raiz && l<=raiz-1){
               if(pre.charAt(k)!=in.charAt(l)){
                   aberto[m++]=pre.charAt(k);
                   k++;
               }
               else{
                   for(int j=0;j<m;j++){
                       if(in.charAt(l+1)==aberto[j]){
                           pos[o++]=in.charAt(l);
                           k=k-2;
                       }
                   }
                   k++;
                   l++;
               }
           }          
           for(int p=raiz;p>=1;p--){
               flag=0;
               for(int q=0;q<raiz;q++){
                   if(pre.charAt(p)==pos[q]){
                       flag=1;
                   }
               }
               if(flag==0){
                   pos[o++]=pre.charAt(p);
               }
           }
           k=l=raiz+1;
           while(k!=pre.length()-1 && l<=in.length()-1){
               if(pre.charAt(k)!=in.charAt(l)){
                   aberto[m++]=pre.charAt(k);
                   k++;
               }
               else{
                   for(int j=0;j<m;j++){
                       if(in.charAt(l+1)==aberto[j]){
                           pos[o++]=in.charAt(l);
                           k=k-2;
                       }
                   }
                   k++;
                   l++;
               }
           }
           for(int p=n-1;p>=raiz;p--){
               flag=0;
               for(int q=raiz;q<n;q++){
                   if(pre.charAt(p)==pos[q]){
                       flag=1;
                   }
               }
               if(flag==0){
                   pos[o++]=pre.charAt(p);
               }
           }   
           pos[n-1]=pre.charAt(0);
           for(int r=0;r<n;r++){
               s=s + pos[r];
           }
           res[v++]=s;
        }        
        for(int z=0;z<c;z++){
            System.out.println(res[z]);
        }
    }
}
