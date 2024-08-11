package week4;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("ABC", 10);
        hashMap.put("BBB", 20);
        hashMap.put("AAA", 30);
        hashMap.put("ABC", 15);

        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.get("ABC"));
        System.out.println(hashMap.containsKey("ABC"));

        hashMap.remove("ABC");
        System.out.println(hashMap.size());

        hashMap.clear();
        System.out.println(hashMap.isEmpty());
    }
}
