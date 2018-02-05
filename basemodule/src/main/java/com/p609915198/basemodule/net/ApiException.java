package com.p609915198.basemodule.net;

public class ApiException extends RuntimeException {
    public ApiException(HttpResult httpResult) {
        this(getApiExceptionMessage(httpResult));
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     *
     * @return
     */
    private static String getApiExceptionMessage(HttpResult httpResult) {
        switch (httpResult.getCode()) {

        }
        return httpResult.getMsg();
    }
}