package zajecia14.generyki;

public class SDALinkedList<T> {

    private SdaLinkedListNode<T> first;

    public T getLast(){
        if (first == null) {
            return null;
        } else {
            SdaLinkedListNode<T> current = first; // current to w zasadzie iterator
            while (current.next != null) {
                current = current.next;
            }
            return current.data;
        }

    }

    //add as first object
    public void add(T toAdd){
        if (first == null) {
            first = new SdaLinkedListNode<>();
            first.data = toAdd;
        } else {
            SdaLinkedListNode<T> newFirst = new SdaLinkedListNode<>();
            newFirst.data = toAdd;
            newFirst.next = first;
            first = newFirst;
        }
    }

    // klasa wewnętrzna
    private class SdaLinkedListNode<T> {
        private T data;
        private SdaLinkedListNode<T> next;
    }

}
