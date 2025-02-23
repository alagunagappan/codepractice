import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1

public class CountDuplicates {

    public static void main(String[] args) {
        CountDuplicates countDuplicates = new CountDuplicates();
        String str = "aabbcde";
        int count = countDuplicates.countInsensitiveDuplicateChars(str);
        System.out.println(count);
    }

    public int countInsensitiveDuplicateChars(String str) {
        if(str.isEmpty() || str.length() == 1)
            return 0;
        HashMap<Character, Integer> charCount = new HashMap<>();
        char[] chars = str.toLowerCase().toCharArray();
        for(char ch : chars) {
            charCount.put(Character.toLowerCase(ch), charCount.getOrDefault(Character.toLowerCase(ch), 0) + 1);
        }

        Map<Character, Integer> result = filterByValue(charCount, value -> value > 1);
        return result.size();
    }

    public <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet().stream()
                .filter(entry -> predicate.test(entry.getValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }
}
