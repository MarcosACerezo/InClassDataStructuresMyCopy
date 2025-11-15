// Stacks – Project : Linked Stack
public class Mod05LinkedStack {
    public static void main(String[] args) {

        String s = "racecar";
        LinkedStack<Character> myStack = new LinkedStack<Character>();

        System.out.println(s);

        for (int i = 0; i < s.length(); i++)
            myStack.push(s.charAt(i));

        myStack.display();

        StringBuilder myWord = new StringBuilder();
        while (!myStack.isEmpty())
            myWord.append(myStack.pop());

        System.out.println(myWord);
        myStack.display();

        if (s.equals(myWord.toString()))
            System.out.println("Hooray! The word is a palindrome");

        LinkedStack<Character> myStack2 = new LinkedStack<>();
        String rev = "apple";
        for (int i = 0; i < rev.length(); i++)
            myStack2.push(rev.charAt(i));
        LinkedStack<Character> reversedStack = myStack2.flip();
        
        System.out.println("Mystack2 display");
        myStack2.display();
        System.out.println("Reversed display");
        reversedStack.display();

        System.out.printf(
            "Do these two stacks contain the same characters in the same order?: %b\n", 
            LinkedStack.equals(reversedStack, myStack2));
        LinkedStack<Character> revrevStack = reversedStack.flip();
        System.out.printf(
            "Do these two stacks contain the same characters in the same order?: %b\n", 
            LinkedStack.equals(myStack2, revrevStack));

    }
}
