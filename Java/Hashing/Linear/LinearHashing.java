public class LinearHashing<T extends Comparable<? super T>> extends OpenHashing<T> {
    
    LinearHashing(int length)
    {
        super(length);
    }
    
    int nextHashingPos(int retry, T value)
    {
        return 42;
    }
}