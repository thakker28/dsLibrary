package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeKSortedLinkedList {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
      public int compare(ListNode o1 , ListNode o2)
      {
        return o1.val - o2.val;
      }
    });

    if(lists.length==0){
      return null;
    }
    ListNode head = null;
    ListNode tail = null;
    for(ListNode node : lists){
      if(node!=null)
      {
        minHeap.add(node);
      }
    }

    if(!minHeap.isEmpty())
    {
      head = minHeap.poll();
      tail = head;
      if(head.next!=null){
        minHeap.add(head.next);
      }

    }

    while(minHeap.size()>1){
      ListNode nextNode = minHeap.poll();
      tail.next = nextNode;
      tail = nextNode;
      if(tail.next != null){
        minHeap.add(tail.next);
      }

    }
    while(!minHeap.isEmpty())
    {
      ListNode nextNode = minHeap.poll();
      tail.next = nextNode;
      tail = nextNode;
    }
    return head;
  }
}
