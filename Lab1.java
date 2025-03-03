/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1;

/**
 *
 * @author nico
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        // TODO code application logic here
    }
    
    void compulsory(){
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
}
