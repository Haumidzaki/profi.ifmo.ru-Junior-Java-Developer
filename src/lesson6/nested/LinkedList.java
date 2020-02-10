package lesson6.nested;

import java.util.Iterator;

public class LinkedList implements Iterable{
    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);

            return;
        }

        find(-1).next = new Node(value);
    }

    public int get(int idx) {
        Node res = find(idx);

        return res == null ? -1 : res.value;
    }

    public int remove(int idx) {
        if (head == null)
            return -1;

        if (idx == 0) {
            int val = head.value;

            head = head.next;

            return val;
        }

        Node prev = find(idx - 1);

        if (prev != null) {
            Node cur = prev.next;

            if (cur != null) {
                prev.next = prev.next.next;

                return cur.value;
            }
        }

        return -1;
    }

    private Node find(int idx) {
        if (idx == 0)
            return head;

        int cnt = 0;

        Node node = head;

        while (node != null) {
            if (cnt++ == idx)
                return node;

            if (idx < 0 && node.next == null)
                return node;

            node = node.next;
        }

        return null;
    }


    @Override
    public Iterator iterator() {
        return new ListIterator(head);
    }

    private class ListIterator implements Iterator{
        Node next;

        public ListIterator(Node node) {
            this.next = node;
        }


        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            Object cur = next.value;
            next = next.next;
            return cur;
        }
    }
}


class Node {
    int value;

    Node next;

    public Node(int value) {
        this.value = value;
    }
}

