import TwoThreeFourTree.Item;
import TwoThreeFourTree.Tree;

/**
 * Created by Home on 3/24/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Tree<Integer,String> tree=new Tree<Integer, String>();
        tree.insert(new Item<Integer, String>(20,"20"));
        tree.insert(new Item<Integer, String>(40,"40"));
        tree.insert(new Item<Integer, String>(50,"50"));
        tree.insert(new Item<Integer, String>(14,"14"));
        tree.insert(new Item<Integer, String>(32,"32"));
        tree.insert(new Item<Integer, String>(43,"43"));
        tree.insert(new Item<Integer, String>(70,"70"));
        tree.insert(new Item<Integer, String>(79,"79"));
        tree.insert(new Item<Integer, String>(10,"10"));
        tree.insert(new Item<Integer, String>(18,"18"));
        tree.insert(new Item<Integer, String>(25,"25"));
        tree.insert(new Item<Integer, String>(33,"33"));
        tree.insert(new Item<Integer, String>(42,"42"));
        tree.insert(new Item<Integer, String>(47,"47"));
        tree.insert(new Item<Integer, String>(57,"57"));
        tree.insert(new Item<Integer, String>(62,"62"));
        tree.insert(new Item<Integer, String>(66,"66"));
        tree.insert(new Item<Integer, String>(74,"74"));
        tree.insert(new Item<Integer, String>(81,"81"));
        tree.insert(new Item<Integer, String>(60,"60"));

        tree.printSorted();
    }
}
