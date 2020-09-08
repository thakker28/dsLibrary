package leetcode;

public class QueueUsingLL<T> {
    Node<T> head;
    Node<T> tail;
    int size =  0;

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        if(size==0)
        {
            return true;
        }
        return false;
    }

    public void enqueue(T element)
    {
        Node<T> temp = new Node<T>(element);
        if(head==null)
        {
            head = tail = temp;
        }
        else
        {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public T dequeue()
    {
        if(head==null)
        {
            return null;
        }
        T temp = head.data;
        head = head.next;
        if(head==null)
        {
            tail = null;
        }
        size --;
        return temp;
    }
}
