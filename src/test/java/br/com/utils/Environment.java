package br.com.utils;

public enum Environment {
    dev("https://www.youtube.com/"), qa("https://www.google.com/?hl=pt_br");

    public String baseUri;
    Environment(String uri) {
        baseUri = uri;
    }

    public String getBaseUri(){
        return this.baseUri;
    }
}
