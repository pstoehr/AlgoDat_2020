import java.util.ArrayList;

public class Hashing <T> {
    private ArrayList<ArrayList<T>> hashTable;
    private int hashTableSize;
    
    Hashing()
    {
        this(997);
    }
    
    Hashing(int aSize)
    {
        hashTableSize = aSize;
        hashTable = new ArrayList<ArrayList<T>>();
        
        for (int i=0; i<hashTableSize; i++)
        {
            ArrayList<T> collisonTable = new ArrayList<T>();
            hashTable.add(collisonTable);
        }
    }
    
    public String toString()
    {
        String res = "";
        
        for (int i=0; i<hashTableSize; i++)
        {
            ArrayList<T> collisonTable = hashTable.get(i);
            res += "[" + i + "]";
            res += "<";
            for (int j=0; j<collisonTable.size(); j += 1)
                res += collisonTable.get(j);
            res += ">\n";
        }
        return res;
    }
    
    public void add(T value)
    {
        
    }
    
    public Boolean isIn(T Value)
    {
        return false;
    }
}
