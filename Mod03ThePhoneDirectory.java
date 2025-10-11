public class Mod03ThePhoneDirectory{
    public static void main(String[] args){
        Table directory = new Table(7);
        directory.put("Hope", 2110);
        directory.put("Sophia", 4626);
        directory.put("Claire", 2433);
        directory.put("Freidrich", 3545);
        directory.put("Leonardo", 1100);
        directory.put("Layla", 3363);
        directory.put("Astrid", 8927);
        // directory.put("Haruto", 8888);


        System.out.printf("Size before removal: %s", directory.size());
        System.out.println(directory);
        //Cannot search for the extension because the table is not designed in that manner
        directory.remove("Claire");
        System.out.printf("Size after removal: %s", directory.size());
        
        System.out.println(directory);
        //best case
        //worst case
    }
}


