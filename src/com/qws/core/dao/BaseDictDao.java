package com.qws.core.dao;

import java.util.List;

import com.qws.core.bean.BaseDict;

public interface BaseDictDao {
	//���������ֵ��������ѯ
    List<BaseDict> selectByTypecode(String typecode);
    //���������ֵ�ID��ѯ
    BaseDict selectByPrimaryKey(String dictId);


}
