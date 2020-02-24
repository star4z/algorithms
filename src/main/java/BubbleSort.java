import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Sort {
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> unsortedList) {
        ArrayList<T> sortedList = new ArrayList<>(unsortedList);
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = sortedList.size() - 1; j > i; j--) {
                if (sortedList.get(j).compareTo(sortedList.get(j - 1)) < 0) {
                    T swap = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j - 1));
                    sortedList.set(j - 1, swap);
                }
            }
        }
        return sortedList;
    }
}
