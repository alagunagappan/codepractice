import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * Difficulty: Easy
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum.twoSum(nums, target);
        Arrays.stream(result).forEach(System.out::println);
    }

    public int[] twoSum(int[] nums, int target) {
        /*Map<Integer, Integer> numPositionMap = IntStream.range(0, nums.length)
                                                        .boxed()
                .collect(Collectors.toMap(i -> i, i -> nums[i]));

        for(int i : numPositionMap.keySet()) {
            int n = numPositionMap.get(i);
            int diff = target - n;

            List<Integer> index = numPositionMap.entrySet().stream()
                    .filter(entry -> entry.getKey() != i && entry.getValue().equals(diff))
                    .map(Map.Entry::getKey)
                    .toList();

            if(!index.isEmpty())
                return new int[]{i, index.getFirst()};
*/
        Map<Integer, Integer> numPositionMap = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            numPositionMap.put(nums[i], i);
        }

        for(int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(numPositionMap.containsKey(diff) && numPositionMap.get(diff) != i)
                return new int[]{i, numPositionMap.get(diff)};
        }
        return new int[]{};
    }
}
