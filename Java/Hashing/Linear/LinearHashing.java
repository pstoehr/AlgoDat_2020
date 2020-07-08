public class LinearHashing<T extends Comparable<? super T>> extends OpenHashing<T> {
    
    LinearHashing(int length)
    {
        super(length);
    }
    
    int nextHashingPos(int retry, T value)
    {
        return retry; // return (i/2)*(i/2)*alternate
    }
}