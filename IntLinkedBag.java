public class IntLinkedBag implements Cloneable {
    private IntNode head;
    private int manyNodes;

    public IntLinkedBag() {
        head = null;
        manyNodes = 0;
    }

    public void add(int element) {
        head = new IntNode(element, head);
        manyNodes++;
    }

    public int countOccurrences(int target) {
        int answer = 0;
        IntNode cursor = IntNode.listSearch(head, target);

        while (cursor != null) {
            answer++;
            // Move the cursor to the next occurrence of the target
            cursor = cursor.getLink();
            cursor = IntNode.listSearch(cursor, target);
        }

        return answer;
    }

    public boolean remove(int target) {
        IntNode targetNode = IntNode.listSearch(head, target);

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
    public int grab(){
        IntNode randInt = IntNode.listPosition(head, (int)(manyNodes * Math.random() + 1));
        return randInt.getData();

        //Intnode cursor;
        //int i = (int)(manyNodes * Math.random())+1;
        //cursor = IntNode.listPosition(head, i);
        //return cursor.getData();
    }
}