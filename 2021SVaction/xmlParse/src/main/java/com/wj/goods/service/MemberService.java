package com.wj.goods.service;

import com.wj.goods.dao.MemberDao;

public class MemberService {
    private MemberDao memberDao;
    public void insert() {
        memberDao.insert();
    }
}
