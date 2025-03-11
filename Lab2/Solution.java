/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nico
 */
public class Solution {

    private Problem problem;

    /**
     *
     * @param p
     */
    public Solution(Problem p) {
        problem = p;
    }

    /**
     * @return the problem
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     * @param problem the problem to set
     */
    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    /**
     *
     */
    public void solve() {
        Student[] students = problem.getStudents();
        int[] freq = new int[students.length];
        Project[] pref;
        Student sAux;
        int iAux;
        int frMin, fr;
        Project pMin;
        boolean ok = true;
        for (int i = 0; i < students.length; i++) {
            pref = students[i].getPreferences();
            freq[i] = 0;
            for (Project p : pref) {
                freq[i] += p.getFrequency();
            }
        }
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (freq[i] > freq[j]) {
                    sAux = students[i];
                    students[i] = students[j];
                    students[j] = sAux;
                    iAux = freq[i];
                    freq[i] = freq[j];
                    freq[j] = iAux;
                }
            }
        }
        for (int i = 0; i < students.length; i++) {
            frMin = freq[i] + 1;
            pMin = null;
            pref = students[i].getPreferences();
            for (Project p : pref) {
                fr = p.getFrequency();
                if (fr < frMin && p.getAssignedStudent() == null) {
                    frMin = fr;
                    pMin = p;
                }
            }
            if (frMin == freq[i] + 1) {
                ok = false;
                break;
            }
            students[i].setAssignedProject(pMin);
        }

        if (ok == false) {
            System.out.println("Nu exista solutie!");
        } else {
            for (Student student : students) {
                System.out.print(student.getName() + " : " + student.getAssignedProject().getName() + "\n");
            }
        }
    }
}
