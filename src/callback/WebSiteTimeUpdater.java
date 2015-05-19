package callback;

public class WebSiteTimeUpdater {
	public static void main(String[] args) {
		SystemTimer SystemTimer = new SystemTimer();
		TimeUpdaterCallBack webSiteCallBackUpdater = new WebSiteTimeUpdaterCallBack();
		SystemTimer.registerCallBackForUpdatesEveryHour(webSiteCallBackUpdater);
	}
}
