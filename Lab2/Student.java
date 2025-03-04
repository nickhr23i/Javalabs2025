/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
import java.time.LocalDate;

public class Student {

    private String name;
    private LocalDate birthDate;
    private long regNumber;

    public Student() {
    }

    public Student(String name, LocalDate bDate, long regNumber) {
        this.name = name;
        this.birthDate = bDate;
        this.regNumber = regNumber;
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

    @Override
    public String toString() {
        String s = "";
        s = s + "Student name:" + name + "\n";
        s = s + "Birth date: " + birthDate + "\n";
        s = s + "Registration Number: " + regNumber + "\n";
        return s;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * @return the birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
