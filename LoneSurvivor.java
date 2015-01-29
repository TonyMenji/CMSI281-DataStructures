public class LoneSurvivor { 

    private static class Node {
       int value;
       Node next;
    }

    public static Node circularList(int n) {
        Node tail = new Node();
        Node head = tail;
        tail.value = n;

        for (int i = n-1; i >= 1; i--) {
            Node x = new Node();
            x.value = i;
            x.next = head;
            head = x;
        }
        tail.next = head;
        return tail;
    }

    public static int nodeCount(Node head) {
       int n = 0;
       Node x = head;
       do {
          x = x.next;
          n++;
       } 
        while (x != head);
            return n;
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int kill = Integer.parseInt(args[1]);
        Node group = circularList(size);

        while (group != group.next) {     
            for (int i = 1; i < kill; i++){
                group = group.next;
            }
            group.next = group.next.next;
        }

        System.out.println(group.value);
    }
}
