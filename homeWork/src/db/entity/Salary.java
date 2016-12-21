package db.entity;

public class Salary extends Entity {
     private String date;
     private int value;
     private int emp_id;

     public Salary(int id, String date, int value, int emp_id)
     {
         super(id);
         this.date = date;
         this.value = value;
         this.emp_id = emp_id;
     }

    @Override
    public String toString() {
        return "Salary{" +
                "id = " + getId() +
                ", data = " + date +
                ", value = " + value +
                ", emp_id = " + emp_id +
                '}';
    }
}
