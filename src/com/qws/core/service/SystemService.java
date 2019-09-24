package com.qws.core.service;

import java.util.List;

import com.qws.core.bean.BaseDict;

public interface SystemService {

	//根据类型查询数据字典
		public List<BaseDict> findBaseDictListByType(String typecode);

}
