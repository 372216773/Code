package com.wj.goods.service;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class RegisterServiceTest {

    @Test
    public void testRegister() throws UnsupportedEncodingException, SQLException, NoSuchAlgorithmException {

        RegisterService registerService = new RegisterService();
        boolean b = registerService.checkNickname("王京");
        System.out.println(b);

    }

}
