package part1.lesson02.task02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class ArrayOperations {
    private static final ArrayList<Integer> arrayList = new ArrayList<>();
    private static final Random random = new Random();
    private static final int randomSizeArrayList = random.nextInt(100);

    static void randomNumber() {
        for (int i = 0; i < randomSizeArrayList; i++) {
            arrayList.add(random.nextInt());
        }
    }

    static void basicCalculation() {
        for (int i = 0; i < randomSizeArrayList; i++) {
            try {
                if (arrayList.get(i) < 0)
                    throw new MyException(arrayList.get(i));
                if (arrayList.get(i) == Math.pow(Math.sqrt(arrayList.get(i)), 2)) {
                    System.out.println(arrayList.get(i) + " " + Math.pow(Math.sqrt(arrayList.get(i)), 2));
                }
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }
}
