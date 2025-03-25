
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nico
 */
public class Repository {

    private List<Image> images = new ArrayList<>();

    public void add(Image img) {
        getImages().add(img);
    }

    public void view(Image img) {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(img.path());
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }
}
