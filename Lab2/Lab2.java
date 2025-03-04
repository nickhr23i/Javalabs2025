/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nico
 */
import java.time.LocalDate;

public class Lab2 {
    
    public static void main(String[] args) {
        Student s1=new Student("Andrei",LocalDate.now(),1234);
        Project p1=new Project("Project1",ProjectType.THEORETICAL);
        System.out.print(s1);
        System.out.print(p1);
        
        // TODO code application logic here
    }
    
}
