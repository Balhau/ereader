package org.balhau.books.cybook.domain;

/**
 * Domain objects for Author entries
 * Created by vitorfernandes on 10/15/16.
 */
public class CybookAuthor {
    private final int id;
    private final String name;

    public CybookAuthor(int id,String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
