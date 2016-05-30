package TwoThreeFourTree;

import java.util.Collections;

/**
 * Created by Home on 3/24/2016.
 */
public class Tree<K extends Comparable, V> {

   TreeNode<K, V> head;

   public void insert(Item<K, V> item) throws Exception {

      if (head == null) {
         head = new TreeNode<K, V>(null, item);
      } else {
         insert(head, item);
      }
   }

   public void remove(K key) throws Exception {

      remove(head, key);
   }

   public void printSorted() {
      int inOrderTravItemIndex = 0;
      head.inorder(inOrderTravItemIndex);
   }

   //Recursive calls to this method until you reach a leaf node
   //Inserts always happen in a leaf node
   private void insert(TreeNode<K, V> node, Item<K, V> item) throws Exception {
      if (node.childNodes.size() == 0 && node.items.size() < 3) {
         //we have reached a leaf now
         if (findKeyInNode(node, item.key) != null) {
            System.out.println("Key " + item.key + " already exists. Duplicate keys are ignored");
            return;
         }
         insertIntoLeaf(item, node);
         return;
      }
      node = checkForThreeKeyNode(node);

      TreeNode<K, V> nextNode = getNextNodeInSearch(node, item.key);

      if (nextNode == node) {
         System.out.println("Key " + item.key + " already exists. Duplicate keys are ignored");
         return;//don't insert duplicates
      }
   /*   else if (nextNode.items.size() == 0) {
         nextNode.items.add(item);
         return;
      } */
      else {
         insert(nextNode, item);
      }
   }

   private void remove(TreeNode<K, V> node, K key) throws Exception {

      if (node != head) {
         checkForOneKeyNode(node);
      }

      Item<K, V> foundItem = findKeyInNode(node, key);
      if (foundItem != null) {
         //Item to be removed found
         int foundItemIndex = head.items.indexOf(foundItem);
         TreeNode<K, V> leftMostNode = findLeftMostNodeForRemoveOperation(head.getRightChildNodeForItem(foundItemIndex));
      } else {
         //Do a recursive search for the item
         TreeNode<K, V> nextNodeInSearch = getNextNodeInSearch(node, key);
         remove(nextNodeInSearch, key);
      }
   }

   private void checkForOneKeyNode(TreeNode<K, V> node) throws Exception {
      TreeNode<K, V> leftSiblingNode = node.getLeftAdjacentNode();
      TreeNode<K, V> rightSiblingNode = node.getRightAdjacentNode();
      if (leftSiblingNode!=null && leftSiblingNode.items.size() > 1) {
          //steal from left sibling via rotation
      } else if (rightSiblingNode!=null && rightSiblingNode.items.size() > 1) {
         //steal from right sibling via rotation
      } else if (node.parent.items.size() > 1) {
         //steal from parent
      }
      else if(node.parent==head)
      {
         //fuse with parent ie head
      }
      else
      {
         throw new Exception("Unknown checkForOneKeyNode condition");
      }
   }

   private TreeNode<K, V> findLeftMostNodeForRemoveOperation(TreeNode<K, V> node) {
      TreeNode<K, V> leftNode = node.getLeftChildNodeForItem(0);
      if (leftNode != null) {
         return findLeftMostNodeForRemoveOperation(leftNode);
      } else {
         return node;
      }
   }

   private void insertIntoLeaf(Item<K, V> item, TreeNode<K, V> leafNode) {
      leafNode.items.add(item);
      Collections.sort(leafNode.items);
   }

   private TreeNode<K, V> checkForThreeKeyNode(TreeNode<K, V> node) throws Exception {
      TreeNode<K, V> returnNode = node;
      if (node.items.size() == 3) {
         if (node == head) {
            returnNode = splitThreeKeyHeadNode();
         } else {
            returnNode = kickMiddleItemUpStairs(node);
         }
      }
      return returnNode;
   }

   private int getChildNodeIndexNum(TreeNode<K, V> childNode) {
      int index = -1;
      TreeNode<K, V> parentNode = childNode.parent;
      for (TreeNode<K, V> node : parentNode.childNodes) {
         index++;
         if (node.equals(childNode)) {
            return index;
         }
      }
      return -1;
   }

   private TreeNode<K, V> splitThreeKeyHeadNode() throws Exception {
      if (head.items.size() == 3) {

         TreeNode<K, V> newParent = new TreeNode<K, V>(null, head.items.get(1));
         TreeNode<K, V> leftNode = new TreeNode<K, V>(null, head.items.get(0));
         TreeNode<K, V> rightNode = new TreeNode<K, V>(null, head.items.get(2));

         setLeftChildParent(leftNode, newParent, 0);
         setRightChildParent(rightNode, newParent, 1);

         resetChildrenOfSplitNode(leftNode, rightNode, head);
         head = newParent;
         return head;
      } else {
         throw new Exception("Invalid attempt to split head node");
      }
   }

   private TreeNode<K, V> kickMiddleItemUpStairs(TreeNode<K, V> nodeToSplit) throws Exception {

      TreeNode<K, V> parentNode = nodeToSplit.parent;

      Item<K, V> middleItem = nodeToSplit.items.get(1);
      int childIndex = getChildNodeIndexNum(nodeToSplit);
      parentNode.items.add(childIndex, middleItem);
      TreeNode<K, V> leftNode = new TreeNode<K, V>(null, nodeToSplit.items.get(0));
      TreeNode<K, V> rightNode = new TreeNode<K, V>(null, nodeToSplit.items.get(2));
      resetChildrenOfSplitNode(leftNode, rightNode, nodeToSplit);
      parentNode.childNodes.remove(childIndex);
      setLeftChildParent(leftNode, parentNode, childIndex);
      setRightChildParent(rightNode, parentNode, childIndex + 1);

      return parentNode;
   }

   private void resetChildrenOfSplitNode(TreeNode<K, V> leftNode, TreeNode<K, V> rightNode, TreeNode<K, V> nodeBeingSplit) throws Exception {

      if (nodeBeingSplit.childNodes.size() > 0) {
         leftNode.childNodes.add(0, nodeBeingSplit.childNodes.get(0));
         nodeBeingSplit.childNodes.get(0).parent = leftNode;
         leftNode.childNodes.add(1, nodeBeingSplit.childNodes.get(1));
         nodeBeingSplit.childNodes.get(1).parent = leftNode;

         rightNode.childNodes.add(0, nodeBeingSplit.childNodes.get(2));
         nodeBeingSplit.childNodes.get(2).parent = rightNode;
         rightNode.childNodes.add(1, nodeBeingSplit.childNodes.get(3));
         nodeBeingSplit.childNodes.get(3).parent = rightNode;
      }
   }

   //Set left child's parent after node split
   private void setLeftChildParent(TreeNode<K, V> leftChild, TreeNode<K, V> parent, int childIndexBeingAdded) {
      leftChild.parent = parent;

      parent.childNodes.add(childIndexBeingAdded, leftChild);
   }

   //Set right child's parent after node split
   private void setRightChildParent(TreeNode<K, V> rightChild, TreeNode<K, V> parent, int childIndexBeingAdded) {
      rightChild.parent = parent;
      parent.childNodes.add(childIndexBeingAdded, rightChild);
   }

   public Item<K, V> search(K key) {
      TreeNode<K, V> node = head;

      while (true) {
         int itemNum = 0;
         for (Item<K, V> item : node.items) {
            itemNum++;

            if (key.compareTo(item.key) < 0) {
               node = getLeftChildItem(item);
               break;
            } else if (itemNum == 3) {
               node = getRightChildFromItem(item);
               break;
            }
         }
      }
   }

   private TreeNode<K, V> getLeftChildItem(Item<K, V> item) {
      return null;
   }

   private TreeNode<K, V> getRightChildFromItem(Item<K, V> item) {
      return null;
   }

   private Item<K, V> findKeyInNode(TreeNode<K, V> node, K key) {
      for (Item<K, V> item : node.items) {
         if (item.key.compareTo(key) == 0) {
            return item;
         }
      }
      return null;
   }

   private TreeNode<K, V> getNextNodeInSearch(TreeNode<K, V> currentNode, K key) throws Exception {
      //you compare the key to each item until you reach an item that is greater than the key, then you go left.
      //If you are at the last item and the key is still greater, then go right.
      int itemIdex = 0;
      for (Item<K, V> item : currentNode.items) {
         K currentItemKey = item.key;
         if (currentItemKey.compareTo(key) == 0) {
            return currentNode;
         } else if (currentItemKey.compareTo(key) > 0) {
            //current item is greater than the key, go left
            TreeNode<K, V> leftNode = currentNode.getLeftChildNodeForItem(itemIdex);
         /*   if (leftNode == null) {
               leftNode = currentNode.setLeftChildNodeForItem(itemIdex, null);
            }*/
            return leftNode;
         } else if (itemIdex == (currentNode.items.size() - 1) && currentItemKey.compareTo(key) < 0) {
            //you are at the last item in the list and the current item is less than the key. Go right
            TreeNode<K, V> rightNode = currentNode.getRightChildNodeForItem(itemIdex);
           /* if (rightNode == null) {
               rightNode = currentNode.setRightChildNodeForItem(itemIdex, null);
            }*/
            return rightNode;
         }
         itemIdex++;
      }
      return null;
   }
}
