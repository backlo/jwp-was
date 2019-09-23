package http.request.core;

import http.exception.HttpRequestVersionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static utils.ParseString.parseFirstLine;
import static utils.StringUtils.*;

class RequestVersionTest {

    @Test
    @DisplayName("Get Method 가 잘들어온다.")
    void RequestGetMethodSuccess() {
        String version = parseFirstLine(FIRST_GET_0_9_LINE)[2];
        assertThat(RequestVersion.of(version).getVersion()).isEqualTo("HTTP/0.9");
    }

    @Test
    @DisplayName("Post Method 가 잘들어온다.")
    void RequestPostMethodSuccess() {
        String version = parseFirstLine(FIRST_POST_1_0_LINE)[2];
        assertThat(RequestVersion.of(version).getVersion()).isEqualTo("HTTP/1.0");
    }

    @Test
    @DisplayName("Put Method 가 잘들어온다.")
    void RequestPutMethodSuccess() {
        String version = parseFirstLine(FIRST_PUT_1_1_LINE)[2];
        assertThat(RequestVersion.of(version).getVersion()).isEqualTo("HTTP/1.1");
    }

    @Test
    @DisplayName("Delete Method 가 잘들어온다.")
    void RequestDeleteMethodSuccess() {
        String version = parseFirstLine(FIRST_DELETE_2_0_LINE)[2];
        assertThat(RequestVersion.of(version).getVersion()).isEqualTo("HTTP/2.0");
    }

    @Test
    @DisplayName("잘못된 method 가 들어오는 경우 예외처리 한다.")
    void RequestMethodFail() {
        String version = parseFirstLine(FIRST_WRONG_2_1_LINE)[2];
        assertThrows(HttpRequestVersionException.class, () -> RequestVersion.of(version));
    }

}