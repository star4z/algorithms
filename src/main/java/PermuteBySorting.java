import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PermuteBySorting {
    public static void main(String[] args) {
        ArrayList<String> unsortedList = new ArrayList<>();
        unsortedList.add("tomatoes");
        unsortedList.add("noodles");
        unsortedList.add("cheese");
        unsortedList.add("milk");
        unsortedList.add("cereal");
        unsortedList.add("nachos");
        unsortedList.add("carrots");
        unsortedList.add("apples");

        PermuteBySorting pbs = new PermuteBySorting();
        pbs.permuteBySorting(unsortedList);

        System.out.println(unsortedList);
    }

    public <T> void permuteBySorting(List<T> A) {
        int n = A.size();
        int n3 = (int) Math.pow(n, 3);
        Random random = new Random();
        List<Integer> P = A.stream().map(t -> random.nextInt()).collect(Collectors.toList());
        KeyMergeSort keyMergeSort = new KeyMergeSort();
        keyMergeSort.sort(A, P);
    }

    private static class KeyMergeSort {
        public <T, C extends Comparable<C>> void sort(List<T> unsortedList, List<C> keys) {
            int p = 0;
            int r = unsortedList.size() - 1;
            sort(unsortedList, keys, p, r);
        }

        public <T, C extends Comparable<C>> void sort(List<T> A, List<C> keys, int p, int r) {
            if (p < r) {
                int q = (p + r) / 2;
                sort(A, keys, p, q);
                sort(A, keys, q + 1, r);
                merge(A, keys, p, q, r);
            }
        }

        private <T, C extends Comparable<C>> void merge(List<T> A, List<C> P, int p, int q, int r) {
            int n1 = q - p + 1; //size of L
            int n2 = r - q; //size of R
            List<T> L = new ArrayList<>(n1);
            List<C> LP = new ArrayList<>(n1);
            List<T> R = new ArrayList<>(n2);
            List<C> RP = new ArrayList<>(n2);
            for (int i = 0; i < n1; i++) {
                L.add(i, A.get(p + i));
                LP.add(i, P.get(p + i));
            }
            for (int j = 0; j < n2; j++) {
                R.add(j, A.get(q + j + 1));
                RP.add(j, P.get(q + j + 1));
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
                } else if (LP.get(i).compareTo(RP.get(j)) <= 0) {
                    A.set(k, L.get(i));
                    i++;
                } else {
                    A.set(k, R.get(j));
                    j++;
                }
            }
        }
    }
}
