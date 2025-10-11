class ArrayBag<E>{
    private Object[] data;
    private int manyItems;

    public ArrayBag( ){
        final int INITIAL_CAPACITY = 2;
        manyItems = 0;
        data = new Object[INITIAL_CAPACITY];
    }

    public ArrayBag(ArrayBag<E> other) {
        this.manyItems = other.manyItems;
        this.data = new Object[other.data.length];
        try{
            for (int i = 0; i < other.manyItems; i++){
                data[i] = other.data[i].getClass().getMethod("clone").invoke(other.data[i]);
            }
        }catch(Exception e){

        }
        
    }

    public void add(E element) {
        if (manyItems == data.length) {
            ensureCapacity((manyItems + 1)*2);
        }
        data[manyItems] = element;
        manyItems++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        if(index >= manyItems){
            throw new ArrayIndexOutOfBoundsException("Out of bounds");
        }
        return (E) data[index];
    }


    public void ensureCapacity(int minimumCapacity) {
        Object[ ] biggerArray;
        if (data.length < minimumCapacity) {
            biggerArray = new Object[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, manyItems);
            data = biggerArray;
        }
    }
    public int getCapacity( ) {
        return data.length;
    }
    public int size( ) {
        return manyItems;
    }
    public void trimToSize( ) {
        Object[ ] trimmedArray;
        if (data.length != manyItems) {
            trimmedArray = new Object[manyItems];
            System.arraycopy(data, 0, trimmedArray, 0, manyItems);
            data = trimmedArray;
        }
    }
    @SuppressWarnings("unchecked")
    public static <E> ArrayBag<E> union(ArrayBag<E> bag1, ArrayBag<E> bag2) {
        ArrayBag<E> result = new ArrayBag<>();
        result.ensureCapacity(bag1.manyItems + bag2.manyItems);
        try{
            for (int i = 0; i < bag1.manyItems; i++){
                result.add((E) bag1.data[i].getClass().getMethod("clone").invoke(bag1.data[i]));
            }
            for (int i = 0; i < bag2.manyItems; i++){
                result.add((E) bag2.data[i].getClass().getMethod("clone").invoke(bag2.data[i]));
            }
        }
        catch (Exception e){
            throw new AssertionError("Cloning not supported", e);
        }
        return result;
    }
}
