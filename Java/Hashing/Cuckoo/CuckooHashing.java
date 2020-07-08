import java.util.ArrayList;

public class CuckooHashing <T extends Cuckooable> {
    private ArrayList<T> hashTable0, hashTable1;
    private int hashTableSize;
    
    CuckooHashing()
    {
        this(11);
    }
    
    CuckooHashing(int aSize)
    {
        hashTableSize = aSize;
        hashTable0 = new ArrayList<T>();
        hashTable1 = new ArrayList<T>();
        
        for (int i=0; i<hashTableSize; i++)
        {
            hashTable0.add(null);
            hashTable1.add(null);
        }
    }
    
    public String toString()
    {
        String res = "";

        res += "Table 0:\n" + hashTable0 + "\nTable 1:\n" + hashTable1;
        
        return res;

    }
    
    public Boolean add(T value)
    {
        T toBeInserted = value;
        T contentBefore;
        int cnt = 0;
  
        if (isIn(value)) return false;  
        while (cnt < hashTableSize) {
            
            contentBefore = hashTable0.get(toBeInserted.hash0());
            hashTable0.set(toBeInserted.hash0(), toBeInserted);
            if (contentBefore == null) return true;
            
            toBeInserted = contentBefore;
            contentBefore = hashTable1.get(toBeInserted.hash1());
            hashTable1.set(toBeInserted.hash1(), toBeInserted);
            if (contentBefore == null) return true;

            toBeInserted = contentBefore;
            
            cnt += 1;
        }
        // Original paper
        /*  
            rehash();
            insert(toBeInserted);
        */
        return false;
    }
    
    public Boolean isIn(T value)
    {
        return ((hashTable0.get(value.hash0()) == value) || 
                (hashTable1.get(value.hash1()) == value));
    }
    
    public Boolean delete(T value)
    {
        if (hashTable0.get(value.hash0()) == value) {
            hashTable0.set(value.hash0(), null);
            return true;
        }
        if (hashTable1.get(value.hash1()) == value) {
            hashTable1.set(value.hash1(), null);
            return true;
        }
        
        return false;
    }
}
