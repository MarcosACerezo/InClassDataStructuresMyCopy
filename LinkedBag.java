public class LinkedBag<E> implements Cloneable {
    private Node<E> head;
    private int manyNodes;

    public LinkedBag(){
        head = null;
        manyNodes = 0;
    }

    public void add(E element) {
        head = new Node<E>(element, head);
        manyNodes++;
    }

    
    public int countOccurrences(E target) {
        int answer = 0;
        Node<E> cursor = Node.listSearch(head, target);

        while (cursor != null) {
            answer++;
            // Move the cursor to the next occurrence of the target
            cursor = cursor.getLink();
            cursor = Node.listSearch(cursor, target);
        }

        return answer;
    }

    public Node<E> getHead(){
        return head;
    }

    
    public boolean remove(E target) {
        Node<E> targetNode = Node.listSearch(head, target);

        if (targetNode == null)
            return false;
        else {
            targetNode.setData(head.getData());
            head = head.getLink();
            manyNodes--;
            return true;
        }
    }

    public int size() {
        return manyNodes;
    }
    
    //the run time would be O(n) worst case because of the listPosition method
    
    public E grab(){
        if(manyNodes == 0){
            throw new IllegalStateException("There are no elements in the bag");
        }
        Node<E> rand = Node.listPosition(head, (int)(manyNodes * Math.random() + 1));//select node
        return rand.getData();//return data from node
    }

    //O(n) runtime
    @SuppressWarnings("unchecked")
    public static <E extends Cloneable> LinkedBag<E> union(LinkedBag<E> bag1, LinkedBag<E> bag2) {
        LinkedBag<E> result = new LinkedBag<E>();
        Node<E> cursor;
        try{
            for(cursor=bag1.head; cursor != null; cursor = cursor.getLink()){
            result.add((E)cursor.getData().getClass().getMethod("clone").invoke(cursor.getData()));
            }
            cursor = bag2.head;
            for(cursor=bag2.head; cursor != null; cursor = cursor.getLink()){
                result.add((E)cursor.getData().getClass().getMethod("clone").invoke(cursor.getData()));
            }
            result.manyNodes = bag1.manyNodes + bag2.manyNodes;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


}