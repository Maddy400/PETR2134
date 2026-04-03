public interface AccountObserver{

    //Called whenever bank balance changes
    void update(double balance, String transaction);
}