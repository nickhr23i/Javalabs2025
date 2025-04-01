/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repos;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nico
 */
public class Service {

    public void save(Repository repo, String path) {

        try (java.io.BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            List<Image> images;
            String imageData;
            images = repo.getImages();
            for (Image i : images) {
                imageData = "";
                imageData = imageData + i.name() + " " + i.date().toString();
                for (String t : i.tags()) {
                    imageData = imageData + " " + t;
                }
                imageData = imageData + " " + i.path() + "\n";
                out.write(imageData);
                out.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Repository load(String path) {
        Repository repo = new Repository();

        try (var in = new BufferedReader(new FileReader(path))) {
            String line, name, date, iPath;
            String[] params, tags;
            List<Image> images = new ArrayList<>();
            while (in.ready()) {
                line = in.readLine();
                params = line.split(" ");
                name = params[0];
                date = params[1];
                tags = new String[params.length - 3];
                for (int i = 0; i < tags.length; i++) {
                    tags[i] = params[i + 2];
                }
                iPath = params[params.length - 1];
                images.add(new Image(name, LocalDate.parse(date), tags, iPath));

            }
            repo.setImages(images);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return repo;
    }
}
