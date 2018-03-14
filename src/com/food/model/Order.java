package com.food.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_order", catalog = "food")
public class Order implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private Food food;
	private Customer customer;
	private Integer foodnum;
	private Double total;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Customer customer) {
		this.customer = customer;
	}

	/** full constructor */
	public Order(Food food, Customer customer, Integer foodnum, Double total) {
		this.food = food;
		this.customer = customer;
		this.foodnum = foodnum;
		this.total = total;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "orderid", unique = true, nullable = false)
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer")
	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "food", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "foodnum")
	public Integer getFoodnum() {
		return this.foodnum;
	}

	public void setFoodnum(Integer foodnum) {
		this.foodnum = foodnum;
	}

	@Column(name = "total", precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}