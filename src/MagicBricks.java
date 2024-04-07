import java.util.*;

public class MagicBricks {
    public static void main(String[] args) {
        char[] c = new char[]{'a',' ','b','Z'};
        int left = 0;
        int current = 0;
        while (current < c.length){
            if(current == 0){
                c[left] = c[current];
                current++;
            }else if(c[current] > c[current-1]){
                char temp = c[current-1];
                c[left] = c[current];
                c[current] = temp;
                current++;
                left++;
            }else {
                current++;
            }
        }
        System.out.println(c);
    }

    public static int getMinimumFruits(){
        List<Integer> fruits = new ArrayList<>(Arrays.asList(1,2,3,2,5,2));
        HashMap<Integer,Integer> fruitsMap = new HashMap<>();
        for (Integer fruit : fruits){
            fruitsMap.put(fruit,fruitsMap.getOrDefault(fruit,0)+1);
        }

        int count = 0;

        return 0;
    }
}
