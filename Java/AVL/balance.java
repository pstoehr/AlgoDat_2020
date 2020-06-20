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
