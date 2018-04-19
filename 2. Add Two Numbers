class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode(0);
        ListNode head = tail;
        int res = 0;
        int c = 0;
        while(l1 != null || l2 != null || c != 0){
            if(l1 == null ) l1 = new ListNode(0);
            if(l2 == null ) l2 = new ListNode(0);
            
            res = (l1.val + l2.val + c) % 10;
            tail.next = new ListNode(res);
            c = (l1.val + l2.val + c) / 10;
            l1 = l1.next;
            l2 = l2.next;
            tail = tail.next;
        }
        head = head.next;
        return head;
    }
}

 
