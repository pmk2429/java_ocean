package sysdesign.networking;

public interface OnResponseListener {
    void onResponse(Response response);

    void onError(Exception error);
}