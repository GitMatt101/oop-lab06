package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    public static void main(final String... s) {
        /* 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded) */
        final ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            arrList.add(i);
        }

        /* 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1 */
        final LinkedList<Integer> linkList = new LinkedList<>();
        linkList.addAll(arrList);

        /* 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable) */
        int temp = arrList.get(0);
        arrList.set(0, arrList.get(arrList.size() - 1));
        arrList.set(arrList.size() - 1, temp);

        /* 4) Using a single for-each, print the contents of the arraylist */
        for (int elem : arrList) {
            System.out.println(elem);
        }

        /* 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java */
        long time = System.nanoTime();
        for (int i = 1; i <= 100000; i++) {
            arrList.add(0, i);
        }
        System.out.println("Time to insert 100000 as first element in Array List: " + (System.nanoTime() - time));
        time = System.nanoTime();
        for (int i = 1; i <= 100000; i++) {
            linkList.addFirst(i);
        }
        System.out.println("Time to insert 100000 as first element in Linked List: " + (System.nanoTime() - time));

        /* 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java */
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            temp = arrList.get(arrList.size() / 2);
        }
        System.out.println("Time to read the middle element of Array List: " + (System.nanoTime() - time));
        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            temp = linkList.get(linkList.size() / 2);
        }
        System.out.println("Time to read the middle element of Linked List: " + (System.nanoTime() - time));

        /* 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000 */
        final Map<String,Long> world = new HashMap<>();
        world.put("Africa", 1_110_635_000L);
        world.put("Americas", 972_005_000L);
        world.put("Antarctica", 0L);
        world.put("Asia", 4_298_723_000L);
        world.put("Europe", 742_452_000L);
        world.put("Oceania", 38_304_000L);

        /* 8) Compute the population of the world */
        long worldPopulation = 0;
        for (long population : world.values()) {
            worldPopulation += population;
        }
        System.out.println("There are " + worldPopulation + " human beings on planet Earth");
    }
}
