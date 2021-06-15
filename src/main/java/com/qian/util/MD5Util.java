package com.qian.util;

import cn.hutool.crypto.SecureUtil;

public class MD5Util {
    private static final String SALT = "md5encode";

    public static String encode(String rawString){
        String string = rawString+SALT;
        return SecureUtil.md5(string);
    }




}
