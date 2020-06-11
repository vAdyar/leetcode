package array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
//        map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0l) + 1);
        }

        for(Map.Entry<Integer, Long> el: map.entrySet()) {
            if(el.getValue() == 1)
                return el.getKey();
        }
        return 0;
    }

//    a^a = 0
//    a^0 = a
    public static int singleNumber1(int[] nums) {
        int a = 0;
        for(int el: nums) {
            a ^= el;
        }
        return a;
    }

//  2 * (a+b+c)−(a+a+b+b+c)=c
    public static int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int setSum = 0;
        int arraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(set.add(nums[i])) {
                setSum += nums[i];
            }
            arraySum += nums[i];
        }
        return 2 * (setSum) - arraySum;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        System.out.println(singleNumber(nums));
        System.out.println(singleNumber1(nums));
        System.out.println(singleNumber2(nums));
    }
}
