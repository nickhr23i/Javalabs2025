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
public class Student extends Person {

    private long regNumber;
    private Project assignedProject;
    private Project[] preferences;

    /**
     *
     * @param name
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     *
     * @param name
     * @param bDate
     * @param regNumber
     */
    public Student(String name, LocalDate bDate, long regNumber) {
        this.name = name;
        this.birthDate = bDate;
        this.regNumber = regNumber;
    }

    /**
     *
     * @param name
     * @param bDate
     * @param regNumber
     * @param preferences
     */
    public Student(String name, LocalDate bDate, long regNumber, Project... preferences) {
        this.name = name;
        this.birthDate = bDate;
        this.regNumber = regNumber;
        this.preferences = preferences;
    }

    /**
     * @return the regNumber
     */
    public long getRegNumber() {
        return regNumber;
    }

    /**
     * @param regNumber the regNumber to set
     */
    public void setRegNumber(long regNumber) {
        this.regNumber = regNumber;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        s = s + "Student name: " + name + "\n";
        s = s + "Birth date: " + birthDate + "\n";
        s = s + "Registration Number: " + regNumber + "\n";
        return s;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * @return the assignedProject
     */
    public Project getAssignedProject() {
        return assignedProject;
    }

    /**
     * @param assignedProject the assignedProject to set
     */
    public void setAssignedProject(Project assignedProject) {
        this.assignedProject = assignedProject;
        this.assignedProject.setAssignedStudent(this);
    }

    /**
     * @return the preferences
     */
    public Project[] getPreferences() {
        return preferences;
    }

    /**
     * @param preferences the preferences to set
     */
    public void setPreferences(Project... preferences) {
        this.preferences = preferences;
        for (Project p : preferences) {
            p.incFrequency();
        }
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Student)) {
            return false;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }
        Student other = (Student) obj;
        return name.equals(other.name);
    }

}
