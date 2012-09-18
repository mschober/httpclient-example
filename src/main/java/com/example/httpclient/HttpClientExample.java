package com.example.httpclient;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;

public class HttpClientExample {

    public static void main( String[] args ) {
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod("http://www.apache.org/");

        try {
            client.executeMethod(method);
            byte[] responseBody = method.getResponseBody();
            System.out.println(new String(responseBody));
        } catch(IOException e) {
            //fail
        }

    }
}
