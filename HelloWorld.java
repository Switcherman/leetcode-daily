public class HelloWorld {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode start = head;
        for (int i = 2; i < 6; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode l = oddEvenList(start);
        while(l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        boolean isOdd = true;
        head = head.next.next;
        ListNode oddStart = odd;
        ListNode evenStart = even;
        while (head != null) {
            if (isOdd) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            isOdd = !isOdd;
            head = head.next;
        }
        odd.next = evenStart;
        return oddStart;
    }

    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }
}