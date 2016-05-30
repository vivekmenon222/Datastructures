package TwoThreeFourTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 3/23/2016.
 */
public class TreeNode<K extends Comparable, V> {

   TreeNode parent;
   List<Item<K, V>> items;
   List<TreeNode<K, V>> childNodes;

   public TreeNode(TreeNode<K, V> parent, Item<K, V> item) throws Exception {
      this.parent = parent;
      items = new ArrayList<Item<K, V>>();
      childNodes = new ArrayList<TreeNode<K, V>>();
      items.add(item);
   }

   private void visit(int itemIndex) {
      System.out.println(String.format("key:%s value:%s", this.items.get(itemIndex).key.toString(), this.items.get(itemIndex).value.toString()));
   }

   public void inorder(int itemIndex) {

      if (itemIndex == 0 && getLeftChildNodeForItem(itemIndex) != null) {
         TreeNode<K, V> leftChild = getLeftChildNodeForItem(itemIndex);
         leftChild.inorder(0);
      }
      this.visit(itemIndex);
      if (getRightChildNodeForItem(itemIndex) != null) {
         TreeNode<K, V> rightChild = getRightChildNodeForItem(itemIndex);
         rightChild.inorder(0);
      }

      if (getNextSibling(itemIndex) != null) {
         itemIndex++;
         inorder(itemIndex);
      }
   }

   TreeNode<K, V> getLeftChildNodeForItem(int itemIndex) {
      if (this.childNodes.size() > 0) {
         return this.childNodes.get(itemIndex);
      } else {
         return null;
      }
   }

/*   TreeNode<K, V> setLeftChildNodeForItem(int itemPosition, Item<K, V> item) throws Exception {

      if (this.getLeftChildNodeForItem(itemPosition) != null) {
         throw new Exception(String.format("%s already has a left child", this.items.get(itemPosition).key));
      } else {
         TreeNode<K, V> newLeftChild = new TreeNode<K, V>(this, item);
         this.childNodes.add(itemPosition, newLeftChild);
         return newLeftChild;
      }
   }

   TreeNode<K, V> setRightChildNodeForItem(int itemPosition, Item<K, V> item) throws Exception {

      if (this.getRightChildNodeForItem(itemPosition) != null) {
         throw new Exception(String.format("%s already has a right child", this.items.get(itemPosition).key));
      } else {
         TreeNode<K, V> newRightChild = new TreeNode<K, V>(this, item);
         this.childNodes.add(itemPosition + 1, newRightChild);
         return newRightChild;
      }
   }*/

   TreeNode<K, V> getRightChildNodeForItem(int itemPosition) {
      if (this.childNodes.size() > 0) {
         return this.childNodes.get(itemPosition + 1);
      } else {
         return null;
      }
   }

   Item<K, V> getNextSibling(int itemIndex) {

      if (this.items.size() > (itemIndex + 1)) {

         return this.items.get(itemIndex + 1);
      } else {
         return null;
      }
   }

   TreeNode<K, V> getLeftAdjacentNode() {

      TreeNode<K, V> leftAdjacentNode = null;
      int currentNodeChildIndex= this.parent.childNodes.indexOf(this);
      if(currentNodeChildIndex>0)
      {
         leftAdjacentNode=(TreeNode<K, V>)this.parent.childNodes.get(currentNodeChildIndex-1);
      }
      else
      {
         leftAdjacentNode=null;
      }

      return leftAdjacentNode;
   }


   TreeNode<K, V> getRightAdjacentNode() {

      TreeNode<K, V> rightAdjacentNode = null;
      int currentNodeChildIndex= this.parent.childNodes.indexOf(this);
      if((this.parent.childNodes.size()-1) >currentNodeChildIndex)
      {
         rightAdjacentNode=(TreeNode<K, V>)this.parent.childNodes.get(currentNodeChildIndex+1);
      }
      else
      {
         rightAdjacentNode=null;
      }

      return rightAdjacentNode;
   }

}
