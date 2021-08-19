package com.db.classwork.enums.lab;

/**
 * @author Evgeny Borisov
 */
public class HttpService {

    public void handleHttpCode(int httpCode) {
        HttpCode.getByCode(httpCode).handle();
    }
}
