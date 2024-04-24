package sysdesign.networking;

import java.util.Map;

public class Response {

    private byte[] data;
    private int statusCode;
    private Map<String, String> headers;

    public Response(byte[] data, int statusCode, Map<String, String> headers) {
        this.data = data;
        this.statusCode = statusCode;
        this.headers = headers;
    }

    public byte[] getResponseData() {
        return data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    // Getter method for headers
}
