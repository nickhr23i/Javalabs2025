/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Project {

    private String name;
    private ProjectType type;

    public Project() {
    }

    public Project(String name, ProjectType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public ProjectType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ProjectType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String s = "";
        s = s + "Project name: " + name+"\n";
        s = s + "Project type: " + type+"\n";
        return s;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
