/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.dei.isep.ipp.pt.examples.model;

import java.io.Serializable;

/**
 *
 * @author nuno
 */
public class User implements Serializable{

    private Long id = 1L;
    private String name;
    private Integer age;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}
