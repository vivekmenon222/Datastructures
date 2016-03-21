import java.io.UnsupportedEncodingException;

/**
 * Created by Home on 3/4/2016.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {

      Node n=new Node();
        Node n2=new Node();
       System.out.println(n);
        System.out.println(n2);
     /*   Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();

        n1.item = "1";
        n2.item = "2";
        n3.item = "3";
        n4.item = "4";*/

        // n2.prevNextXor = n1.toString()^n2.toString();

    }

    private static String stringToBinary(String s) throws UnsupportedEncodingException {
        byte[] bytes = s.getBytes( "UTF-8" );
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(Integer.toString(b, 2));
        }

        return sb.toString();
    }

    private static void printBinary(int i) {
        Integer.toString(i, 2);
    }
}
