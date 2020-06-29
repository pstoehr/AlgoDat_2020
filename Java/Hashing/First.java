public class First {
    
    public static void main(String args[])
    {
        Hashing<String> h = new Hashing<String>(97);
        Minions m = new Minions();
        
        for (int i=0; i<42; i++)
            h.add(m.getAny());
    }
}