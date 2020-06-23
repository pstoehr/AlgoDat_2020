import java.util.function.Consumer;

public class SplayNode<T> {

    public int height = 0;
    private T value;
    
    public SplayNode<T> leftChild;
    public SplayNode<T> rightChild;
    
    SplayNode(T v)
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
    private String desc(SplayNode<T> node, String top, String root, String bottom)
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
       
}