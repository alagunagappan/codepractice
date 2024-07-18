import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/sort-array-by-increasing-frequency/description/">...</a>
 * Difficulty: Easy
 */
public class SortArrayByFrequency {

    public static void main(String[] args) {
        SortArrayByFrequency sortArrayByFrequency = new SortArrayByFrequency();
        int[] nums = {1,2,3,1,2};
        int[] result = sortArrayByFrequency.frequencySort(nums);
        Arrays.stream(result).forEach(System.out::println);
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for(int n : nums) {
            frequencyCount.put(n, frequencyCount.getOrDefault(n, 0) + 1);
        }
        Map<Integer, Integer> sortedMap = frequencyCount.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()) == 0 ?
                            e2.getKey().compareTo(e1.getKey()) : e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        int [] result = new int[nums.length];
        int j=0;
        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for(int i=0; i < entry.getValue(); i++) {
                result[j++] = entry.getKey();
            }
        }

        return result;
    }

}
