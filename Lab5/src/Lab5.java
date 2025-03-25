
import java.time.*;

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
        Image img = new Image("p1", LocalDate.now(), null, "C:\\Users\\Nico\\Desktop\\Eagle.jpg");
        repo.add(img);
        repo.view(img);
    }

}
