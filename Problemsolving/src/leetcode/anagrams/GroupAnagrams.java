package leetcode.anagrams;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.ArrayList;

/*
    https://leetcode.com/problems/group-anagrams/description/
    Difficulty: Medium
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> anagrams = GroupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(anagrams);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Your code here
        HashMap<String, List<String>> tempAnagrams = new LinkedHashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!tempAnagrams.containsKey(key))
                tempAnagrams.put(key, new ArrayList<>());

            tempAnagrams.get(key).add(s);
        }
        List<List<String>> groupedAnagrams = new ArrayList<>(tempAnagrams.values());
        return groupedAnagrams;
    }
}
