package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class RandomUtils {
    public static List<Integer> getRandomList(int min, int max,int size) {
        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < size) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
        return randomList;
    }
}
