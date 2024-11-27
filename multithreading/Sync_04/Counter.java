public class Counter{

    private int count = 0;

    synchronized public void increment_count(){
        count++;
    }

    public int get_count(){
        return count;
    }

}