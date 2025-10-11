public class Position3DLinkedBag implements Cloneable {
    private Position3DNode head;
    private int manyNodes;

    public Position3DLinkedBag() {
        head = null;
        manyNodes = 0;
    }

    public void add(Position3D element) {
        head = new Position3DNode(element, head);
        manyNodes++;
    }

    public int countOccurrences(Position3D target) {
        int answer = 0;
        Position3DNode cursor = Position3DNode.listSearch(head, target);

        while (cursor != null) {
            answer++;
            // Move the cursor to the next occurrence of the target
            cursor = cursor.getLink();
            cursor = Position3DNode.listSearch(cursor, target);
        }

        return answer;
    }

    public boolean remove(Position3D target) {
        Position3DNode targetNode = Position3DNode.listSearch(head, target);

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
    public Position3D grab(){
        Position3DNode randPosition3D = Position3DNode.listPosition(head, (int)(manyNodes * Math.random() + 1));
        return randPosition3D.getData();
    }
}
