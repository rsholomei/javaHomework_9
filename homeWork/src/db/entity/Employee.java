package db.entity;

public class Employee extends Entity {
    private String name;
    public Employee(int id, String name)
    {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id = " + getId() +
                ", name = '" + name + '\'' +
                '}';
    }
}
