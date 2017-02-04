package com.company;

public class SplayTree {
    TreeNode root;

    public SplayTree() {

    }

    public void insert(Entry entry) {
        TreeNode newNode = new TreeNode(entry);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode lastNonNullNode = findLastNodeInSearch(entry.getKey());
            if (entry.compareTo(lastNonNullNode.getEntry()) > 0) {
                //New entry is bigger, hence it will be a right child
                lastNonNullNode.setRightChild(newNode);
            } else {
                //Equal or lesser entries go to the left
                lastNonNullNode.setLeftChild(newNode);
            }
            newNode.setParent(lastNonNullNode);
            rebalanceTree(newNode);
        }

    }

    public Entry find(int key) {
        TreeNode lastNodeInSearch = findLastNodeInSearch(key);
        rebalanceTree(lastNodeInSearch);
        Entry closestEntry = lastNodeInSearch.getEntry();

        return closestEntry;
    }

    private void rebalanceTree(TreeNode nodeToSplay) {
        TreeNode parent = nodeToSplay.getParent();
        TreeNode grandParent = null;
        if (parent != null) {
            grandParent = parent.getParent();
        }

        if (grandParent == null) {
            rotateThruParent(nodeToSplay);
        } else {
            splayNodeWithGrandParent(nodeToSplay);
        }

    }

    private void splayNodeWithGrandParent(TreeNode nodeToSplay) {
        TreeNode parent = nodeToSplay.getParent();
        TreeNode grandParent = parent.getParent();

        if (nodeToSplay.findWhichChild().equals(WhichChild.LEFTCHILD) && parent.findWhichChild().equals(WhichChild.LEFTCHILD)
                ||
                nodeToSplay.findWhichChild().equals(WhichChild.RIGHTCHILD) && parent.findWhichChild().equals(WhichChild.RIGHTCHILD)) {
            //Left child of a left child or right child or a right child
            rotateThruParent(parent);
        } else {
            rotateThruParent(nodeToSplay);
        }

        rotateThruParent(nodeToSplay);

        if (nodeToSplay.hasGrandParent()) {
            splayNodeWithGrandParent(nodeToSplay);
        } else if (nodeToSplay.getParent() != null) {
            rotateThruParent(nodeToSplay);
        }
    }

    private TreeNode findLastNodeInSearch(Comparable key) {
        TreeNode node = root;
        TreeNode lastNonNullNode = node;

        while (node != null) {
            if (key.compareTo(lastNonNullNode.getEntry().getKey()) == 0) {
                return lastNonNullNode;
            }

            if (key.compareTo(node.getEntry().getKey()) > 0) {
                //Entry is bigger. Go right to find a match
                node = node.getRightChild();
            } else {
                //we have decided to enter equal keys in the left side
                //hence we go left for less than or equal
                node = node.getLeftChild();
            }

            if (node != null) {
                lastNonNullNode = node;
            }

        }
        return lastNonNullNode;
    }

    public void printSorted() {
        root.inOrder();
    }

//todo move this to the tree node class
    private void rotateThruParent(TreeNode splayNode) {

        //Preserve all references to nodes
        TreeNode parent = splayNode.getParent();
        TreeNode grandParent = parent.getParent();
        WhichChild whichChildIsParent = WhichChild.NOT_A_CHILD;
        if (grandParent != null) {
            whichChildIsParent = parent.findWhichChild();
        }


        //Rotate splayNode thru parent
        if (splayNode.findWhichChild().equals(WhichChild.LEFTCHILD)) {
            TreeNode rightChildOfSplayNode = splayNode.getRightChild();
            parent.setLeftChild(rightChildOfSplayNode);
            if (rightChildOfSplayNode != null) {
                rightChildOfSplayNode.setParent(parent);
            }


            splayNode.setRightChild(parent);
        } else if (splayNode.findWhichChild().equals(WhichChild.RIGHTCHILD)) {
            TreeNode leftChildOfSplayNode = splayNode.getLeftChild();

            parent.setRightChild(leftChildOfSplayNode);
            if (leftChildOfSplayNode != null) {
                leftChildOfSplayNode.setParent(parent);
            }


            splayNode.setLeftChild(parent);
        }

        parent.setParent(splayNode);

        //set references to and from grand parent
        if (grandParent != null) {
            if (whichChildIsParent == WhichChild.LEFTCHILD) {
                grandParent.setLeftChild(splayNode);
            } else if (whichChildIsParent == WhichChild.RIGHTCHILD) {
                grandParent.setRightChild(splayNode);
            }
            splayNode.setParent(grandParent);
        } else {
            splayNode.setParent(null);
            root = splayNode;
        }

    }


}
