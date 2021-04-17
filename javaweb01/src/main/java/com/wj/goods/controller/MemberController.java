package com.wj.goods.controller;

import com.wj.goods.annotation.Controller;
import com.wj.goods.annotation.Qualifier;
import com.wj.goods.annotation.StringValue;
import com.wj.goods.service.MemberService;

@Controller()
public class MemberController {

    @Qualifier(beanName = "memberService")
    private MemberService memberService;
    @StringValue("3772")
    public String vipNumber;

    public void add() {
        memberService.add();
    }

}
