package com.food.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_food", catalog = "food")
public class Customer implements java.io.Serializable {

	// Fields

	private Integer foodid;
	private String foodname;
	private Double unitprice;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Order> orders_1 = new HashSet<Order>(0);

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String foodname, Double unitprice, Set<Order> orders,
			Set<Order> orders_1) {
		this.foodname = foodname;
		this.unitprice = unitprice;
		this.orders = orders;
		this.orders_1 = orders_1;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "foodid", unique = true, nullable = false)
	public Integer getFoodid() {
		return this.foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	@Column(name = "foodname", length = 40)
	public String getFoodname() {
		return this.foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	@Column(name = "unitprice", precision = 22, scale = 0)
	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Order> getOrders_1() {
		return this.orders_1;
	}

	public void setOrders_1(Set<Order> orders_1) {
		this.orders_1 = orders_1;
	}

}