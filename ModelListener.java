package problem1;

import java.util.EventListener;

public interface ModelListener extends EventListener
{
	public void modelUpdated(ModelEventObject ev);
}
