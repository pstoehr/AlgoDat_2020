public class MyNumber implements Cuckooable {
    private int value;
    
    MyNumber(int v){value = v;}
    public String toString(){return String.valueOf(value);}
    public int hash0(){return value%11;}
    public int hash1(){return (value/11)%11;}
    
    public int compareTo(MyNumber other)
    {
        return value-other.value;
    }
}