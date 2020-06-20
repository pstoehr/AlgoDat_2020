import java.util.function.Consumer;

public class AVLNode<T> {

    public int height = 0;
    private T value;
    
    public AVLNode<T> leftChild;
    public AVLNode<T> rightChild;
    
    AVLNode(T v)
    {
        value = v;
    }

    public void setValue(T v)
    {
        value = v;
    }
    
    public T getValue()
    {
        return value;
    }
    
    // Inspired by Knuth
    private String desc(AVLNode<T> node, String top, String root, String bottom)
    {
        if (node == null) return root + "null\n";
        
        if ((node.leftChild == null) && (node.rightChild == null))
            return root + node.value + "\n";
        
        return desc(node.rightChild, 
                    top + " ",
                    top + "┌──", 
                    top + "│ ") +
                    root + node.value + "\n" +
               desc(node.leftChild,
                    bottom + "| ",
                    bottom + "└──", 
                    bottom + " ");
    }
    
    public String toString()
    {
        return desc(this, "", "", "");
    }
    
    // #####     #####    #####     #####     #####     #####     #####     #####
    //      #####     #####    #####     #####     #####     #####     #####
    // #####    #####     #####     #####     #####     #####     #####     #####
        
    void traversalPreOrder(Consumer<AVLNode<T>> visit)
    {
        visit.accept(this);
        if (leftChild != null) leftChild.traversalPreOrder(visit);
        if (rightChild != null) rightChild.traversalPreOrder(visit);
    }
    
    void traversalInOrder(Consumer<AVLNode<T>> visit)
    {
        if (leftChild != null) leftChild.traversalInOrder(visit);
        visit.accept(this);
        if (rightChild != null) rightChild.traversalInOrder(visit);
        
    }
    
    void traversalPostOrder(Consumer<AVLNode<T>> visit)
    {
        if (leftChild != null) leftChild.traversalPostOrder(visit);
        if (rightChild != null) rightChild.traversalPostOrder(visit);
        visit.accept(this);        
    }
    
    // #####     #####     #####     #####     #####     #####     #####
    
    public int leftHeight()
    {
        if (leftChild != null)
            return leftChild.height;
        else
            return -1;
    }

    public int rightHeight()
    {
        if (rightChild != null)
            return rightChild.height;
        else
            return -1;
    }
    
    public int balanceFactor()
    {
        return leftHeight() - rightHeight();
    }

    // #####     #####     #####     #####     #####     #####     #####
    
}