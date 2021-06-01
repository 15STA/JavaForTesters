package JavaForTesters.Lesson5.Homework05;

import java.util.Arrays;

public class AppData  {
    private String[] headers;
    private int[][] data;
    public AppData(String[] headers, int[][] data) {
        this.headers = headers;
        this.data = data;
    }

    @Override
    public String toString() {

        return "AppData{" +
                "headers=" + Arrays.toString(headers) +
                ", data=" + Arrays.deepToString(data) +
                '}';
    }

    public String[] getHeaders() {
        return headers;
    }

    public int[][] getData() {
        return data;
    }
}
