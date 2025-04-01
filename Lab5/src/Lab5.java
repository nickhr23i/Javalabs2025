
import java.time.*;
import repos.*;
import commands.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Nico
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Repository repo = new Repository();
        Image img = new Image("p1", LocalDate.now(), new String[]{"animal"}, "C:\\Users\\Nico\\Desktop\\Eagle.jpg");
        repo.add(img);
        repo.view(img);

        Service serv = new Service();
        serv.save(repo, "C:\\Users\\Nico\\Desktop\\test.txt");
        Repository repo2 = serv.load("C:\\Users\\Nico\\Desktop\\test.txt");
        System.out.println(repo2.getImages().get(0).path());

    }

}
