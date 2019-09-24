package com.qws.core.service;

import com.qws.common.utils.Page;
import com.qws.core.bean.Customer;

public interface CustomerService {
	// ��ѯ�ͻ��б�
		public Page<Customer> findCustomerList(Integer page, Integer rows, 
				String custName,  String custSource,String custIndustry,String custLevel);

		public Customer getCustomerById(Long id);

		public void updateCustomer(Customer customer);

		public void deleteCustomer(Long id);


}
