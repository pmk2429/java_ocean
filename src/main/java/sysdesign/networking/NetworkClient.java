package sysdesign.networking;

public interface NetworkClient {
    void execute(Request request, OnResponseListener listener);
}
