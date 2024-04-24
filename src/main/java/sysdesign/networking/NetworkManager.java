package sysdesign.networking;

import okhttp3.RequestBody;

public class NetworkManager {

    private NetworkClient networkClient;

    public NetworkManager(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public void doGet(String url, OnResponseListener listener) {
        Request request = new Request.Builder()
                .setUrl(url)
                .setMethod(Request.METHOD.GET)
                .build();
        networkClient.execute(request, listener);
    }

    public void doPost(String url, OnResponseListener listener, RequestBody body) {
        Request request = new Request.Builder()
                .setUrl(url)
                .setBody(body)
                .setMethod(Request.METHOD.GET)
                .build();
        networkClient.execute(request, listener);
    }
}
