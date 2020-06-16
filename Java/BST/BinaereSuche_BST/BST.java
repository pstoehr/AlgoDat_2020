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
        BinaryNode<T> node;
        
        node = root;
        while ((node != null) && (node.getValue() != value)) // Noch kein Java
        {
            if (value < node.getValue())
                node = node.leftTree;
            else 
                node = node.rightTree;
        }
        
        return (node!=null);
    }
}