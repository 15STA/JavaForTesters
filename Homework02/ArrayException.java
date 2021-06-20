package JavaForTesters.Lesson2.Homework02;

import java.io.IOException;

public class ArrayException {

    static int n = 4;

    public static void main(String[] args) {
        String[][] myArray1 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };
        String[][] myArray2 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] myArray3 = new String[][]{
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"pink", "10", "11", "12"},
                {"13", "14", "15", "."}
        };

        try {
            int sumArray = arrayException(myArray3);
            System.out.println(sumArray);

        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        catch (MyArrayDataException e) {
          System.out.println("Date in cell [" + e.arrRow + "][" + e.arrCol + "] isn't an integer number");
        }
    }


    public static int arrayException (String [][] array) throws MyArraySizeException, MyArrayDataException{
        int sum =0;
         if ((array.length != n) || (array[0].length != n))
            throw new MyArraySizeException ("Array must have size " + n + "x" + n);

        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }

        return sum;
    }
}
