/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode tail=null;
        int z=0;//carriernumbers
        while(l1!=null||l2!=null||z!=0){
           int sum=z;
           if(l1!=null){
            sum+=l1.val;
            l1=l1.next;
           }
           if(l2!=null){
            sum+=l2.val;
            l2=l2.next;
           }
           z=sum/10;
           ListNode newnodes=new ListNode(sum%10);
           if(head==null){
            head=newnodes;
            tail=newnodes;
           }
           else{
            tail.next=newnodes;
            tail=newnodes;
           }

           
            }

        
        return head;
        
    }
}