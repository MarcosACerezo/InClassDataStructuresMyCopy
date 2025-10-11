class IntArrayBag {
    private int[ ] data;
    private int manyItems;
    public IntArrayBag( ) {
        final int INITIAL_CAPACITY = 2;
        manyItems = 0;
        data = new int[INITIAL_CAPACITY];
    }
    public void add(int element) {
        if (manyItems == data.length)
            ensureCapacity((manyItems + 1)*2);
        data[manyItems] = element;
        manyItems++;
    }
    public void ensureCapacity(int minimumCapacity) {
        int[ ] biggerArray;
        if (data.length < minimumCapacity)
        {
            biggerArray = new int[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }
    public int getCapacity( ) {
        return data.length;
    }
    public void trimToSize( ) {
        int[ ] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = new int[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }
}