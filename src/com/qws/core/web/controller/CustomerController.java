package com.qws.core.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qws.common.utils.Page;
import com.qws.core.bean.BaseDict;
import com.qws.core.bean.Customer;
import com.qws.core.service.CustomerService;
import com.qws.core.service.SystemService;

/**
 * �ͻ�����
 * <p>Title: CustomerController</p>
 * @version 1.0
 */

@Controller
public class CustomerController {
	// ����ע��
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SystemService systemService;
	/*
	Spring 3֧��@valueע��ķ�ʽ��ȡproperties�ļ��е�����ֵ������˶�ȡ�����ļ��Ĵ��롣
	1����applicationContext.xml�ļ�������properties�ļ�
	<!-- ���� ��ȡproperties�ļ� jdbc.properties -->
		<context:property-placeholder location="classpath:jdbc.properties" />
	2����bean��ʹ��@valueע���ȡ�����ļ���ֵ
	@Value("${customer.from.type}")
	 */
	@Value("${customer.from.type}")
	private String FROM_TYPE;
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;
	
	@RequestMapping(value = "/customer")
	public String showCumtomer() {
		return "redirect:/customer/list.action";
	}
	
	// �ͻ��б�
	@RequestMapping(value = "/customer/list")
	public String list(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows, 
			String custName, String custSource,	String custIndustry, String custLevel, Model model) {

		Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry,
				custLevel);
		model.addAttribute("page", customers);
		//�ͻ���Դ
		List<BaseDict> fromType = systemService.findBaseDictListByType(FROM_TYPE);
		//�ͻ�������ҵ
		List<BaseDict> industryType = systemService.findBaseDictListByType(INDUSTRY_TYPE);
		//�ͻ�����
		List<BaseDict> levelType = systemService.findBaseDictListByType(LEVEL_TYPE);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		//�������Ե�ҳ��
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		return "customer";
	}
	
	@RequestMapping("/customer/edit")
	@ResponseBody
	public Customer getCustomerById(Long id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	@RequestMapping("/customer/update")
	@ResponseBody
	public String customerUpdate(Customer customer) {
		customerService.updateCustomer(customer);
		return "OK";
	}
	@RequestMapping("/customer/delete")
	@ResponseBody
	public String customerDelete(Long id) {
		customerService.deleteCustomer(id);
		return "OK";
	}
}

