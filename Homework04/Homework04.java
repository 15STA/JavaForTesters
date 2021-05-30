package JavaForTesters.Lesson4.Homework04;

import java.util.*;

public class Homework04 {
    public static void main(String[] args) {
        // Task1
//         Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//         Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//         Посчитать, сколько раз встречается каждое слово.

        String[] stringArray = {"yes", "no", "why", "when", "yes", "how", "no", "much", "yes", "when", "as usual", "well", "great", "how"};
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(stringArray));
        System.out.println(uniqueWords);

        HashMap<String, Integer> wordToCount = wordAndQuantity(stringArray);
        for (HashMap.Entry<String, Integer> pair : wordToCount.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
        System.out.println("-------------------");


        // Task2
        // Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.

        HashMap<String, String> phoneAndName= new HashMap<>();
        PhoneGuide myPhoneGuide = new PhoneGuide(phoneAndName);

        myPhoneGuide.add("84951112233", "Ivanov");
        myPhoneGuide.add("84951112234", "Petrov");
        myPhoneGuide.add("84951112235", "Sidorov");
        myPhoneGuide.add("84951112236", "Petrov");
        myPhoneGuide.add("84951112237", "Zimin");
        myPhoneGuide.add("84951112238", "Volkov");
        myPhoneGuide.add("84951112239", "Petrov");
        myPhoneGuide.add("84951112240", "Lukin");
        myPhoneGuide.add("84951112241", "Ivanov");
        myPhoneGuide.add("88001234567", "Sidorov");
        myPhoneGuide.add("88001113456", "Golubev");

        HashMap<String, String> hm1 = myPhoneGuide.get("Petrov");

        for (Map.Entry<String, String> hmEntry : hm1.entrySet()) {
            System.out.println(hmEntry.getValue() + ": " + hmEntry.getKey());
        }
    }

  // Method for Task 1: Word - Quantity
    public static HashMap<String, Integer> wordAndQuantity(String[] arr){
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (String word : arr){
            if (!stringIntegerHashMap.containsKey(word)) {
                stringIntegerHashMap.put(word, 0);
            }
            stringIntegerHashMap.put(word, stringIntegerHashMap.get(word) + 1);
        }
    return (stringIntegerHashMap);
    }
}
