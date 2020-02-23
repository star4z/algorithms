import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.*;


public abstract class TestSort {
    Sort sort;

    @Test
    public void testSortShortStringList() {
        ArrayList<String> unsortedList = new ArrayList<>();
        unsortedList.add("tomatoes");
        unsortedList.add("noodles");
        unsortedList.add("cheese");
        unsortedList.add("milk");
        unsortedList.add("cereal");
        unsortedList.add("nachos");
        unsortedList.add("carrots");
        unsortedList.add("apples");

        testSort(unsortedList);
    }

    @Test
    public void testSortIntegerList() {
        Random random = new Random(42L);
        ArrayList<Integer> unsortedList = new ArrayList<>(10_000);
        for (int i = 0; i < 10_000; i++) {
            unsortedList.add(random.nextInt());
        }

        testSort(unsortedList);
    }

    private <T extends Comparable<T>> void testSort(List<T> unsortedList) {
        List<T> groundTruth = new ArrayList<>(unsortedList);
        Collections.sort(groundTruth);
        List<T> sortedList = sort.sort(unsortedList);

        System.out.println("expected=" + groundTruth);
        System.out.println("actual=" + sortedList);
        assertEquals(groundTruth, sortedList);
    }
}
