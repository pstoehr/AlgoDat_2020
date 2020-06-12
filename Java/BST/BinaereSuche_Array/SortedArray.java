import java.util.Random;
import java.util.Arrays;

public class SortedArray {
    private int aArray[];
    private int aSize;
    private Random dice;

    final private int MAXVALUE = 21;
    
    SortedArray()
    {
        aSize = 42;
		aArray = new int[42];
        
        dice = new Random(4221);	
		
		for (int i=0; i<aSize; i+=1)
			aArray[i] = dice.nextInt(MAXVALUE);
        Arrays.sort(aArray);
    }
        
    int getAnyValue()
    {
        return aArray[dice.nextInt(aSize)];
    }
    
    // #####.    #####.    #####.    #####.    #####.    #####.    ######
    
    Boolean findInArray(int aValue)
    {
        return false;
    }

    Boolean findFastInArray(int aValue)
    {
        return false;
    }
    
    public static void main(String args[])
    {
        SortedArray myArray = new SortedArray();
        
        System.out.println(myArray.findFastInArray(5964));
        System.out.println(myArray.findFastInArray(myArray.getAnyValue()));
    }
}