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
 * Food entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_customer", catalog = "food")
public class Food implements java.io.Serializable {

	// Fields

	private Integer customerid;
	private String name;
	private String address;
	private String password;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Order> orders_1 = new HashSet<Order>(0);

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(String name, String address, String password) {
		this.name = name;
		this.address = address;
		this.password = password;
	}

	/** full constructor */
	public Food(String name, String address, String password,
			Set<Order> orders, Set<Order> orders_1) {
		this.name = name;
		this.address = address;
		this.password = password;
		this.orders = orders;
		this.orders_1 = orders_1;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "customerid", unique = true, nullable = false)
	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", nullable = false, length = 40)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "food")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "food")
	public Set<Order> getOrders_1() {
		return this.orders_1;
	}

	public void setOrders_1(Set<Order> orders_1) {
		this.orders_1 = orders_1;
	}

}