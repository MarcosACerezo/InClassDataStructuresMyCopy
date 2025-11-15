public class PositionList implements Cloneable{
    private Position[] list;
    int size;
    int items;

    public PositionList(int s){
        list = new Position[s];
        size = s;
        items = 0;
    }

    @Override
    public PositionList clone(){
        PositionList clone = new PositionList(size);
        for(int i=0; i<items; i++){
            clone.list[i] = list[i].clone();
        }
        clone.items = items;
        return clone;
    }

    public void add(Position element){
        list[items] = element;
        items++;
    }

    public Position pop(){
        Position item = list[items - 1];
        list[items - 1] = null;
        
        items--;
        return item;
    }

    public Position get(int index){
        if(list[index] == null){
            throw new NullPointerException("There is no element in this node");
        }
        return list[index];
    }

    //The runtime of the clone method is O(n) because we have to use a loop to copy through each element one by one
    public static void main(String[] args){
        PositionList list = new PositionList(6);
        for(int i=0; i< 6;i++){
            list.add(new Position(i, i));
        }
        PositionList cloneList = list.clone();
        System.out.println(cloneList.get(5));

        for(int i=0; i< 6;i++){
            try{
                System.out.printf("These two elements are the same: %b\n", cloneList.get(i).equals(list.get(i)));
            }catch(NullPointerException e ){
                System.out.println("One of these values is null");
            }
            
            System.out.printf("These two elements share the same address: %b\n", cloneList.get(i) == list.get(i));
        }

        list.pop();
        cloneList.pop();

        System.out.println("\n\n\n\n");
        for(int i=0; i< 6;i++){
            try{
                System.out.printf("These two elements are the same: %b\n", cloneList.get(i).equals(list.get(i)));
            }catch(NullPointerException e ){
                System.out.println("One of these values is null");
            }
            
            System.out.printf("These two elements share the same address: %b\n", cloneList.get(i) == list.get(i));
        }
    }

}
