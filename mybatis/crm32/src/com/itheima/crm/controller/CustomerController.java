package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;

/**
 * 客户管理
 * @author dengting
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customer/list")
	public String list(QueryVo qv,Model model){
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		Page<Customer> page = customerService.selectPageByQueryVo(qv);
		model.addAttribute("page", page);
		model.addAttribute("custName",qv.getCustName());
		model.addAttribute("custSource", qv.getCustSource());
		model.addAttribute("custIndustry", qv.getCustIndustry());
		model.addAttribute("custLevel", qv.getCustLevel());
		return "customer";
	}
	
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody Customer edit(Integer id){
		return customerService.selectCustomerById(id);
		
	}
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "ok";
		
	}
	@RequestMapping(value="/customer/delete.action")
	public @ResponseBody String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "ok";
		
	}
}
