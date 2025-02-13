package controller;

import controller.exception.PathNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webserver.http.request.HttpRequest;
import webserver.http.request.core.RequestLine;
import webserver.http.request.core.RequestMethod;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static utils.UtilData.*;

class ControllerFactoryTest {
    private RequestLine requestLine;
    private HttpRequest httpRequest;

    @Test
    @DisplayName("컨트롤 매핑이 잘되고 있는지 테스트")
    void mappingControllerTest() {
        requestLine = new RequestLine(RequestMethod.of(POST_METHOD), REQUEST_POST_PATH, REQUEST_VERSION);
        httpRequest = new HttpRequest(requestLine, POST_REQUEST_HEADER, BODY_DATA);

        assertDoesNotThrow(() -> {
            ControllerFactory.mappingController(httpRequest);
        });
    }

    @Test
    @DisplayName("컨트롤 매핑할 때 예외처리 하는지 테스트")
    void mappingControllerExceptionTest() {
        requestLine = new RequestLine(RequestMethod.of(GET_METHOD), REQUEST_WRONG_PATH, REQUEST_VERSION);
        httpRequest = new HttpRequest(requestLine, GET_REQUEST_HEADER, QUERY_DATA);

        assertThrows(PathNotFoundException.class,
                () -> ControllerFactory.mappingController(httpRequest));
    }

}