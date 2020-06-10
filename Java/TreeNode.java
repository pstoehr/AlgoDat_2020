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
		ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
		
		visit.accept(this);
		for (TreeNode<T> child : children)
			queue.add(child);
		
		int idx = 0;
		while (idx < queue.size())
		{
			TreeNode<T> node = queue.get(idx);
			visit.accept(node);
			idx += 1;
			for (TreeNode<T> grandchild : node.children)
				queue.add(grandchild);	
		}
		
	}
    
	public void printByLevel()
	{
		ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
        
		queue.add(this);
		int nextLevel = 1;
        while (queue.size() != 0)
        {
            nextLevel = printCurrentLevel(nextLevel, queue);
            System.out.println();
        }       
	}
    
    private int printCurrentLevel(int toBePrinted, ArrayList<TreeNode<T>> queue)
    {
        int nextLevel = 0;
        for (int i=0; i<toBePrinted; i+=1)
        {
            TreeNode<T> node = queue.remove(0);
            System.out.print(node.getValue() + " ");
            for (TreeNode<T> child : node.children)
            {
                nextLevel += 1;
                queue.add(child);
            }
        }
        return nextLevel;
    }
    
    
}