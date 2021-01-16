package com.sparta.jw.shortcuts;

import com.sun.xml.bind.v2.TODO;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadersTest {

    public static Map<String, List<String>> getHeaders(HttpResponse httpResponse){
        return httpResponse.headers().map();
    }

    public static int getNumberOfHeaders(HttpResponse httpResponse){
        return httpResponse.headers().map().size();
    }

    public static void checkNumberOfHeaders(HttpResponse httpResponse){
        Assertions.assertEquals(9, HeadersTest.getNumberOfHeaders(httpResponse));
    }

    public static String getServer(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches("server")){
                return map.get(header).get(0);
            }
        }
        return null;
    }

    public static void checkServer(HttpResponse httpResponse){
        Assertions.assertEquals("nginx/1.16.1", HeadersTest.getServer(httpResponse));
    }

    public static String getDate(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches("date")){
                return map.get(header).get(0);
            }
        }
        return null;
    }

    public static void checkDate(HttpResponse httpResponse){ //TODO Fix this

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy");
        try {
            Assertions.assertEquals(simpleDateFormat.parse(LocalDate.now().toString()), HeadersTest.getDate(httpResponse));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String getStatus(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches(":status")){
                return map.get(header).get(0);
            }
        }
        return null;
    }

    public static List<String> getAllow(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches("allow")){
                return map.get(header);
            }
        }
        return null;
    }

    public static String getContentType(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches("content-type")){
                return map.get(header).get(0);
            }
        }
        return null;
    }

    public static String getEtag(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches("etag")){
                return map.get(header).get(0);
            }
        }
        return null;
    }

    public static String getStrictTransportSecurity(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches("strict-transport-security")){
                return map.get(header).get(0);
            }
        }
        return null;
    }

    public static List<String> getVary(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches("vary")){
                return map.get(header);
            }
        }
        return null;
    }

    public static String getXFrameOptions(HttpResponse httpResponse){
        Map<String, List<String>> map = HeadersTest.getHeaders(httpResponse);
        for (String header : map.keySet()){
            if (header.matches("x-frame-options")){
                return map.get(header).get(0);
            }
        }
        return null;
    }
}
