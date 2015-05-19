package callback;

import java.util.ArrayList;
import java.util.List;

public class SystemTimer {
	List<TimeUpdaterCallBack> callbacks = new ArrayList<TimeUpdaterCallBack>();

	public void registerCallBackForUpdatesEveryHour(TimeUpdaterCallBack timerCallBack) {
		callbacks.add(timerCallBack);
	}

	// ... This SystemTimer may have more logic here we don't know ...

	// At some point of the implementaion of this SystemTimer (you don't know)
	// this method will be called and every registered timerCallBack
	// will be called. Every registered timerCallBack may have a totally
	// different implementation of the method updateTime() and my be
	// used in different ways by different clients.
	public void oneHourHasBeenExprired() {

		for (TimeUpdaterCallBack timerCallBack : callbacks) {
			timerCallBack.updateTime(System.currentTimeMillis());
		}
	}
}
