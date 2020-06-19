public class AVLTree<T extends Comparable<? super T>> {
    
    private AVLNode<T> root;
    
    AVLTree()
    {
        root = null;
    }
    
    AVLTree(T value)
    {
        root = new AVLNode<T>(value);
    }
    
    public String toString()
    {
        return root.toString();
    }
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####
    
    public void insertRec(T value)
    {
        root = _insertRec(root, value);
    }
    
    private AVLNode<T> _insertRec(AVLNode<T> currentNode, T value)
    {
        if (currentNode == null) return new AVLNode<T>(value);
        
        if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _insertRec(currentNode.leftChild, value);
        else
            currentNode.rightChild = _insertRec(currentNode.rightChild, value);
        
        return currentNode;
    }
    
    public void insert(T value)
    {
        AVLNode<T> currentNode = root;
        AVLNode<T> newNode = new AVLNode<T>(value);
        
        if (root == null)
        {
            root = newNode;
            return;
        }
        
        AVLNode<T> parent = null;
        while (currentNode != null)
        {
            parent = currentNode;
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.leftChild;
            else
                currentNode = currentNode.rightChild;            
        }
        if (value.compareTo(parent.getValue()) < 0)     // >
            parent.leftChild = newNode;
        else
            parent.rightChild = newNode;
            
    }
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####
    
    public Boolean isIn(T value)
    {
        AVLNode<T> currentNode = root;  
        
        while ((currentNode != null) && (value.compareTo(currentNode.getValue()) != 0))
        {
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.leftChild;
            else
                currentNode = currentNode.rightChild;            
        }
        
        return (currentNode != null);
    }
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####
    
    public void delete(T value)
    {
        root = _delete(root, value);
    }
    
    private AVLNode<T> _delete(AVLNode<T> currentNode, T value)
    {
        if (currentNode == null) return null;

        if (value.compareTo(currentNode.getValue()) == 0)
        {
            if ((currentNode.leftChild == null) && (currentNode.rightChild == null)) return null;
            if (currentNode.leftChild == null) return currentNode.rightChild;
            if (currentNode.rightChild == null) return currentNode.leftChild;

            T replacement = getMinValue(currentNode.rightChild);
            currentNode.setValue(replacement);
            currentNode.rightChild = _delete(currentNode.rightChild, replacement);
        }
        else if (value.compareTo(currentNode.getValue()) < 0) // >
            currentNode.leftChild = _delete(currentNode.leftChild, value);
        else
            currentNode.rightChild = _delete(currentNode.rightChild, value);
               
        return currentNode;
    }
    
    private T getMinValue(AVLNode<T> forNode)
    {
        while(forNode.leftChild != null)
        {
            forNode = forNode.leftChild;
        }
        return forNode.getValue();
    }
}