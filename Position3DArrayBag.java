class Position3DArrayBag {
    private Position3D[] data;
    private int manyItems;
    public Position3DArrayBag( ) {
        final int INITIAL_CAPACITY = 2;
        manyItems = 0;
        data = new Position3D[INITIAL_CAPACITY];
    }
    public Position3DArrayBag(Position3DArrayBag other){
        data = new Position3D[other.getCapacity()];
        for(int i=0; i<other.manyItems;i++){
            data[i] = other.data[i].clone();
        }
        manyItems = other.manyItems;
    }
    public void add(Position3D element) {
        if (manyItems == data.length)
            ensureCapacity((manyItems + 1)*2);
        data[manyItems] = element;
        manyItems++;
    }
    public void ensureCapacity(int minimumCapacity) {
        Position3D[ ] biggerArray;
        if (data.length < minimumCapacity)
        {
            biggerArray = new Position3D[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }
    public int getCapacity( ) {
        return data.length;
    }
    public int size(){
        return manyItems;
    }
    public void trimToSize( ) {
        Position3D[ ] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = new Position3D[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }

    public Position3D get(int index){
        return data[index];
    }

    public static Position3DArrayBag union(Position3DArrayBag bag1, Position3DArrayBag bag2){
        Position3DArrayBag unionBag = new Position3DArrayBag();
        unionBag.data = new Position3D[bag1.size() + bag2.size()];
        for(int i=0; i<bag1.size(); i++){
            unionBag.data[i] = bag1.data[i].clone();
        }
        int bag1Size = bag1.size();
        for(int i=0; i<bag2.size(); i++){
            unionBag.data[i + bag1Size ] = bag2.data[i].clone();
        }
        unionBag.manyItems = bag1.size() + bag2.size();
        return unionBag;

    }
}