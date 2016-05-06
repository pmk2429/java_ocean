package list;

/**
 * Java program to find MIDDLE element of linked list in one pass. In order to
 * find middle element of linked list we need to find length first but since we
 * can only traverse linked list one time, we will use two pointers one which we
 * will increment on each iteration while other which will be incremented every
 * second iteration. so when first pointer will point to the end of linked list,
 * second will be pointing to the middle element of linked list
 */

public class LinkedListMiddle {
    public static void main(String[] args) {

        LinkedListDemo llDemo = new LinkedListDemo();
        LinkedListDemo.Node head = llDemo.head();

        llDemo.add(new LinkedListDemo.Node("1"));
        llDemo.add(new LinkedListDemo.Node("2"));
        llDemo.add(new LinkedListDemo.Node("3"));
        llDemo.add(new LinkedListDemo.Node("4"));
        llDemo.add(new LinkedListDemo.Node("5"));

        /**
         * point current and middle to head i.e. at the start of the LinkedList
         */
        LinkedListDemo.Node current = head;
        LinkedListDemo.Node middle = head;
        LinkedListDemo.Node last = head;

        // define length of LinkedList
        int length = 0;

        /**
         * Algorithm to find the middle element of the LinkedList. First the
         * length of list is determined and accordingly the check is made. i.e.
         * if(length%2 ==0)--> even or if(length%2==1) --> odd. This while loop
         * will increment 'current' for every iteration and will increment
         * 'middle' only when 'current' will be incremented twice. This means
         * for every 2nd iteration of current, middle is incremented.
         */
        while (current.next() != null && current != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next();
            }
            current = current.next();
            if (current == null) {
                break;
            } else {
                continue;
            }
        }
        if (length % 2 == 1) {
            middle = middle.next();
        }
        System.out.println("Length of LinkedList: " + length);
        System.out.println("middle element of LinkedList: " + middle);

        /**
         * This while loop is used to find the 3rd last element in the
         * LinkedList. It increments 'last' when the current advances to 3rd
         * element in LinkedList.
         */
        while (current.next() != null && current != null) {
            length++;
            if (length % 2 == 0) {
                last = last.next();
            }
            current = current.next().next();
            if (current == null) {
                break;
            } else {
                continue;
            }
        }
        if (length % 2 == 1) {
            last = last.next();
        }
        System.out.println("Length of LinkedList: " + length);
        System.out.println("middle element of LinkedList: " + middle);

    }
}

// LinkedList class
class LinkedListDemo {
    private Node head;
    private Node tail;

    public LinkedListDemo() {
        this.head = new Node("head");
        tail = head;
    }

    public Node head() {
        return head;
    }

    public void add(Node node) {
        tail.next = node;
        tail = node;
    }

    // Nested Node class
    public static class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return this.data;
        }
    }
}