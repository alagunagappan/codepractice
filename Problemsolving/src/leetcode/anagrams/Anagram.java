package leetcode.anagrams;

import java.util.HashMap;

//https://leetcode.com/problems/valid-anagram/
//Difficulty: Easy
public class Anagram {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("a", "am"));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character, Integer> m1 = countChars(s);
        HashMap<Character, Integer> m2 = countChars(t);
        return m1.entrySet().stream()
                .allMatch(e -> e.getValue().equals(m2.get(e.getKey())));
    }

    public HashMap<Character, Integer> countChars(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            countMap.merge(c, 1, Integer::sum);
        }
        return countMap;
    }
}
