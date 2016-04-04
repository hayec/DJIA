package problem1;

public interface AddPoint 
{
	public void register(Observer o);
	public void unregister(Observer o);
	public void notifyObserver();
}
