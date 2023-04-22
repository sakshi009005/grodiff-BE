package com.grocery.diff.service;

import java.io.IOException;
import java.net.*;

public class CookieService {

    public static String showCookies(String webSite) throws IOException {
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Access the website
        URL url = new URL(webSite);
        URLConnection urlConnection = url.openConnection();
        urlConnection.getContent();

        // Get CookieStore
        CookieStore cookieStore = cookieManager.getCookieStore();

        String cookie = "";
        // Get cookies
        for (HttpCookie httpCookie : cookieStore.getCookies()) {
            cookie = cookie + httpCookie.toString();

        }
        return cookie;
    }
}
