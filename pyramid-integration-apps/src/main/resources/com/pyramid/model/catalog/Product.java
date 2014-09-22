package com.pyramid.model.catalog;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="product")
@XmlRootElement(name="product")
@Cacheable
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="part_id")
	private Integer part_id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="retailPrice")
	private Float retailPrice;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Product_category", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> categories;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPart_id() {
		return part_id;
	}
	public void setPart_id(Integer part_id) {
		this.part_id = part_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Float retailPrice) {
		this.retailPrice = retailPrice;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
