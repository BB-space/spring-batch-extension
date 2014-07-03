package com.guesthouse.spring.batch.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "unifyitem")
@XmlRootElement(name = "item")

public class UnifyItem implements Serializable {

	private static final long serialVersionUID = -6171671448974997430L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long no;

	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String md5;

	@Column(nullable = false, length = 8)
	private String date;

	@Column(name = "id", nullable = false, columnDefinition = "nvarchar(400)")
	private String id;

	@Column(name = "image_url", nullable = false, columnDefinition = "nvarchar(400)")
	private String image;

	@Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String name;

	@Column(nullable = true)
	private int level;

	@Column(name = "desc_long", nullable = true, columnDefinition = "nvarchar(2000)")
	private String descLong;
	
	private int price;
	
	@Column(name = "item_category", nullable = true, columnDefinition = "nvarchar(20)")
	private String itemCateogry;
	
	@Column(nullable = true, columnDefinition = "nvarchar(20)")
	private String quality;
	
	@Column(name = "quality_order", nullable = true)
	private int qualityOrder;	

	@Column(name = "bonus_attr", nullable = true, columnDefinition = "nvarchar(500)")
	private String bonusAttr;
	
	@Column(name = "level_desc", nullable = true, columnDefinition = "nvarchar(500)")
	private String levelDesc;
	
	@Column(name ="replace_name", nullable = true, columnDefinition = "nvarchar(100)")
	private String replaceName;
/*	
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_name",referencedColumnName="replace_name", insertable=false, updatable=false)
	private List<MakeItem> makeItem;
	
	public List<MakeItem> getMakeItem() {
		return makeItem;
	}

	public void setMakeItem(List<MakeItem> makeItem) {
		this.makeItem = makeItem;
	}*/

	@PrePersist
	public void prePersist() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date nowDate = new Date();
		this.date = dateFormat.format(nowDate);
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getDescLong() {
		return descLong;
	}

	@XmlElement(name = "desc_long")
	public void setDescLong(String descLong) {
		this.descLong = descLong;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItemCateogry() {
		return itemCateogry;
	}


	public void setItemCateogry(String itemCateogry) {
		this.itemCateogry = itemCateogry;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public int getQualityOrder() {
		return qualityOrder;
	}
	
	public void setQualityOrder(int qualityOrder) {
		this.qualityOrder = qualityOrder;
	}
	
	public String getBonusAttr() {
		return bonusAttr;
	}

	@XmlElement(name = "bonus_attr")
	public void setBonusAttr(String bonusAttr) {
		this.bonusAttr = bonusAttr;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	@XmlElement(name = "level_desc")
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public String getReplaceName() {
		return replaceName;
	}

	public void setReplaceName(String replaceName) {
		this.replaceName = replaceName;
	}

	@Override
	public String toString() {
		return "UnifyItem [md5=" + md5 + ", date=" + date + ", id=" + id + ", image=" + image + ", name=" + name
			+ ", level=" + level + ", descLong=" + descLong + ", price=" + price + ", itemCateogry=" + itemCateogry
			+ ", quality=" + quality + ", qualityOrder=" + qualityOrder + ", bonusAttr=" + bonusAttr + ", levelDesc="
			+ levelDesc + ", replaceName=" + replaceName + "]";
	}
	
	
}
