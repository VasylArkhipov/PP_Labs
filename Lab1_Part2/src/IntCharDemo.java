public class IntCharDemo {
    public static void main(String[] args) {
        IntChar someIntChar = new IntChar();
        System.out.println("Int - " + someIntChar.someInt +"\nChar - " + someIntChar.someChar);
    }
}
class IntChar{
    int someInt;
    char someChar;
}