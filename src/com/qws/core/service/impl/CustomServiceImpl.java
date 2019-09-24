package com.qws.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qws.common.utils.Page;
import com.qws.core.bean.Customer;
import com.qws.core.dao.BaseDictDao;
import com.qws.core.dao.CustomerDao;
import com.qws.core.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomServiceImpl implements CustomerService {
	// ����dao����
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private BaseDictDao baseDictDao;

	public Page<Customer> findCustomerList(Integer page, Integer rows, 
			String custName,  String custSource,String custIndustry,String custLevel) {
		Customer customer = new Customer();
		//�жϿͻ�����(��˾����)
		if(StringUtils.isNotBlank(custName)){
			customer.setCust_name(custName);
		}
		//�жϿͻ���Ϣ��Դ
		if(StringUtils.isNotBlank(custSource)){
			customer.setCust_source(custSource);
		}
		//�жϿͻ�������ҵ
		if(StringUtils.isNotBlank(custIndustry)){
			customer.setCust_industry(custIndustry);
		}
		//�жϿͻ�����
		if(StringUtils.isNotBlank(custLevel)){
			customer.setCust_level(custLevel);
		}
		//��ǰҳ
		customer.setStart((page-1) * rows) ;
		//ÿҳ��
		customer.setRows(rows);
		//��ѯ�ͻ��б�
		List<Customer> customers = customerDao.selectCustomerList(customer);
		//��ѯ�ͻ��б��ܼ�¼��
		Integer count = customerDao.selectCustomerListCount(customer);
		//����Page���ض���
		Page<Customer> result = new Page<>();
		result.setPage(page);
		result.setRows(customers);
		result.setSize(rows);
		result.setTotal(count);
		return result;

	}

	@Override
	public Customer getCustomerById(Long id) {
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(Long id) {
		customerDao.deleteCustomer(id);
		
	}
}

