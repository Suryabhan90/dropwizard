package com.suryabhan.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by suryabhan on 23/04/16.
 */
@Entity
@Table(name = "testtable")
@NamedQueries({
        @NamedQuery(name = "com.suryabhan.core.TestDatabase.findAll",
                query = "select e from TestDatabase e")
})
public class TestDatabase {


    /**
     * Entity's unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    @Column(name = "name")
    @JsonProperty("name")
    private String firstName;

    public int getId() {
        return id;
    }

    public TestDatabase(String firstName) {
        this.firstName = firstName;
    }

    public TestDatabase() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
