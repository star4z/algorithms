import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {
    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> unsortedList) {
        List<T> sortedList = new ArrayList<>(unsortedList);
        int p = 0;
        int r = sortedList.size() - 1;
        sort(sortedList, p, r);
        return sortedList;
    }

    public <T extends Comparable<T>> void sort(List<T> A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private <T extends Comparable<T>> void merge(List<T> A, int p, int q, int r) {
        int n1 = q - p + 1; //size of L
        int n2 = r - q; //size of R
        List<T> L = new ArrayList<>(n1);
        List<T> R = new ArrayList<>(n2);
        for (int i = 0; i < n1; i++) {
            L.add(i, A.get(p + i));
        }
        for (int j = 0; j < n2; j++) {
            R.add(j, A.get(q + j + 1));
        }
        int i = 0; //index for L
        int j = 0; //index for R
        for (int k = p; k <= r; k++) {
            if (i >= n1) {
                A.set(k, R.get(j));
                j++;
            } else if (j >= n2) {
                A.set(k, L.get(i));
                i++;
            } else if (L.get(i).compareTo(R.get(j)) <= 0) {
                A.set(k, L.get(i));
                i++;
            } else {
                A.set(k, R.get(j));
                j++;
            }
        }
    }
}
