package JavaForTesters.Lesson5.Homework05;

import java.io.*;

public class Homework05 {
//    Реализовать сохранение данных в csv файл; Реализовать загрузку данных из csv файла. Файл читается целиком.
//    Структура файла: Строка заголовок с набором столбцов Набор строк с целочисленными значениями
//    Разделитель между столбцами - символ точка с запятой (,)
//        Value1,Value2,Value3
//        100,200,300
//        400,500,600
//
//    Для хранения использовать класс вида
//    public class AppData {
//        private String[] headers;
//        private int[][] data;
//        .........
//    }

    public static void main(String[] args) {
       File file = new File("./dataHomework05.csv");
       AppData appDataToFile = new AppData(
                new String[]{"Value1", "Value2", "Value3"},
                new int[][]{
                        {100, 200, 300},
                        {400, 500, 600},
                        {700, 800, 900}
                        });

        final int dataLines = appDataToFile.getData().length;
        final int dataColumns = appDataToFile.getData()[0].length;
        String[] headerFromFile = new String[dataColumns];
        int[][] dataFromFile = new int[dataLines][dataColumns];

        try (BufferedWriter writeFile = new BufferedWriter(new FileWriter(file))) {
            for (String itemHeader : appDataToFile.getHeaders())
                writeFile.write(itemHeader + ";" );
            writeFile.write("\n");

            for (int i=0; i<dataLines; i++) {
                for (int j = 0; j < dataColumns; j++) {
                    writeFile.write(appDataToFile.getData()[i][j] + ";");
                }
                writeFile.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader readFile = new BufferedReader(new FileReader(file))) {
            String currentLine = null;
            int countLines = 0;
            while ((currentLine = readFile.readLine()) != null){
                if (countLines==0) {
                    headerFromFile = currentLine.split(";");
                }
                else {
                    String[] line = currentLine.split(";");
                    for (int i=0; i<dataColumns; i++) {
                        dataFromFile[countLines-1][i]=Integer.parseInt(line[i]);
                    }
                }
                countLines++;
            }
            AppData appDataFromFile = new AppData(headerFromFile, dataFromFile);
            System.out.println(appDataFromFile.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
