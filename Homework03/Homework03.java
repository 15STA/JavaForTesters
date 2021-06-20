package JavaForTesters.Lesson3.Homework03;

import JavaForTesters.Lesson3.Online.Demo2;

import java.text.DecimalFormat;

public class Homework03 {

    public static void main(String[] args) {
        DecimalFormat x = new DecimalFormat("###.###");
        Apple apple1 = new Apple(0, 0.22f);
        Apple apple2 = new Apple(1, 0.19f);
        Apple apple3 = new Apple(2, 0.21f);
        Apple apple4 = new Apple(3, 0.25f);
        Apple apple5 = new Apple(4, 0.2f);
        Apple apple6 = new Apple(5, 0.23f);
        Apple apple7 = new Apple(6, 0.22f);

        Apple[] applesArr1 = {apple1, apple2, apple3};
        Apple[] applesArr2 = {apple4, apple5, apple6, apple7};

        Orange orange1 = new Orange(0, 0.3f);
        Orange orange2 = new Orange(1, 0.32f);
        Orange orange3 = new Orange(2, 0.28f);

        Orange[] orangesArr1 = {orange1, orange2, orange3};

       //----------------------------------------


        changeArrayItem(orangesArr1, 2, 0);

        for (int i=0; i<orangesArr1.length; i++){
            System.out.print(orangesArr1[i]);
        }
        System.out.println();


        // --------------------------------------
        Box<Apple> BoxForApples1 = new Box<>(applesArr1);
        Box<Apple> BoxForApples2 = new Box<>(applesArr2);
        Box<Orange> BoxForOranges1 = new Box<>(orangesArr1);

        System.out.println("Weight of the first box of apples is " + x.format(BoxForApples1.getWeight()));
        System.out.println("Weight of the second box of apples is " + x.format(BoxForApples2.getWeight()));
        System.out.println("Weight of the box of oranges is " + x.format(BoxForOranges1.getWeight()));

        // -----------------------------------------
        System.out.println("Comparing boxes of apples: " + BoxForApples1.compareBox(BoxForApples2));
        System.out.println("Comparing the first box of apples and box of oranges: " + BoxForApples1.compareBox(BoxForOranges1));
        System.out.println("Comparing the second box of apples and box of oranges: " + BoxForApples2.compareBox(BoxForOranges1));

        //--------------------------------
        BoxForApples1.putFruitToAnotherBox(BoxForApples2);
        System.out.println("Weight of the second box of apples is " + x.format(BoxForApples2.getWeight()));

        // --------------------------------------


    }

    // this method changes array's element k, m in places
    public static void changeArrayItem (Object[] array, int k, int m) {
        Object temp = array[k];
        array[k] = array[m];
        array[m] = temp;
    }





}
