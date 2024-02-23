package ss.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {


    public static <E extends Comparable<E>> List<E> sortAndMergeSplitArrays(List<E> l1, List<E> l2, List<E> list) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i).compareTo(l2.get(j)) < 1) {
                list.add(l1.get(i));
                i++;
            } else {
                list.add(l2.get(j));
                j++;
            }
            k++;
        }

        if (i == l1.size()) {
            while (j < l2.size()) {
                list.add(l2.get(j));
                j++;
                k++;
            }
        }
        if (j == l2.size()) {
            while (i < l1.size()) {
                list.add(l1.get(i));
                i++;
                k++;
            }
        }

        return list;
    }


    public static <E extends Comparable<E>> void mergesort(List<E> list) {
        // TODO: implement, see exercise P-4.3
        //indexes to split the list in half:
        int indexLo = 0;
        int indexHi = list.size();

        //List<E> to put the split list
        List<E> left = new ArrayList<>();
        List<E> right = new ArrayList<>();
        if (indexHi > 1) { // if there's more than one item in a list
            int indexMid = indexHi / 2;
            for (int i = 0; i < indexMid; i++) {
                left.add(list.get(i));
            }
            for (int i = indexMid; i < indexHi; i++) {
                right.add(list.get(i));
            }

            mergesort(left);
            mergesort(right);
            list.clear(); //after splitting a list, empty it
            sortAndMergeSplitArrays(left, right, list); // sort the items of the split lists and put them back together with a helper method sortAndMergeSplitArrays()
        }
    }
}