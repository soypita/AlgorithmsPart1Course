

public class SecondAssigment {
    public static void main(String[] args) {
        Deque<Integer> deq = new Deque<>();
        int size = deq.size();
        System.out.println(size);
        System.out.println(deq.isEmpty());
        deq.addFirst(1);
        deq.addFirst(2);
        int b = deq.removeLast();
        int a = deq.removeFirst();
        boolean ans = deq.isEmpty();
        deq.addLast(3);
        deq.addLast(4);
        deq.addFirst(5);
        b = deq.removeLast();
        a = deq.removeLast();
    }
}
