// Example class 
//  Create collions ...
public class MyNumber implements Comparable<MyNumber> {
    private int value;
    
    MyNumber(int v){value = v;}
    public String toString(){return String.valueOf(value);}
    public int hashCode(){return value%7;}
    
    public int compareTo(MyNumber other)
    {
        return value-other.value;
    }
}