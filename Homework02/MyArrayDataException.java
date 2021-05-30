package JavaForTesters.Lesson2.Homework02;

public class MyArrayDataException extends  Exception{
    public int arrRow;
    public int arrCol;

    public MyArrayDataException(int arrRow, int arrCol){
        this.arrRow = arrRow;
        this.arrCol = arrCol;
    }
}
