public class AVLTree<T extends Comparable<? super T>> {
    
    public AVLNode<T> root;
    
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
        
        AVLNode<T> balancedNode = balance(currentNode);
        balancedNode.height = Math.max(balancedNode.leftHeight(), balancedNode.rightHeight()) + 1;
        return balancedNode;
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
               
        AVLNode<T> balancedNode = balance(currentNode);
        balancedNode.height = Math.max(balancedNode.leftHeight(), balancedNode.rightHeight()) + 1;
        return balancedNode;
    }
    
    private T getMinValue(AVLNode<T> forNode)
    {
        while(forNode.leftChild != null)
        {
            forNode = forNode.leftChild;
        }
        return forNode.getValue();
    }
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####

    private AVLNode<T> leftRotation(AVLNode<T> node)
    {
        AVLNode<T> pivot = node.rightChild;
        node.rightChild = pivot.leftChild;
        pivot.leftChild = node;
        
        node.height = Math.max(node.leftHeight(), node.rightHeight()) + 1;
        pivot.height = Math.max(pivot.leftHeight(), pivot.rightHeight()) + 1;
        
        return pivot;
    }
    
    private AVLNode<T> rightRotation(AVLNode<T> node)
    {
        AVLNode<T> pivot = node.leftChild;
        node.leftChild = pivot.rightChild;
        pivot.rightChild = node;
        
        node.height = Math.max(node.leftHeight(), node.rightHeight()) + 1;
        pivot.height = Math.max(pivot.leftHeight(), pivot.rightHeight()) + 1;
        
        return pivot;
    }

    
    private AVLNode<T> rightLeftRotation(AVLNode<T> node)
    {
        if (node.rightChild == null) return node;

        AVLNode<T> rightChild = node.rightChild;
        node.rightChild = rightRotation(rightChild);
        return leftRotation(node);
    }

    private AVLNode<T> leftRightRotation(AVLNode<T> node)
    {
        if (node.leftChild == null) return node;
        
        AVLNode<T> leftChild = node.leftChild;
        node.leftChild = leftRotation(leftChild);
        return rightRotation(node);
    }

    private AVLNode<T> balance(AVLNode<T> node)
    {
        switch (node.balanceFactor()) {
            case 2:
            if ((node.leftChild != null) && (node.leftChild.balanceFactor() == -1))
                return leftRightRotation(node);
            else
                return rightRotation(node);
            case -2:
            if ((node.rightChild != null) && (node.rightChild.balanceFactor() == 1))
                return rightLeftRotation(node);
            else 
                return leftRotation(node);
            
            default:
            break;
        }
        return node;
    }
}


















