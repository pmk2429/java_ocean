package sysdesign.networking;

import okhttp3.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String url;
    private METHOD method;
    private Map<String, String> headers;
    private byte[] body;

    public static enum METHOD {
        POST,
        GET,
        DELETE
    }

    public static class Builder {
        private String url;
        private METHOD method;
        private Map<String, String> headers = new HashMap<>();
        private byte[] body;
        private RequestBody requestBody;

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setMethod(METHOD method) {
            this.method = method;
            return this;
        }

        public Builder addHeader(String key, String value) {
            headers.put(key, value);
            return this;
        }

        public Builder setBody(byte[] body) {
            this.body = body;
            return this;
        }

        public Builder setBody(RequestBody body) {
            this.requestBody = body;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }

    private Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.body = builder.body;
    }

    // Getter methods for url, method, headers, and body
}
