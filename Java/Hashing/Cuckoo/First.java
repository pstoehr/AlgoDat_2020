public class First {
    
    public static void main(String args[])
    {
        CuckooHashing<MyNumber> h = new CuckooHashing<MyNumber>();
        int values[] = {20, 50, 53, 75, 100, 67, 105, 3, 36, 39};
        
        for (int v : values)
            h.add(new MyNumber(v));
        
        System.out.println(h);        
    }
}