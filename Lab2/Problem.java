/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Problem {

    private Student[] students;
    private Teacher[] teachers;

    /**
     *
     */
    public Problem() {
    }

    /**
     * @return the students
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(Student... students) {
        boolean found;
        Student[] buffer = new Student[100];
        int counter = 0;
        for (Student s : students) {
            found = false;
            for (int i = 0; i < counter; i++) {
                if (s.equals(buffer[i])) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                buffer[counter] = s;
                counter++;
            }
        }
        this.students = new Student[counter];
        System.arraycopy(buffer, 0, this.students, 0, counter);
    }

    /**
     * @return the teachers
     */
    public Teacher[] getTeachers() {
        return teachers;
    }

    /**
     * @param teachers the teachers to set
     */
    public void setTeachers(Teacher... teachers) {
        boolean found;
        Teacher[] buffer = new Teacher[100];
        int counter = 0;
        for (Teacher t : teachers) {
            found = false;
            for (int i = 0; i < counter; i++) {
                if (t.equals(buffer[i])) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                buffer[counter] = t;
                counter++;
            }
        }
        this.teachers = new Teacher[counter];
        System.arraycopy(buffer, 0, this.teachers, 0, counter);
    }

    /**
     *
     * @return
     */
    public Person[] getPersons() {
        Person[] persons = new Person[students.length + teachers.length];
        System.arraycopy(students, 0, persons, 0, students.length);
        System.arraycopy(teachers, 0, persons, students.length, teachers.length);
        return persons;
    }

}
