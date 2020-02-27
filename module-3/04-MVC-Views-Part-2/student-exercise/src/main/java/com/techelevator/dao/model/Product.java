package com.techelevator.dao.model;

public class Product {
	private double averageRating;
	private int categoryId;
	private String description;
	private int id;
	private String imageName;
	private String name;
	private double price;
	private int remainingStock;
	private boolean topSeller;
	private double weightInLbs;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public double getWeightInLbs() {
		return weightInLbs;
	}

	public void setWeightInLbs(double weightInLbs) {
		this.weightInLbs = weightInLbs;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public int getRemainingStock() {
		return remainingStock;
	}

	public void setRemainingStock(int remainingStock) {
		this.remainingStock = remainingStock;
	}

	public boolean isTopSeller() {
		return topSeller;
	}

	public void setTopSeller(boolean topSeller) {
		this.topSeller = topSeller;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageRating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + categoryId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((imageName == null) ? 0 : imageName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + remainingStock;
		result = prime * result + (topSeller ? 1231 : 1237);
		temp = Double.doubleToLongBits(weightInLbs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Double.doubleToLongBits(averageRating) != Double.doubleToLongBits(other.averageRating))
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (imageName == null) {
			if (other.imageName != null)
				return false;
		} else if (!imageName.equals(other.imageName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (remainingStock != other.remainingStock)
			return false;
		if (topSeller != other.topSeller)
			return false;
		if (Double.doubleToLongBits(weightInLbs) != Double.doubleToLongBits(other.weightInLbs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [categoryId=" + categoryId + ", id=" + id + ", name=" + name + ", imageName=" + imageName
				+ ", weightInLbs=" + weightInLbs + ", price=" + price + ", averageRating=" + averageRating
				+ ", remainingStock=" + remainingStock + ", topSeller=" + topSeller + ", description=" + description
				+ "]";
	}
}
