package com.wj.goods.service;

import com.wj.goods.annotation.Repository;
import com.wj.goods.annotation.Update;
import org.omg.CORBA.INTERNAL;

@Repository("memberDao")
public interface MemberDao {


    Integer insert();
}
