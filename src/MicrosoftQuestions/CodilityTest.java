package MicrosoftQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CodilityTest {
    public static void main(String[] args) {
        int[] task = new int[]{3,1,2};
        System.out.println(solution(task));
    }

    public static int solution(int[] task) {
        int currentTime = 0;
        int totalTime = 0;
        if(task.length == 1)
            return  task[0];
        int taskLength = task.length;

        List<Integer> list = new ArrayList<>(Arrays.stream(task).boxed().toList());

        while(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                currentTime++;
                list.set(i,list.get(i)-1);
                if(list.get(i) == 0) {
                    totalTime+=currentTime;
                    list.remove(i);
                }
            }
        }

//        while(taskLength > 0){
//            for (int i = 0; i <task.length; i++) {
//                if(task[i] > 0){
//                    task[i]--;
//                    currentTime++;
//                    if(task[i] == 0) {
//                        totalTime += currentTime;
//                        taskLength--;
//                    }
//                }
//            }
//        }
        return totalTime;
    }

}


