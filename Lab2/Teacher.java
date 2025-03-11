/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Teacher extends Person {

    private Project[] projects;

    /**
     *
     * @param name
     */
    public Teacher(String name) {
        this.name = name;
    }

    /**
     *
     * @param name
     * @param bDate
     */
    public Teacher(String name, LocalDate bDate) {
        this.name = name;
        this.birthDate = bDate;
    }

    /**
     * @return the projects
     */
    public Project[] getProjects() {
        return projects;
    }

    /**
     * @param projects the projects to set
     */
    public void setProjects(Project... projects) {
        this.projects = projects;
        for (Project p : projects) {
            p.setTeacher(this);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        s = s + "Teacher name: " + name + "\n";
        s = s + "Birth date: " + birthDate + "\n";
        s = s + "Projects: " + "\n";
        for (Project p : projects) {
            s = s + p + "\n";
        }
        return s;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Teacher)) {
            return false;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
        Teacher other = (Teacher) obj;
        return name.equals(other.name);
    }
}
