package com.wj.goods.util;

import com.alibaba.druid.pool.vendor.MockExceptionSorter;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    //密码进行加密
    public static String getMd5String(String originStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] utf8s = md5.digest(originStr.getBytes("utf8"));

        BigInteger bigInteger = new BigInteger(1, utf8s);
        String string = bigInteger.toString(16);
        return string;

    }

}
