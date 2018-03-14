package com.food.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;  
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.food.dao.CustomerDao;
import com.food.model.Customer;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class CustomerAction extends ActionSupport implements SessionAware{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*涓氬姟灞傚璞*/
    @Resource CustomerDao customerDao;
    
    private Customer customer;
    
    //杩欎袱涓垚鍛樺彉閲忔槸鐢ㄦ潵鍋氱櫥褰曟嫤鎴殑锛岃寰楁坊鍔爏etter鍜実etter
    
	private Map<String,Object> session;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	
	private String errMessage;
	
	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	/*
	public String reg() throws Exception{
		customerDao.AddCustomer(customer);
		session.put("curCustomer", customer);
		return "show_view";
		
	}*/
	
    //娉ㄥ唽锛屽苟鍦╯ession涓姞鍏ョ敤鎴峰悕
	public String reg() throws Exception{
		customerDao.AddCustomer(customer);
		session.put("customer", customer);
		return "show_view";

	}
    
	/* 楠岃瘉鐢ㄦ埛鐧诲綍 */
	/*public String login() {
		Customer db_customer = (Customer)customerDao.QueryCustomerInfo(customer.getName()).get(0);
		if(db_customer == null) { 
			
			this.errMessage = " 璐﹀彿涓嶅瓨鍦�";
			System.out.print(this.errMessage);
			return INPUT;
			
		} else if( !db_customer.getPassword().equals(customer.getPassword())) {
			
			this.errMessage = " 瀵嗙爜涓嶆纭� ";
			System.out.print(this.errMessage);
			return INPUT;
			
		}else{
			return "show_view";
			
		}	*/	

	
		/* 楠岃瘉鐢ㄦ埛鐧诲綍 */
		public String login() {
			
			ArrayList<Customer> listCustomer = customerDao.QueryCustomerInfo(customer.getName());
			if(listCustomer.size()==0) { 
				
				this.errMessage = " 璐﹀彿涓嶅瓨鍦�";
				System.out.print(this.errMessage);
				return "input";
				
			} 
			else{
				
			    Customer db_customer = listCustomer.get(0);
				if(!db_customer.getPassword().equals(customer.getPassword())) {
				
					this.errMessage = " 瀵嗙爜涓嶆纭� ";
					System.out.print(this.errMessage);
					return "input";
				
			    }else{
				
					session.put("customer", db_customer);
					return "success";
			    }
			}
		}


}
