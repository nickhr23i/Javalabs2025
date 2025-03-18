/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nico
 */
import java.time.LocalDate;

/**
 *
 * @author Nico
 */
public class Lab2 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Student s1 = new Student("Andrei", LocalDate.now(), 1234);
        Project p1 = new Project("Project1", ProjectType.THEORETICAL);
        System.out.print(s1);
        System.out.print(p1);

        Student s2 = new Student("Marian");
        Student s3 = new Student("Rares");
        Student s4 = new Student("Dragos");
        Project p2 = new Project("Project2", ProjectType.THEORETICAL);
        Project p3 = new Project("Project3", ProjectType.THEORETICAL);
        Project p4 = new Project("Project4", ProjectType.THEORETICAL);
        Teacher t1 = new Teacher("Popescu Daniel");
        Teacher t2 = new Teacher("Ionescu Adrian");
        t1.setProjects(p1, p3);
        t2.setProjects(p2, p4);
        s1.setPreferences(p1, p2);
        s2.setPreferences(p1, p3);
        s3.setPreferences(p3, p4);
        s4.setPreferences(p1, p4);
        Problem prob = new Problem();
        prob.setStudents(s1, s2, s3, s4);
        prob.setTeachers(t1, t2);

        Person[] pers = prob.getPersons();
        for (Person p : pers) {
            System.out.print(p.getName() + "\n");
        }
        Solution sol = new Solution(prob);
        sol.solve();
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        System.out.println("Is the problem solvable? "+sol.solvable());
        long runningTime = System.currentTimeMillis()- initialTime;
        long usedMemoryAfter = runtime.totalMemory()- runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("runtime: "+runningTime+" milliseconds");
        System.out.println("memory used: "+memoryIncrease+" bytes");

        System.out.println("\n\n\nFeasible instance of 20 students and 40 projects");
        Student[] s=new Student[20];
        Project[] p=new Project[40];
        for(int i=0;i<=19;i++){
            s[i]=new Student("st"+(i+1));
            p[2*i]=new Project("pr"+(2*i+1));
            p[2*i+1]=new Project("pr"+(2*i+2));
            s[i].setPreferences(p[2*i+(int)(Math.random()*1000)%2]);
        }
        prob=new Problem();
        prob.setStudents(s);
        sol=new Solution(prob);
        System.gc();
        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        initialTime = System.currentTimeMillis();
        System.out.println("Is the problem solvable? "+sol.solvable());
        runningTime = System.currentTimeMillis()- initialTime;
        usedMemoryAfter = runtime.totalMemory()- runtime.freeMemory();
        memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("runtime: "+runningTime+" milliseconds");
        System.out.println("memory used: "+memoryIncrease+" bytes");
        
        System.out.println("\n\n\nInfeasible instance of 20 students and 40 projects");
        for(int i=0;i<=19;i++){
            s[i]=new Student("st"+(i+1));
            p[2*i]=new Project("pr"+(2*i+1));
            p[2*i+1]=new Project("pr"+(2*i+2));
        }
        for(int i=0;i<=19;i++){
            s[i].setPreferences(p[i-i%5+(int)(Math.random()*1000)%4]);
        }
        prob=new Problem();
        prob.setStudents(s);
        sol=new Solution(prob);
        System.gc();
        usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        initialTime = System.currentTimeMillis();
        System.out.println("Is the problem solvable? "+sol.solvable());
        runningTime = System.currentTimeMillis()- initialTime;
        usedMemoryAfter = runtime.totalMemory()- runtime.freeMemory();
        memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("runtime: "+runningTime+" milliseconds");
        System.out.println("memory used: "+memoryIncrease+" bytes");
        
    }

}
