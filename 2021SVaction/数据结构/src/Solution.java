class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode[] splitListToParts(ListNode head, int k) {
            ListNode[] list;
            if (head == null || k <= 0) return null;
            //拿到链表长度
            int length = getLength(head);
            //平均每个数组元素分到的链表元素
            int m = length / k;
            //多出来的链表元素
            int n = length % k;
            int temp = 0;
            list = new ListNode[k];
            int index = 0;
            ListNode tail = head;
            while (tail != null) {
                list[index] = tail;
                temp = n == 0 ? 0 : 1;
                for (int i = 0; i < k - 1 + temp; i++) {
                    tail = tail.next;
                }
                index++;
                n--;
            }
            return list;
        }

        public int getLength(ListNode head) {
            int count = 0;
            ListNode node = head;
            while (node != null) {
                count++;
                node = node.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(3%5);
    }
}