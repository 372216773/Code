package com.wj.goods.service;

import com.wj.goods.annotation.Qualifier;
import com.wj.goods.annotation.Service;
import com.wj.goods.dao.GoodsDao;
import com.wj.goods.dao.MemberDao;

@Service("memberService")
public class MemberService {

    @Qualifier(beanName = "memberDao")
    private MemberDao memberDao;
    private GoodsDao goodsDao;

    public void add() {

        memberDao.insert();

    }
}
