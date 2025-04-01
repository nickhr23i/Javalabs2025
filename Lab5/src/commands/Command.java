/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package commands;

import repos.*;

/**
 *
 * @author Nico
 */
public abstract class Command {

    private Repository repo;
    private String[] arguments;

    public abstract void handle();

    /**
     * @return the repository
     */
    public Repository getRepo() {
        return repo;
    }

    /**
     * @param repo the repository to set
     */
    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    /**
     * @return the arguments
     */
    public String[] getArguments() {
        return arguments;
    }

    /**
     * @param arguments the arguments to set
     */
    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }
}
