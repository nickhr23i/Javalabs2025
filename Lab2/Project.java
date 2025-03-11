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
    private Teacher teacher;
    private Student assignedStudent;
    private int frequency;

    /**
     *
     */
    public Project() {
    }

    /**
     *
     * @param name
     * @param type
     */
    public Project(String name, ProjectType type) {
        this.name = name;
        this.type = type;
        this.frequency = 0;
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        s = s + "Project name: " + name + "\n";
        s = s + "Project type: " + type + "\n";
        return s;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * @return the teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        if (this.teacher == null) {
            this.teacher = teacher;
        }
    }

    /**
     * @return the assignedStudent
     */
    public Student getAssignedStudent() {
        return assignedStudent;
    }

    /**
     * @param assignedStudent the assignedStudent to set
     */
    public void setAssignedStudent(Student assignedStudent) {
        if (this.assignedStudent == null) {
            this.assignedStudent = assignedStudent;
        }
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Project)) {
            return false;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
        Project other = (Project) obj;
        return name.equals(other.name);
    }

    /**
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     *
     */
    public void incFrequency() {
        this.frequency++;
    }

}
