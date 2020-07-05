import java.util.ArrayList;

public abstract class OpenHashing <T extends Comparable<? super T>> {
    private ArrayList<T> hashTable;
    private int hashTableSize;

    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####

    abstract int nextHashingPos(int retry, T value);
    
    // #####     #####     #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####     #####     #####

    OpenHashing()
    {
        this(997);
    }
    
    OpenHashing(int aSize)
    {
        hashTableSize = aSize;
        hashTable = new ArrayList<T>();
        
        for (int i=0; i<hashTableSize; i++)
        {
            hashTable.add(null);
        }
    }

    public String toString()
    {
        String res = "";
        
        for (int i=0; i<hashTableSize; i++)
        {
            res += "[" + i + "]";
            res += "<";
            T value = hashTable.get(i);
            if (value != null) res += value;    
            res += ">\n";
        }
        return res;
    }
    
    public Boolean add(T value)
    {
        // Hash-Wert berechnen
        int hash = value.hashCode();
        int baseHashValue = Math.abs(hash) % hashTableSize;     // Position im Array
        int hashValue = baseHashValue;

        // Add Entry

        return false;
    }
    
    public Boolean isIn(T value)
    {
        // Hash-Wert berechnen
        int hash = value.hashCode();
        int baseHashValue = Math.abs(hash) % hashTableSize;     // Position im Array
        int hashValue = baseHashValue;

        // Find Entry
        
        return false;
    }
    
    public Boolean delete(T value)
    {
        return false;
    }
}
