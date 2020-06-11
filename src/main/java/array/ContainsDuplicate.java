package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if( map.containsKey(nums[i]) )
                return true;
            else
                map.put(nums[i], 1);
        }
        return false;
    }

    public static boolean containsDuplicate1(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() != nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate1(nums));

    }
}
