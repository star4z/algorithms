import java.util.ArrayList;
import java.util.List;


public class InsertionSort implements Sort{

    public <T extends Comparable<T>> List<T> sort(List<T> unsortedList) {
        List<T> sortedList = new ArrayList<>(unsortedList);
        for (int j = 1; j < sortedList.size(); j++) {
            T key = sortedList.get(j);
            int i = j - 1;
            while (i >= 0 && sortedList.get(i).compareTo(key) > 0) {
                sortedList.set(i + 1, sortedList.get(i));
                i--;
            }
            sortedList.set(i + 1, key);
        }
        return sortedList;
    }
}
