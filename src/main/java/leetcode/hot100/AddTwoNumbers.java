package leetcode.hot100;

/**
 * leetcode-2  两数相加  https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author wangpengzhe
 * @date 2020/1/22 13:19
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3);
        l1.next = a;
        a.next = b;
        b.next = null;

        ListNode l2 = new ListNode(5);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(4);
        l2.next = c;
        c.next = d;
        d.next = null;

        addTwoNumbers(l1, l2);
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int jinwei = 0;
        ListNode root = l1;
        ListNode cursor = root;
        ListNode pre = root;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + jinwei;
            if (cursor == null) {
                if (l2 != null) {
                    cursor = l2;
                    pre.next=l2;
                }
            }
            cursor.val = sum % 10;
            jinwei = sum / 10;
            pre = cursor;
            cursor = cursor.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (jinwei != 0) {
            pre.next = new ListNode(jinwei);
        }

        return root;
    }
}
