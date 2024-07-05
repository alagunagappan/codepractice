// https://leetcode.com/problems/jewels-and-stones/
// Difficulty: Easy

import java.util.List;

public class JewelsAndStones {

    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        int count = jewelsAndStones.numJewelsInStones("aA", "aAAAbb");
        System.out.println(count);
    }

    public int numJewelsInStones(String jewels, String stones) {
        List<Character> jewelList = jewels.chars().mapToObj(c ->(char) c).toList();
        int count = 0;
        List<Character> stoneList = stones.chars().mapToObj(c ->(char) c).toList();
        for(char c:stoneList) {
            if(jewelList.contains(c))
                count++;
        }
        return count;
    }
}
