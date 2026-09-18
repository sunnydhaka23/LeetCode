class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;

        for(int step=1;step<lists.length;step*=2){
            for(int i=0;i+step<lists.length;i+=step*2)
                lists[i]=merge(lists[i],lists[i+step]);
        }
        return lists[0];
    }

    ListNode merge(ListNode a,ListNode b) {
        ListNode dummy=new ListNode(0),cur=dummy;
        while(a!=null&&b!=null){
            if(a.val<b.val){
                cur.next=a;
                a=a.next;
            }else{
                cur.next=b;
                b=b.next;
            }
            cur=cur.next;
        }
        cur.next=a!=null?a:b;
        return dummy.next;
    }
}