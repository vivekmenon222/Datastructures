import TwoThreeFourTree.Item;
import TwoThreeFourTree.Tree;

/**
 * Created by Home on 3/24/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Tree<Integer,String> tree=new Tree<Integer, String>();
        tree.insert(new Item<Integer, String>(40,"forty"));
        tree.insert(new Item<Integer, String>(20,"twenty"));
        tree.insert(new Item<Integer, String>(50,"fifty"));
        tree.insert(new Item<Integer, String>(14,"fourteen"));
        tree.insert(new Item<Integer, String>(32,"thirty two"));
        tree.insert(new Item<Integer, String>(43,"forty three"));
        tree.insert(new Item<Integer, String>(9,"nine"));
    }
}
