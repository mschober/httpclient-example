package com.example.httpclient;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.*;

import java.io.*;

public class HttpClientExample {

    public static void main( String[] args ) {
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod("http://www.apache.org/");
        PostMethod post = new PostMethod("http://jakarata.apache.org/");
        NameValuePair[] data = {
          new NameValuePair("user", "joe"),
          new NameValuePair("password", "bloggs")
        };

        if(args.length < 1)
            System.out.println("specify get or post");
        else if (args[0].equals("get")) {
            try {
                client.executeMethod(method);
                byte[] responseBody = method.getResponseBody();
                System.out.println(new String(responseBody));
            } catch(IOException e) {
                //fail
            }
        } else if (args[0].equals("post")) {
            try {
                post.setRequestBody(data);
                client.executeMethod(post);
                // execute method and handle any error responses.
                InputStream in = post.getResponseBodyAsStream();
                // handle response.
                System.out.println(inputToString(in));
            } catch(IOException e) {
                //fail
            }
        }

    }

    private static String inputToString(InputStream in) {
        String response = "";

        try {
            response = IOUtils.toString(in, "UTF-8");
        } catch (Exception e) {
            //fail
        }
        return response;
    }
}
