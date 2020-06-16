import java.util.Random;
import java.util.Arrays;

public class SortedArray {
    private int aArray[];
    private int aSize;
    private Random dice;

    final private int MAXVALUE = 21;
    
    SortedArray()
    {
        aSize = 1234;
		aArray = new int[aSize];
        
        dice = new Random(4221);	
		
		for (int i=0; i<aSize; i+=1)
			aArray[i] = dice.nextInt(MAXVALUE);
        Arrays.sort(aArray);
    }
        
    public int getAnyValue()
    {
        return aArray[dice.nextInt(aSize)];
    }

    public int getFirstValue()
    {
        return aArray[0];
    }

    public int getLastValue()
    {
        return aArray[aSize-1];
    }
    
    // #####.    #####.    #####.    #####.    #####.    #####.    ######
    
    public Boolean findInArray(int aValue)
    {
        for (int v : aArray)
            if (v == aValue) return true;
        
        return false;
    }

    public Boolean findFastInArray(int aValue)
    {
        int start = 0;
        int end = aSize-1;
        
        while (start <= end)
        {
            int middle = start + (end - start)/2;
            if (aValue == aArray[middle]) return true;
            if (aValue < aArray[middle]) 
                end = middle - 1;
            else
                start = middle + 1;
        }
        return false;
    }


    public Boolean findRecFastInArray(int aValue)
    {
        return _findRecFastInArray(aValue, 0, aSize-1);
    }

    private Boolean _findRecFastInArray(int aValue, int start, int end)
    {
        if (start <= end)
        {
            int middle = start + (end - start)/2;
            if (aValue == aArray[middle]) return true;
            if (aValue < aArray[middle]) 
                end = middle - 1;
            else
                start = middle + 1;
            
            return _findRecFastInArray(aValue,start,end);
        }
        
        return false;
    }

    
    public static void main(String args[])
    {
        SortedArray myArray = new SortedArray();
        
        System.out.println("False: --> " + myArray.findFastInArray(5964));
        System.out.println("True : --> " + myArray.findFastInArray(myArray.getAnyValue()));
        System.out.println("True : --> " + myArray.findFastInArray(myArray.getFirstValue()));
        System.out.println("True : --> " + myArray.findFastInArray(myArray.getLastValue()));

        System.out.println("False: --> " + myArray.findRecFastInArray(5964));
        System.out.println("True : --> " + myArray.findRecFastInArray(myArray.getAnyValue()));
        System.out.println("True : --> " + myArray.findRecFastInArray(myArray.getFirstValue()));
        System.out.println("True : --> " + myArray.findRecFastInArray(myArray.getLastValue()));

    }
}