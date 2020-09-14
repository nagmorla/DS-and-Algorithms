package dsalg;

import java.util.HashMap;

/**
 *
 * @author nmorla
 * @since Aug 21, 2020
 */
public class LinkedListTestUtils {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        System.out.println(" " + (o1 == o2));

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.remove(0);
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.printElements();
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.add(0, 10);
        list.printElements();
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.add(0, 15);
        list.printElements();
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.add(0, 5);
        list.printElements();
        System.out.println("===============" + list.size() + " - " + list.getLast());
        list.add(3, 23);
        list.printElements();
        System.out.println("===============" + list.size() + " <--> " + list.getLast());
//        Load data into LinkedList
        for (int i = 5; i < 10; i++) {
            list.add(i);
        }
//        Print the data
        list.printElements();
        System.out.println("===============" + list.size() + " <-> " + list.getLast());
        list.addFirst(200);
        list.printElements();
        System.out.println("===============" + list.size() + " <-> " + list.getLast());
        list.addLast(-50);
        list.printElements();
        System.out.println("===============" + list.size() + " <--> " + list.getLast());
//Check if linked list has an element
        System.out.println("List has 50 <==> " + list.contains(50));
        System.out.println("List has 5 <==> " + list.contains(5));
        list.remove(0);
        list.printElements();
        System.out.println("===============" + list.size() + " <-> " + list.getLast());
        list.removeLast();
        list.printElements();
        System.out.println("===============" + list.size() + " <-> " + list.getLast());
    }
}
