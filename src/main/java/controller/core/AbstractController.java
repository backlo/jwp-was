package controller.core;

import webserver.http.HttpHeaderField;
import webserver.http.request.HttpRequest;
import webserver.http.response.HttpResponse;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;

public abstract class AbstractController implements Controller {
    protected static final String DEFAULT_PAGE = "http://localhost:8080/index.html";
    protected static final String LOGIN_FAILED = "http://localhost:8080/user/login_failed.html";

    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    public AbstractController init(HttpRequest httpRequest, HttpResponse httpResponse) {
        this.httpRequest = httpRequest;
        this.httpResponse = httpResponse;
        return this;
    }

    @Override
    public abstract void service(OutputStream out, HttpRequest httpRequest, HttpResponse httpResponse) throws IOException, URISyntaxException;

    protected void doPost(HttpRequest httpRequest, HttpResponse httpResponse) { }

    protected void doGet(HttpRequest httpRequest, HttpResponse httpResponse) { }
}
