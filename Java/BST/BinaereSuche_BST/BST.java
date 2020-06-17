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
    
    // #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####
    
    public void insertRec(T value)
    {
        root = _insertRec(root, value);
    }

    private BinaryNode<T> _insertRec(BinaryNode<T> currentNode, T value)
    {
        // Auf Blattebene angekommen --> Knoten erzeugen
        if (currentNode == null) return new BinaryNode<T>(value);
        
        if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _insertRec(currentNode.leftChild, value);
        else 
            currentNode.rightChild = _insertRec(currentNode.rightChild, value);
        
        return currentNode;
    }

    // #####     #####     #####     #####     #####     #####     #####

    public void insert(T value)
    {
        BinaryNode<T> newNode = new BinaryNode<T>(value);
        BinaryNode<T> currentNode = root;
        
        if (root == null)
        {
            root = newNode;
            return;
        }
        
        BinaryNode<T> parent = null;
        // Blattposition suchen
        while(currentNode != null)
        {
            parent = currentNode;
            if (value.compareTo(currentNode.getValue()) < 0) // >
                currentNode = currentNode.leftChild;
            else 
                currentNode = currentNode.rightChild;
        }
        
        // Knoten einfuegen
        if (value.compareTo(parent.getValue()) < 0) // >
            parent.leftChild = newNode;
        else
            parent.rightChild = newNode;
    }

    // #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####    

    public void delete(T value)
    {
        root = _delete(root, value);
    }
    
    private BinaryNode<T> _delete(BinaryNode<T> currentNode, T value)
    {
        if (currentNode == null) return null;

        if (value.compareTo(currentNode.getValue()) == 0)
        {
            // Kein Kind
            if ((currentNode.leftChild == null) && (currentNode.rightChild == null)) return null;
            // Ein Kind
            if (currentNode.leftChild == null) return currentNode.rightChild;
            if (currentNode.rightChild == null) return currentNode.leftChild;
            // Zwei Kinder
            T replacement = getMinValueOf(currentNode.rightChild);
            currentNode.setValue(replacement);
            currentNode.rightChild = _delete(currentNode.rightChild, replacement);
        }
        else if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _delete(currentNode.leftChild, value);
        else
            currentNode.rightChild = _delete(currentNode.rightChild, value);
               
        return currentNode;
    }

    private T getMinValueOf(BinaryNode<T> forNode)
    {
        return null;
    }

    // #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####    

    
    public Boolean find(T value)
    {
        BinaryNode<T> node;
        
        node = root;
        while ((node != null) && (value.compareTo(node.getValue()) == 0))
        {
            if (value.compareTo(node.getValue()) < 0)
                node = node.leftChild;
            else 
                node = node.rightChild;
        }
        
        return (node!=null);
    }
}