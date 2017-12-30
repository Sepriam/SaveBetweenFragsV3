package com.example.matt.savebetweenfragsv3;

/**
 * Created by Matt on 12/08/2017.
 */

public class Exercises {

    String name = null;
    Boolean selected = false;
    String description = null;

    /**
     * constructor
     * used to create the exercises
     */
    public Exercises(String _name, Boolean _selected)
    {
        super();
        this.name = _name;
        this.selected = _selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
