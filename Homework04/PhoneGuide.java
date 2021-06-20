package JavaForTesters.Lesson4.Homework04;

import java.util.HashMap;

public class PhoneGuide {
    HashMap<String, String> hmPhoneGuide;

    public PhoneGuide(HashMap<String, String> hmPhoneGuide) {
        this.hmPhoneGuide = hmPhoneGuide;
    }

    // Method for Task 2: Add phone, name to phoneGuide.
    public void add(String phone, String name) {
        this.hmPhoneGuide.put(phone, name);
    }

    // Method for Task 2: Find phone by name
    public HashMap<String, String> get (String name){
        HashMap<String, String> phoneByName= new HashMap<>();
        for (String key : this.hmPhoneGuide.keySet()) {
            if (this.hmPhoneGuide.get(key).equals(name)) {
                phoneByName.put(key, this.hmPhoneGuide.get(key));
            }
        }
        return phoneByName;
    }
}
