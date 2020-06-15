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
	
    // Vereinfachung: Effiziente Implementierung einer Dequeue ist vorhanden
	void breadthFirst(Consumer<TreeNode<T>> visit)
	{
        ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
        
        queue.add(this);
        while (queue.size() != 0)
        {
            TreeNode<T> currentNode = queue.remove(0);
            visit.accept(currentNode);
            
            for (TreeNode<T> child : currentNode.children)
                queue.add(child);
        }
	}
    
	public void printByLevel()
	{
        ArrayList<TreeNode<T>> queue = new ArrayList<TreeNode<T>>();
        queue.add(this);
        queue.add(null);
        
        while (queue.size() != 0)
        {
            TreeNode<T> currentNode = queue.remove(0);
            if (currentNode == null)
            {
                // Ende der aktuellen Zeile 
                System.out.println();
                // Alle Kinder der aktuellen Zeil in der Queue --> Ende markieren
                if (queue.size() != 0) queue.add(null);                
            }
            else {
                // Normaler Knoten
                System.out.print(currentNode.getValue() + " ");
                for (TreeNode<T> child : currentNode.children)
                    queue.add(child);
            }
        }
	}

/*
    Alternative Version die nur ein dynamisch wachsendes Array benötigt und einen
    Zähler verwendet.

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
*/
        
	public Boolean isIn(T value)
	{
        if (this.getValue().equals(value)) return true;
        else {
            // Schaue nach, ob value in irgendeinem Kind-Baum enthalten ist
            for (TreeNode<T> child : children)
            {
                Boolean erg = child.isIn(value);
                if (erg) return true;
            }
        }
        return false;
	}
    
    
}