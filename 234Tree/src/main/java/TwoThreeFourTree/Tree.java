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

    public void printSorted()
    {
        int inOrderTravItemIndex=0;
        head.inorder(inOrderTravItemIndex);
    }

    //Recursive calls to this method until you reach a leaf node
    //Inserts always happen in a leaf node
    private void insert(TreeNode<K, V> node, Item<K, V> item) throws Exception {
        if (node.childNodes.size() == 0 && node.items.size() < 3) {
           for(Item<K, V> kvItem : node.items)
           {
               if(kvItem.key.compareTo(item.key)==0)
               {
                   System.out.println("Key " +item.key+" already exists. Duplicate keys are ignored");
                   return;
               }
           }
            insertIntoLeaf(item, node);
            return;
        }
        node = checkForThreeKeyNode(node);
        for (int i = 0; i < node.items.size(); i++) {
            K currentNodeKey = node.items.get(i).key;
            K insertItemKey = item.key;

            if (currentNodeKey.compareTo(insertItemKey) == 0) {
                return;//don't insert duplicates
            } else if (currentNodeKey.compareTo(insertItemKey) > 0) {
                //new item is less than current node. Go left
                TreeNode<K, V> leftChild = node.getLeftChildNodeForItem(i);
                if (leftChild == null) {
                    node.setLeftChildNodeForItem(i, item);
                    return;
                }
                insert(node.getLeftChildNodeForItem(i), item);
                return;
            } else if (currentNodeKey.compareTo(insertItemKey) < 0 && i == node.items.size() - 1) {
                //new item is greater than current node. Go right
                TreeNode<K, V> rightChild = node.getRightChildNodeForItem(i);
                if (rightChild == null) {
                    node.setRightChildNodeForItem(i, item);
                    return;
                }
                insert(node.getRightChildNodeForItem(i), item);
                return;
            }

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

    public Item<K, V> find(K key) {
        Item<K, V> item = findItemByKey(key, head);

        return item;
    }

    private Item<K, V> findItemByKey(K key, TreeNode<K, V> node) {

        int itemNum = -1;
        int totalItems = node.items.size();
        for (Item<K, V> item : node.items) {
            itemNum++;
            if (item.key.equals(key)) {
                return item;
            } else if (item.key.compareTo(key) > 0) {
                if (node.childNodes != null) {
                    return findItemByKey(key, node.childNodes.get(itemNum));
                } else {
                    return null;
                }

            } else if (item.key.compareTo(key) < 0 && itemNum == totalItems) {
                if (node.childNodes != null) {
                    return findItemByKey(key, node.childNodes.get(itemNum + 1));
                } else {
                    return null;
                }

            }

        }

        return null;
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
        resetChildrenOfSplitNode(leftNode,rightNode,nodeToSplit);
        parentNode.childNodes.remove(childIndex);
        setLeftChildParent(leftNode, parentNode, childIndex);
        setRightChildParent(rightNode, parentNode, childIndex + 1);

        return parentNode;
    }

    private void resetChildrenOfSplitNode(TreeNode<K, V> leftNode,TreeNode<K, V> rightNode,TreeNode<K, V> nodeBeingSplit) throws Exception {

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




}
