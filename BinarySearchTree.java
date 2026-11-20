import java.util.*;

/**
 * This BinarySearchTree object defines a reference based binary search tree
 * 
 * @author  
 * @version 
 */

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{
    protected BinaryNode<T> root;      

    public BinarySearchTree()
    {
        root = new BinaryNode<>(null);
    }

    public boolean isEmpty()
    {
        return root.getInfo() == null;
    }

    public int size()
    {
        int count = 1;
        if(root.getLeft() != null) {
            count += sizeHelper(root.getLeft());
        }
        if(root.getRight() != null) {
            count += sizeHelper(root.getRight());
        }
        return count;
    }

    private int sizeHelper(BinaryNode<T> node) {
        int count = 1;
        if(node.getLeft() != null) {
            count += sizeHelper(node.getLeft());
        }
        if(node.getRight() != null) {
            count += sizeHelper(node.getRight());
        }
        return count;
    }

    public void add (T element)
    {
        BinaryNode<T> currentNode = root;
        boolean notAdded = true;
        if(root.getInfo() == null) {
            root.setInfo(element);
            notAdded = false;
        }
        while(notAdded) {
            if(element.compareTo(currentNode.getInfo()) <= 0) {
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(new BinaryNode<T>(element));
                    notAdded = false;
                }
                else {
                    currentNode = currentNode.getLeft();
                }
            }
            else {
                if(currentNode.getRight() == null) {
                    currentNode.setRight(new BinaryNode<T>(element));
                    notAdded = false;
                }
                else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }
    public boolean contains (T element)
    {
        if(root.getInfo() == null) {
            return false;
        }
        return containsHelper(element, root);
    }

    private boolean containsHelper(T element, BinaryNode<T> node) {
        if(element.compareTo(node.getInfo()) == 0) {
            return true;
        }
        else if(element.compareTo(node.getInfo()) < 0) {
            if(node.getLeft() == null) {
                return false;
            }
            else {
                return containsHelper(element, node.getLeft());
            }
        }
        else {
            if(node.getRight() == null) {
                return false;
            }
            else {
                return containsHelper(element, node.getRight());
            }
        }
    }

    public String toString()
    {
        return toString(root, 0);
    }

    private String toString(BinaryNode<T> tree, int level)
    {
        String str = "";
        if (tree != null)
        {
            str += toString(tree.getRight(), level + 1);
            for (int i = 1; i <= level; ++i)
                str = str + "| ";
            str += tree.getInfo().toString() + "\n";
            str += toString(tree.getLeft(), level + 1);
        }
        return str;
    }

    public List<T> preorderTraverse()
    {
        List<T> list = new ArrayList<>();
        preorderHelper(root, list);
        return list;
    }
    private void preorderHelper(BinaryNode<T> node, List<T> list) {
        list.add(node.getInfo());
        if(node.getLeft() != null) {
            preorderHelper(node.getLeft(), list);
        }
        if(node.getRight() != null) {
            preorderHelper(node.getRight(), list);
        }
    }

    public List<T> inorderTraverse()
    {
        List<T> list = new ArrayList<>();
        inorderHelper(root, list);
        return list;
    }
    private void inorderHelper(BinaryNode<T> node, List<T> list) {
        if(node.getLeft() != null) {
            inorderHelper(node.getLeft(), list);
        }
        list.add(node.getInfo());
        if(node.getRight() != null) {
            inorderHelper(node.getRight(), list);
        }
    }

    public List<T> postorderTraverse()
    {
        List<T> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }
    private void postorderHelper(BinaryNode<T> node, List<T> list) {
        if(node.getLeft() != null) {
            postorderHelper(node.getLeft(), list);
        }
        if(node.getRight() != null) {
            postorderHelper(node.getRight(), list);
        }
        list.add(node.getInfo());
    }

    public void remove (T element)
    {

    }

    public void balance()
    {
        int sizeLeft = 0;
        int sizeRight = 0;
        BinaryNode<T> node = root;
        if(node.getLeft() != null)
        {
            sizeLeft++;
            node = node.getLeft();
        }
    }
}
