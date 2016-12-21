package db.entity;

import java.io.Serializable;

public class Entity implements Serializable, Cloneable {
    private int id;
    public Entity(int id)
    {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
