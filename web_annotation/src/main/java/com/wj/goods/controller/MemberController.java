package com.wj.goods.controller;

import com.wj.goods.annotation.Controller;
import com.wj.goods.annotation.Qualifier;
import com.wj.goods.annotation.StringValue;
import com.wj.goods.service.MemberService;

@Controller
public class MemberController {

    @Qualifier
    private MemberService memberService;
    @StringValue("wj")
    private String vipName;

    public void add() {}

}
