package com.qws.core.service;

import java.util.List;

import com.qws.core.bean.BaseDict;

public interface SystemService {

	//�������Ͳ�ѯ�����ֵ�
		public List<BaseDict> findBaseDictListByType(String typecode);

}
