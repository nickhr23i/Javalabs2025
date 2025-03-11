/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Aircraft airliner=new Airliner("Alpha1");
        Aircraft freighter=new Freighter("Fox5",120.7);
        Aircraft drone = new Drone("Hawk3",8.5);
        
        CargoCapable[] cargo=new CargoCapable[3];
        cargo[0]=new Airliner("D1");
        cargo[1]=new Freighter("F5");
        cargo[2]=new Freighter("F3");
        // TODO code application logic here
    }
    
}
