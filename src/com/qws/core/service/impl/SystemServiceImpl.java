package com.qws.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qws.core.bean.BaseDict;
import com.qws.core.dao.BaseDictDao;
import com.qws.core.service.SystemService;

@Service("systemService")
public class SystemServiceImpl implements SystemService{
	
	@Autowired
	private BaseDictDao baseDictDao;
	//�������ͱ�Ų�ѯ�����ֵ�
	public List<BaseDict> findBaseDictListByType(String typecode) {
		return baseDictDao.selectByTypecode(typecode);
	}
}

