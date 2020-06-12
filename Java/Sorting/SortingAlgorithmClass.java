import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;



public class SortingAlgorithmClass {
    public int array[]; // Fuer Debugging
    
	SortingAlgorithmClass(int aSize, int maxNum)	
	{
		array = new int[aSize];
        Random dice;
        dice = new Random(42);	
		
		for (int i=0; i<aSize; i+=1)
			array[i] = dice.nextInt(maxNum+1);

	}
    SortingAlgorithmClass()
    {
        this(42);
    }

    SortingAlgorithmClass(int n)
    {
        array = new int[n];
        for (int i=0; i<n; i++)
            array[i] = i;
    }

    SortingAlgorithmClass(int otherArray[])
    {
        array = new int[otherArray.length];
        for (int i=0; i<otherArray.length; i++)
            array[i] = otherArray[i];
    }
 
    public void ascending()
    {
        for (int i=0; i<array.length; i++)
            array[i] = i;
    }

    public void decending()
    {
        for (int i=0; i<array.length; i++)
            array[i] = array.length-i-1;
    }

    static int incCnt = 0;
    public void shuffle(boolean random)
    {
        Random dice;

        if (random)
            dice = new Random(System.currentTimeMillis()+incCnt++);
        else
            dice = new Random(42);

        // Knuth Band 2
        for (int i=0; i<array.length; i++)
        {
            int j = dice.nextInt(i+1);
			swapAtIndex(i,j);
		}
    }   
    
    public boolean isSorted()
    {
        for (int i=0; i<array.length-1; i++)
            if (array[i] > array[i+1]) return false;
        return true;
    }
    
    public void dump(int lineLength)
    {
        int nrLength = (int)Math.log10(array.length)+3;
        int maxPerLine = lineLength / nrLength;
        String formatStr = "%" + nrLength + "d";
        
        for (int i=0; i<array.length; i++)
        {
            if ((i!=0) && (i%maxPerLine==0)) System.out.println();
            System.out.printf(formatStr, array[i]);
        }
        System.out.println();
    }

    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####
        
	private void swapAtIndex(int i, int j)
	{
		int zwsp = array[i];
		array[i] = array[j];
		array[j] = zwsp;
	}

    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####
    
    public void randomSort()
    {
        int keepAlive = 1;
        while (!isSorted())
        {
            shuffle(true);
            keepAlive += 1;
            if ((keepAlive % 100) == 0) System.out.println(keepAlive);
        }
        System.out.println(keepAlive);
    }

    // #####     #####     #####     #####     #####     #####
    
    public void dropSort()
    {
	    int zwsp[] = new int[array.length];
		int idx = 0;
		
		zwsp[0] = array[0];
		for (int i=1; i<array.length; i++)
		{
			if (array[i] > zwsp[idx])
			{
				idx+=1;
				zwsp[idx] = array[i];
			}
		}	
		array = new int[idx+1];
		for (int i=0; i<idx+1; i++)
			array[i] = zwsp[i];
    }

    // #####     #####     #####     #####     #####     #####

	public void bubbleSort()
	{
		boolean hasSwap = true;
		for (int j=0; (j<array.length-1) && hasSwap;j++) 
		{
			hasSwap = false;
			int zeilenLaenge;
			zeilenLaenge = array.length-j;			
			for (int i=0; i<zeilenLaenge-1; i++)
			{
				if (array[i] > array[i+1])
				{
					swapAtIndex(i, i+1);
					hasSwap = true;
				}
			}
		}
	}
	
    // #####     #####     #####     #####     #####     #####
	
	public void bubbleSortRec()
	{
		embededBSR(0,array.length-1);
	}
	private void embededBSR(int start, int stop)
	{
		if (start == stop) return;
		else {
			bubbleSortLine(start, stop);
			embededBSR(start, stop-1);
		}
	}
	
	private void bubbleSortLine(int start, int stop)
	{
		if (array[start] > array[start+1]) swapAtIndex(start, start+1);
		if ((stop-start) == 1) return;
		else bubbleSortLine(start+1, stop);
	}

    // #####     #####     #####     #####     #####     #####

    public void selectionSort()
    {
        int sortedIndex = array.length;
        
        for (int i=0; i<array.length-1; i+=1)
        {
            int max = array[0];
            int maxPos = 0;
            for (int j=1; j<sortedIndex; j+=1)
            {
                if (array[j] > max)
                {
                    max = array[j];
                    maxPos = j;
                }
            }
            sortedIndex -= 1;
            swapAtIndex(maxPos, sortedIndex);        
        }
    }

    // #####     #####     #####     #####     #####     #####

    public void insertionSort()
    {
        // Shell-Sort light
        _insertionSort(1);
    } 

    public void _insertionSort(int jump)
    {
        for (int i=jump; i<array.length; i+=1)
        {
            int currentValue = array[i];
            int j=i;
            while ((j>=jump) && (array[j-jump] > currentValue))
            {
                array[j] = array[j-jump];
                j -= jump;
            }
            array[j] = currentValue;
        }
    } 

    // #####     #####     #####     #####     #####     #####
    
    public void shellSortHibbard()
    {
        // Verwendet die Folge von Hibbard 2^k-1
        int k = (int)(Math.log(array.length) / Math.log(2));
        int pow2 = 2;
        
        if (k > 31) k = 31;
        int jumpArray[] = new int[k];
        for (int i=0; i<k; i++)
        {
            jumpArray[k-1-i] = pow2-1;
            pow2 *= 2;
        }
        
        for (int jump : jumpArray)
            _insertionSort(jump);
    }

    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####

    public void quicksort()
    {
        quicksortRec(array, array.length);
    }
    
    private void quicksortRec(int theArray[], int used)
    {
        
        if (used < 2) return;
        
        int lhs[] = new int[used-1];
        int lCnt = 0;
        int rhs[] = new int[used-1];
        int rCnt = 0;
        int pivots[] = new int[used];
        int pCnt = 0;
        
        int pivotIdx = IDXmedianOfThree(0,used-1);
        int pivot = theArray[pivotIdx];
        
        // Aufteilen der Arraywerte auf die 3 Teilarrays
        for (int i=0; i<used; i+=1)
        {
            int v = theArray[i];
            if (v < pivot) {
                lhs[lCnt] = v;
                lCnt += 1;
            }
            if (v == pivot) {
                pivots[pCnt] = v;
                pCnt += 1;
            }
            if (v > pivot) {
                rhs[rCnt] = v;
                rCnt += 1;
            }
        }

        quicksortRec(lhs, lCnt);    
        quicksortRec(rhs, rCnt);
        
        int idx = 0;
        for (int i=0; i<lCnt; i+=1)
        {
            int v=lhs[i];
            theArray[idx]=v;
            idx += 1;
        }   
        for (int i=0; i<pCnt; i+=1)
        {
            int v=pivots[i];
            theArray[idx]=v;
            idx += 1;
        }   
        for (int i=0; i<rCnt; i+=1)
        {
            int v=rhs[i];
            theArray[idx]=v;
            idx += 1;
        }   
    }
    
    private int IDXmedianOfThree(int low, int high)
    {
        int center = (low + high) / 2;
        if (array[low] > array[center])
        {
            if (array[low] > array[high]) return high; else return low;
        }
        else {
            if (array[center] > array[high]) return high; else return center;            
        }
    }
     
    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####
    
    // Quicksort Hoare
    public void quicksortHoare()
    {
        _quicksortHoareRec(0, array.length-1);
    }
    private void _quicksortHoareRec (int low, int high)
    {
        if (low < high) {
            int pivotIDX = _partitionHoare(low, high);
            _quicksortHoareRec(low, pivotIDX);
            _quicksortHoareRec(pivotIDX+1, high);
        }
    }
    
    private int _partitionHoare(int low, int high)
    {
        int pivot = array[low];
        
        int left = low-1;
        int right = high+1;
        
        while (true)
        {
            do {left += 1;} while(array[left]<pivot);    // Elemente passen "links"
            do {right -= 1;} while(array[right]>pivot);  // Elemente passen "rechts"
            
            if (left < right) 
                swapAtIndex(left, right);
            else
                return right;
        }        
    }
    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####

    // Quicksort Dutch
    public void quicksortDF()
    {
        _quicksortDF(0,array.length-1);
    }
    
    private void _quicksortDF(int low, int high)
    {
        if (low < high)
        {
            int partitionRet[] = _partitionDF(low, high);
            _quicksortDF(low, partitionRet[0]-1);
            _quicksortDF(partitionRet[1]+1, high);
        }
    }
    
    private int[] _partitionDF(int low, int high)
	{
		int pivot = array[(low+high)/2];
		int smaller = low;
		int equal = low;
		int larger = high;
		
		while (equal <= larger)
		{
			if (array[equal] < pivot)
			{
				swapAtIndex(equal, smaller);
				smaller += 1;
				equal += 1;
			}
			else if (array[equal] == pivot) equal += 1;
			else {
				swapAtIndex(equal, larger);
				larger -= 1;
			}
		}
		int retValue[] = {smaller, larger};
		return retValue;
	}
    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####

    // Merge Sort
	
    public void mergeSort() 
    {
        int tmpMemory[] = new int[array.length];
        _mergeSortRec(0, array.length-1, tmpMemory);
    }

    private void _mergeSortRec(int start, int end, int tmpMemory[])
    {
        // Est solvable?
        if ((end-start) >= 1)
        {
            int middle = (end + start) / 2;
            // Divide 
            _mergeSortRec(start, middle, tmpMemory);
            _mergeSortRec(middle+1, end, tmpMemory);
            // Unite
            combine(start, middle+1, end, tmpMemory);
        }
    }
	
	private void combine(int start,int middle, int end, int buffer[])
	{
		int start_01 = start; 
		int last_01 = middle - 1;
		int start_02 = middle;
		int last_02 = end;
		int idx = 0;
		
		int i = start_01;
		int j = start_02;
		
		// In beiden sortierten Teil-Arrays sind noch Werte
		while ((i <= last_01) && (j <= last_02))
		{
			if (array[i] < array[j])
			{
				buffer[idx] = array[i];
				idx += 1;
				i += 1;
			}
			else {
				buffer[idx] = array[j];
				idx += 1;
				j += 1;				
			}	
		}
		
		// Eines der beiden Teilarrays ist leer
		
		// Rest in Ergebnis kopieren
		while (i <= last_01)
		{
			buffer[idx] = array[i];
			idx += 1;
			i += 1;			
		}
		
		while (j <= last_02) {
			buffer[idx] = array[j];
			idx += 1;
			j += 1;			
		}	
		
		// Ergebnis wieder in Array zurueck
		idx = 0;
		for (int ergIdx=start_01; ergIdx<=last_02; ergIdx += 1)
		{
			array[ergIdx] = buffer[idx];
			idx += 1;
		}
	}
    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####

    // Heapsort
    public void heapSort()
    {
        int lastIDX = array.length-1;
        
        createHeap();

        for (int i=lastIDX; i>0; i -= 1)
        {
            swapAtIndex(i,0);
            sink(0,i-1);
        }
    }
    
    public void createHeap()
    {
        for (int i=(array.length-1)/2; i>=0; i-=1)
            sink(i, array.length-1);
    }
    
    private void sink(int nodeId, int lastId)
    {
        // Wenn ein Kind vorhanden ist
        // while (leftSonOf(nodeId) <= lastId) wuerde auch reichen
        
        while ((rightSonOf(nodeId) <= lastId) || (leftSonOf(nodeId) <= lastId))
        {
            // Testet lokale MaxHeap-Eigenschaft und erstellt sie zur Not
            int maxId = leftSonOf(nodeId);
            if ((rightSonOf(nodeId) <= lastId) && (array[rightSonOf(nodeId)] > array[leftSonOf(nodeId)]))
                maxId = rightSonOf(nodeId);
        
            if (array[nodeId] < array[maxId])
            {
                swapAtIndex(nodeId, maxId);
                nodeId = maxId;
            }  
            else
                return;          
        }
    }
    private int leftSonOf(int i)
    {
        return 2*i+1;
    }
    
    private int rightSonOf(int i)
    {
        return 2*i+2;
    }
    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####
    
    public void bucketSort()
    {
        int max = array[0];
        int min = array[0];
        for (int i=1; i<array.length; i++)
        {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        
        int buckets[] = new int[max-min+1]; // TBC
        for (int i=0; i<array.length; i += 1)
        {
            buckets[array[i]-min] = buckets[array[i]-min] + 1;
        }
        
        int idx=0;
        for (int b=0; b<buckets.length; b += 1)
        {
            // Fuer jeden Bucket mache ...
            for (int i=0; i<buckets[b]; i += 1)
            {
                array[idx] = b+min;
                idx += 1;
            }
        }
    }
 
    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####

    private class _Bucket {
        ArrayList<Integer> bucket;
        
        _Bucket()
        {
            bucket = new ArrayList<Integer>();
            bucket.ensureCapacity(array.length/10);
        }
        
        void reset()
        {
            bucket.clear();
        }
    }
    
    public void radixSort()
    {
        int base = 10;

        _Bucket allBuckets[] = new _Bucket[10];
        for (int i=0; i<base; i += 1)
            allBuckets[i] = new _Bucket();

        boolean done = false;
        int digits = 1;
        
        while (!done) {
            done = true;
            
            for (int i=0; i<base; i += 1)
                allBuckets[i].bucket.clear();
            
            for (int i=0; i<array.length; i+=1)
            {
                int remainingPart = array[i] / digits;
                int lastDigit = remainingPart % base;
                allBuckets[lastDigit].bucket.add(array[i]);
                if (remainingPart > 0) done = false;
            }
            digits *= base;
            int idx = 0;
            for (int i=0; i<base; i += 1)
            {
                int cnt = allBuckets[i].bucket.size();
                ArrayList<Integer> buckelList = allBuckets[i].bucket;
                for (int j=0; j<cnt; j += 1)
                    array[idx++] = buckelList.get(j);
            }
        }
    }
    // #####     #####     #####     #####     #####     #####
    //      #####     #####     #####     #####     #####     #####
    // #####     #####     #####     #####     #####     #####
    
    public static void main(String args[])
    {
        
        try
        {
            // For profiling that delay to 1
            TimeUnit.MINUTES.sleep(0); 
         }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
 
        //int tbs[] = {-1, 0, 1_000_000};
        SortingAlgorithmClass d = new SortingAlgorithmClass(20_000_000);
        d.shuffle(false);
        long start = System.currentTimeMillis();
        d.radixSort();
        long end = System.currentTimeMillis();
        System.out.println("Radix-Sort:" + (double)(end - start)/1_000_000.0 + "ms");
        System.out.println(d.isSorted());

        d.shuffle(false);
        start = System.currentTimeMillis();
        d.mergeSort();
        end = System.currentTimeMillis();
        System.out.println("Merge-Sort:" + (double)(end - start)/1_000_000.0 + "ms");
        System.out.println(d.isSorted());

    }
}

/*
    Laufzeiten mit 1_234_567
    Bubble Sort     : 2880.503 Sekunden
    Shell Sort      : 
*/        