public class BST<T extends Comparable<? super T>> {
    private BinaryNode<T> root;
    
    BST()
    {
        root = null;
    }
    
    BST(T value)
    {
        root = new BinaryNode<T>(value);
    }
    
    public String toString()
    {
        return root.toString();
    }
    
    public void insert(T value)
    {
    }

    public Boolean find(T value)
    {
        return false;
    }
}