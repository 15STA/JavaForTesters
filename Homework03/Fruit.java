package JavaForTesters.Lesson3.Homework03;

import java.text.DecimalFormat;

public class Fruit {
    protected int id;
    protected double weight;
    DecimalFormat x = new DecimalFormat("###.###");

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Fruit (int id, double weight){
        this.id = id;
        this.weight = weight;
        }

    public String toString()
    {
        return id + " - " + x.format(weight) + " ";
    }
}
