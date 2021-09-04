package com.wj.goods.controller;

import com.wj.goods.service.MemberService;

public class MemberController {
    private MemberService memberService;
    private String vipName;

    public void add() {
        memberService.insert();
    }
}
