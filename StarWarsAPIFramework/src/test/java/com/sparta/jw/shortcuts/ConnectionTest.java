package com.sparta.jw.shortcuts;

import com.sparta.jw.connection.ConnectionManager;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpResponse;

public class ConnectionTest {

    public static void checkOkay(HttpResponse httpResponse){
        Assertions.assertTrue(ConnectionManager.connectionIsOkay(httpResponse));
    }
}
