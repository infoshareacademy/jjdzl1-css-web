package com.infoshare.academy.cdi;

import java.io.UnsupportedEncodingException;

public interface ConvertToXhtml {

    String UTF_8 = "UTF-8";

    String convertToXhtml(String html) throws UnsupportedEncodingException;
}
