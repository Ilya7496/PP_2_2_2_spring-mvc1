package web.model;

public class Car {
    private int id;
    private String make;
    private int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public Car() {}
     public Car(int id, String make, int year) {
        this.id = id;
        this.make = make;
        this.year = year;
     }
     public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", year=" + year +
                '}';
     }
}
