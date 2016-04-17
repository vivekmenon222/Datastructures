package TwoThreeFourTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 3/23/2016.
 */
public class TreeNode<K extends Comparable, V> {

    TreeNode parent;
    List<Item<K, V>> items;
    List<TreeNode<K,V>> childNodes;

    public TreeNode(TreeNode<K, V> parent, Item<K, V> item) throws Exception {
        this.parent=parent;
        items = new ArrayList<Item<K, V>>();
        childNodes = new ArrayList<TreeNode<K, V>>();
        items.add(item);
    }


    private void inOrder(K key)
    {


    }

    TreeNode<K, V> getLeftChild(int itemPosition )
    {
        if(this.childNodes.size()>0)
        {
            return this.childNodes.get(itemPosition);
        }
        else
        {
            return null;
        }


    }

    void setLeftChild(int itemPosition,Item<K, V> item) throws Exception {

        if(this.getLeftChild(itemPosition)!=null)
        {
          throw new Exception(String.format("%s already has a left child",this.items.get(itemPosition).key));
        }
        else
        {
            this.childNodes.add(itemPosition, new TreeNode<K, V>(this,item));
        }
    }

    void setRightChild(int itemPosition,Item<K, V> item) throws Exception {

        if(this.getRightChild(itemPosition)!=null)
        {
            throw new Exception(String.format("%s already has a right child",this.items.get(itemPosition).key));
        }
        else
        {
            this.childNodes.add(itemPosition +1, new TreeNode<K, V>(this,item));
        }
    }


    TreeNode<K, V> getRightChild(int itemPosition )
    {
        if(this.childNodes.size()>0)
        {
            return this.childNodes.get(itemPosition+1);
        }
        else
        {
            return null;
        }


    }







}
