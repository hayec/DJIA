package problem1;

public interface PlotPoint 
{
	public void register(ModelObserver o);
	public void unregister(ModelObserver o);
	public void notifyObserver();
}
