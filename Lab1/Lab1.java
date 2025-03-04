/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    int []v;
    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        lab1.bonus(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }
    
    void compulsory(){
        System.out.println("COMPULSORY:");
        System.out.println("Hello World!");
        String languages [] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n=n*3;
        n=n+0b10101;
        n=n+0xFF;
        n=n*6;
        int dsum;
        while(n>9)
        {
            dsum=0;
            while(n>0)
            {
                dsum=dsum+n%10;
                n=n/10;
            }
            n=dsum;
        }
        System.out.print("Willy-nilly, this semester I will learn " + languages[n]+"\n");
    
    }
    
    void mat_string(int [][] mat,int n){
        int i,j;
        String s="";
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                    s=s+"\u25A1 ";
                else
                    s=s+"\u25A0 ";
            }
            s=s+"\n";
        }
        System.out.print(s);
    }
    
    void homework(int n, int k){
        System.out.println("HOMEWORK:");
        long start=System.nanoTime();
        int [][] mat=new int[n][n];
        int i,j,m,dmin,dmax,dcounter,vmin,vmax,dsum;
        m=0;
        dmin=n+1;
        dmax=-1;
        vmax=vmin=0;
        dsum=0;
        for( i=0;i<n;i++)
        {
            for( j=0;j<=i;j++)
            {
                if(i==j)
                    mat[i][j]=0;
                else
                {
                    if(i<k&&j<k)
                    {
                        mat[i][j]=mat[j][i]=1;
                        m++;
                    }
                    else if(i>=k&&i<2*k&&j>=k&&j<2*k)
                        mat[i][j]=mat[j][i]=0;
                    else
                    {
                        mat[i][j]=mat[j][i]=(int)(Math.random()*1000)%2;
                        if(mat[i][j]==1)
                            m++;
                    }
                }
            }
        }
        
        if(n<=50)
            mat_string(mat,n);
        
        for(i=0;i<n;i++)
        {
            dcounter=0;
            for(j=0;j<n;j++)
                if(mat[i][j]==1)
                    dcounter++;
            if(dcounter<dmin)
            {
                dmin=dcounter;vmin=i;
            }
            if(dcounter>dmax)
            {
                dmax=dcounter;vmax=i;
            }
            dsum=dsum+dcounter;
        }
        
        System.out.print("The number of edges is: "+m+"\n");
        
        System.out.print("\u0394(G) = "+dmax+" for the vertex: "+vmax+"\n");
        System.out.print("\u03B4(G) = "+dmin+" for the vertex: "+vmin+"\n");
        
        if(dsum==2*m)
            System.out.print("The sum of the degrees is "+dsum+"=2*"+m+"\n");
        
        if(n>50)
        {
            long duration=(System.nanoTime()-start)/1000;
            System.out.println("Program ended with a runtime of "+duration/1000+"."+duration%1000+"ms");
        }
    }
    
    boolean valid(int i,int p,int [][]mat)
    {
        for(int j=0;j<p;j++)
            if(i==v[j]||mat[i][v[j]]==0)
                return false;
        return true;
    }
    
    boolean check_clique(int [][]mat,int n,int k,int p){
        for(int i=0;i<n;i++)
        {
            if(valid(i,p,mat)==true)
            {
                v[p]=i;
                if(p==k-1)
                    return true;
                else
                    if(check_clique(mat,n,k,p+1)==true)
                        return true;
            }
        }
        return false;
    }
    
    void bonus(int n, int k)
    {
        System.out.println("BONUS:");
        long start=System.nanoTime();
        int [][] mat=new int[n][n];
        int i,j,x;
        for( i=0;i<n;i++)
        {
            for( j=0;j<=i;j++)
            {
                if(i==j)
                    mat[i][j]=0;
                else
                    mat[i][j]=mat[j][i]=(int)(Math.random()*1000)%2;     
            }
        }
        if(n<=50)
            mat_string(mat,n);
        v=new int[k];
        if(check_clique(mat,n,k,0)==true)
        {
            System.out.println("A clique of size "+k+" in our graph is:");
            for(i=0;i<k;i++)
                System.out.print(v[i]+" ");
            System.out.print("\n");
        }
        else
            System.out.println("The graph has no clique of size at least "+k);
        
        for( i=0;i<n;i++)
        {
            for( j=0;j<=i;j++)
            {
                if(i!=j)
                {
                    x=mat[i][j];
                    mat[i][j]=mat[j][i]=1-x;
                }     
            }
        }
        
        if(check_clique(mat,n,k,0)==true)
        {
            System.out.println("A stable set of size "+ k+" in our graph is:");
            for(i=0;i<k;i++)
                System.out.print(v[i]+" ");
            System.out.print("\n");
        }
        else
            System.out.println("The graph has no stable set of size at least "+k);
        
        if(n>50)
        {
            long duration=(System.nanoTime()-start)/1000;
            System.out.println("Program ended with a runtime of "+duration/1000+"."+duration%1000+"ms");
        }
    }
}
