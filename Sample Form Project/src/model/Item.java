package model;

public class Item {

	private int itemCode;
	private String itemName;
	private String unit;
	private int bincardNo;
	private int categoryId;

	public Item(int itemCode, String itemName, String unit, int bincardNo, int categoryId) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.unit = unit;
		this.bincardNo = bincardNo;
		this.categoryId = categoryId;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getBincardNo() {
		return bincardNo;
	}

	public void setBincardNo(int bincardNo) {
		this.bincardNo = bincardNo;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
