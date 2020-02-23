import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> unsortedList) {
        List<T> sortedList = new ArrayList<>(unsortedList);
        int p = 0;
        int r = sortedList.size() - 1;
        int q = r / 2;
        merge(sortedList, p, q, r);
        return sortedList;
    }

    private <T extends Comparable<T>> void merge(List<T> A, int p, int q, int r) {
        int n1 = q - p;
        int n2 = r - q;
        List<T> L = new ArrayList<>(n1);
        List<T> R = new ArrayList<>(n2);
        for (int i = 0; i < n1; i++) {
            L.set(i, A.get(p + i));
        }
        for (int j = 0; j < n2; j++) {
            R.set(j, A.get(q + j));
        }
        L.set(n1, null);
        R.set(n2, null);
        int i = 1;
        int j = 1;
        for (int k = p; k < r; k++) {
            if (L.get(i).compareTo(R.get(j)) <= 0) {
                A.set(k, L.get(i));
                i++;
            } else {
                A.set(k, R.get(j));
                j++;
            }
        }
    }
}
