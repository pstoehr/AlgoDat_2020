import java.util.ArrayList;
import java.util.function.Consumer;


public class TreeNode<T> {
    private T value;
    private ArrayList<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
    
    TreeNode(T v)
    {
        value = v;
    }
    
    void add (TreeNode<T> child)
    {
        children.add(child);
    }
    
    T getValue()
    {
        return value;
    }
    
	void depthFirst(Consumer<TreeNode<T>> visit)
	{
		visit.accept(this);
		for (TreeNode<T> node : children)
			node.depthFirst(visit);
	}
	
	void breadthFirst(Consumer<TreeNode<T>> visit)
	{
	}
    
	public void printByLevel()
	{
	}
    
    
    
}