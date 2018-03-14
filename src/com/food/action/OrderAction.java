package com.food.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.food.dao.CustomerDao;
import com.food.dao.FoodDao;
import com.food.dao.OrderDao;
import com.food.model.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class OrderAction extends ActionSupport{
	
	 /*涓氬姟灞傚璞�*/
    @Resource OrderDao orderDao;
    @Resource CustomerDao customerDao;
    @Resource FoodDao foodDao;
    
    private Order order;
    private List<Order> orderList;
    private Customer customer;
    private Food food;
    
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	/*娣诲姞Order*/
	public String addOrder() throws Exception{
		
		customer = customerDao.QueryCustomerInfo(customer.getName()).get(0);
		Order ord =new Order();
		ord.setCustomer(customer);
		ord.setFood(food);
		//鍥犱负鏄�鏉ヤ竴浠解�锛屾墍浠ョ疆涓�
		ord.setFoodnum(1);
		ord.setTotal(foodDao.GetFoodById(food.getFoodid()).getUnitprice()*1);
		orderDao.AddOrder(ord);
		return "order_message";
		
	}
	
	/*鏄剧ず鎵�湁Order*/
    public String showOrder() {
    	
        //灏嗙郴缁熻瀹氫负鐢ㄦ埛鍚嶄笉閲嶅锛屽洜姝ゅ湪绯荤粺涓煡璇㈠埌绗竴涓鍚嶇О鐢ㄦ埛鍗冲彲
    	System.out.println(customer.getName());
        Customer cus= customerDao.QueryCustomerInfo(customer.getName()).get(0);
        //娉ㄦ剰涓嶉渶瑕乫ood鐨勬煡璇㈡潯浠舵椂锛屼笅闈㈣鍙ョ殑鍐欐硶锛岀洿鎺ュ皢food鐨勬潯浠剁疆涓簄ull
        orderList = orderDao.QueryOrderInfo(cus,null);

        return "show_view";
    }

    /*鏄剧ず鏌愪竴Order鐨勮缁嗕俊鎭*/
    public String showDetail() {
    	System.out.print(order.getOrderid());
    	order = orderDao.GetOrderById(order.getOrderid());
        return "detail_view";
    }
    
    /*鏄剧ずOrder鐨勪慨鏀归」*/
    /*public String showEdit() throws Exception {
    	order = orderDao.GetOrderById(order.getOrderid());
        return "edit_view";
    }*/

    /*缂栬緫Order*/
    /*public String editOrder() throws Exception {
    	orderDao.UpdateOrder(order);
        return "edit_message";
    }*/
    
    /*鍒犻櫎Order*/
    /*public String deleteOrder() throws Exception {
    	orderDao.DeleteOrder(food.getFoodid());
        return "delete_message";
    }*/
    
    /*鏌ヨOrder*/
    public String queryOrders() throws Exception {
    	orderList = orderDao.QueryOrderInfo(customer,food);
        return "show_view";
    }


}
