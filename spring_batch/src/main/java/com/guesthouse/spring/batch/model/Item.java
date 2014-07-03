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

@XmlRootElement(name = "item")
@Entity
@Table(name = "etc")
public class Item implements Serializable {

	private static final long serialVersionUID = -8886199720000049703L;

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

	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String label;

	@Column(nullable = true, columnDefinition = "nvarchar(10)")
	private String level;

	@Column(name = "desc_long", nullable = true, columnDefinition = "nvarchar(2000)")
	private String descLong;

	private int price;

	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String quality;

	@Column(columnDefinition = "bit")
	private boolean lore;

	@Column(name = "can_exchange", nullable = true, columnDefinition = "nvarchar(20)")
	private String canExchange;

	@Column(name = "can_sell_to_npc", nullable = true, columnDefinition = "nvarchar(20)")
	private String canSellToNpc;

	@Column(name = "gender_permitted", nullable = true, columnDefinition = "nvarchar(20)")
	private String genderPermitted;

	@Column(name = "can_deposit_to_character_warehouse", nullable = true, columnDefinition = "nvarchar(20)")
	private String canDepositTocharacterWarehouse;

	@Column(name = "can_deposit_to_account_warehouse", nullable = true, columnDefinition = "nvarchar(20)")
	private String canDepositToAccountWarehouse;

	@Column(name = "can_deposit_to_guild_warehouse", nullable = true, columnDefinition = "nvarchar(20)")
	private String canDepositToGuildWarehouse;

	@Column(columnDefinition = "bit")
	private boolean breakable;

	@Column(name = "soul_bind", columnDefinition = "bit")
	private boolean soulBind;

	@Column(name = "remove_when_logout", columnDefinition = "bit")
	private boolean removeWhenLogout;

	@Column(name = "race_permitted", nullable = true, columnDefinition = "nvarchar(40)")
	private String racePermitted;

	@Column(columnDefinition = "bit")
	private boolean quest;

	@Column(name = "item_type", nullable = true, columnDefinition = "nvarchar(20)")
	private String itemType;

	@Column(name = "equipment_slots", nullable = true, columnDefinition = "nvarchar(100)")
	private String equipmentSlots;

	@Column(name = "bonus_apply", nullable = true, columnDefinition = "nvarchar(20)")
	private String bonusApply;

	@Column(name = "can_split", nullable = true, columnDefinition = "nvarchar(20)")
	private String canSplit;

	@Column(name = "cash_item", nullable = true, columnDefinition = "nvarchar(20)")
	private String cashItem;

	@Column(name = "activation_skill", nullable = true, columnDefinition = "nvarchar(100)")
	private String activationSkill;

	@Column(name = "activation_level", nullable = true, columnDefinition = "nvarchar(100)")
	private String activationLevel;

	@Column(nullable = true, columnDefinition = "nvarchar(40)")
	private String attribute;

	@Column(name = "bonus_attr", nullable = true, columnDefinition = "nvarchar(500)")
	private String bonusAttr;

	@Column(name = "abyss_point", nullable = true, columnDefinition = "nvarchar(20)")
	private String abyssPoint;

	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String price2;

	@Column(name = "can_buy_from_npc", nullable = true, columnDefinition = "nvarchar(10)")
	private String canBuyFromNpc;

	@Column(name = "craft_recipe_info")
	private String craftRecipeInfo;

	@Column(name = "level_desc", nullable = true, columnDefinition = "nvarchar(500)")
	private String levelDesc;

	@Column(name = "use_delay", nullable = true)
	private String useDelay;

	@Column(nullable = true, columnDefinition = "nvarchar(50)")
	private String tag;
	
	@Column(name = "extra_inventory", nullable = true, columnDefinition = "nvarchar(5)")
	private String extraInventory;
	
	@Column(name = "polish_set_name", nullable = true, columnDefinition = "nvarchar(100)")
	private String polishSetName;

	@Column(name = "[public]", nullable = true, columnDefinition = "nvarchar(20)")
	private String isPublic;
	
	@Column(name = "bonus_attr_a", nullable = true, columnDefinition = "nvarchar(500)")
	private String bonusAttrA;

	@Column(name = "bonus_attr_b", nullable = true, columnDefinition = "nvarchar(500)")
	private String bonusAttrB;
	
	@Column(name = "charge_level", nullable = true, columnDefinition = "nvarchar(1)")
	private String chargeLevel;
	
	@Column(name = "charge_level_1_rank", nullable = true, columnDefinition = "nvarchar(50)")
	private String chargeLevel1Rank;
	
	@Column(name = "charge_level_2_rank", nullable = true, columnDefinition = "nvarchar(50)")
	private String chargeLevel2Rank;
	
	@Column(name = "charge_limit", nullable = true, columnDefinition = "nvarchar(50)")
	private String chargeLimit;
	
	@Column(name = "charge_way", nullable = true, columnDefinition = "nvarchar(1)")
	private String chargeWay;
	
	@Column(name = "recommend_rank_desc", nullable = true, columnDefinition = "nvarchar(500)")
	private String recommendRankDesc;
	
	@Column(name = "usable_rank_min", nullable = true, columnDefinition = "nvarchar(2)")
	private String usableRankMin;
	
	@Column(name = "usable_rank_min_desc", nullable = true, columnDefinition = "nvarchar(255)")
	private String usableRankMinDesc;	
	
	public Long getNo() {
		return no;
	}

	public void setId(Long no) {
		this.no = no;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
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

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public boolean getLore() {
		return lore;
	}

	public void setLore(boolean lore) {
		this.lore = lore;
	}

	public String getCanExchange() {
		return canExchange;
	}

	@XmlElement(name = "can_exchange")
	public void setCanExchange(String canExchange) {
		this.canExchange = canExchange;
	}

	public String getCanSellToNpc() {
		return canSellToNpc;
	}

	@XmlElement(name = "can_sell_to_npc")
	public void setCanSellToNpc(String canSellToNpc) {
		this.canSellToNpc = canSellToNpc;
	}

	public String getGenderPermitted() {
		return genderPermitted;
	}

	@XmlElement(name = "gender_permitted")
	public void setGenderPermitted(String genderPermitted) {
		this.genderPermitted = genderPermitted;
	}

	public String getCanDepositTocharacterWarehouse() {
		return canDepositTocharacterWarehouse;
	}

	@XmlElement(name = "can_deposit_to_character_warehouse")
	public void setCanDepositTocharacterWarehouse(String canDepositTocharacterWarehouse) {
		this.canDepositTocharacterWarehouse = canDepositTocharacterWarehouse;
	}

	public String getCanDepositToAccountWarehouse() {
		return canDepositToAccountWarehouse;
	}

	@XmlElement(name = "can_deposit_to_account_warehouse")
	public void setCanDepositToAccountWarehouse(String canDepositToAccountWarehouse) {
		this.canDepositToAccountWarehouse = canDepositToAccountWarehouse;
	}

	public String getCanDepositToGuildWarehouse() {
		return canDepositToGuildWarehouse;
	}

	@XmlElement(name = "can_deposit_to_guild_warehouse")
	public void setCanDepositToGuildWarehouse(String canDepositToGuildWarehouse) {
		this.canDepositToGuildWarehouse = canDepositToGuildWarehouse;
	}

	public boolean getBreakable() {
		return breakable;
	}

	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}

	public boolean getSoulBind() {
		return soulBind;
	}

	@XmlElement(name = "soul_bind")
	public void setSoulBind(boolean soulBind) {
		this.soulBind = soulBind;
	}

	public boolean getRemoveWhenLogout() {
		return removeWhenLogout;
	}

	@XmlElement(name = "remove_when_logout")
	public void setRemoveWhenLogout(boolean removeWhenLogout) {
		this.removeWhenLogout = removeWhenLogout;
	}

	public String getRacePermitted() {
		return racePermitted;
	}

	@XmlElement(name = "race_permitted")
	public void setRacePermitted(String racePermitted) {
		this.racePermitted = racePermitted;
	}

	public boolean getQuest() {
		return quest;
	}

	public void setQuest(boolean quest) {
		this.quest = quest;
	}

	public String getItemType() {
		return itemType;
	}

	@XmlElement(name = "item_type")
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getEquipmentSlots() {
		return equipmentSlots;
	}

	@XmlElement(name = "equipment_slots")
	public void setEquipmentSlots(String equipmentSlots) {
		this.equipmentSlots = equipmentSlots;
	}

	public String getBonusApply() {
		return bonusApply;
	}

	@XmlElement(name = "bonus_apply")
	public void setBonusApply(String bonusApply) {
		this.bonusApply = bonusApply;
	}

	public String getCanSplit() {
		return canSplit;
	}

	@XmlElement(name = "can_split")
	public void setCanSplit(String canSplit) {
		this.canSplit = canSplit;
	}

	public String getCashItem() {
		return cashItem;
	}

	@XmlElement(name = "cash_item")
	public void setCashItem(String cashItem) {
		this.cashItem = cashItem;
	}

	public String getActivationSkill() {
		return activationSkill;
	}

	@XmlElement(name = "activation_skill")
	public void setActivationSkill(String activationSkill) {
		this.activationSkill = activationSkill;
	}

	public String getActivationLevel() {
		return activationLevel;
	}

	@XmlElement(name = "activation_level")
	public void setActivationLevel(String activationLevel) {
		this.activationLevel = activationLevel;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getBonusAttr() {
		return bonusAttr;
	}

	@XmlElement(name = "bonus_attr")
	public void setBonusAttr(String bonusAttr) {
		this.bonusAttr = bonusAttr;
	}

	public String getAbyssPoint() {
		return abyssPoint;
	}

	@XmlElement(name = "abyss_point")
	public void setAbyssPoint(String abyssPoint) {
		this.abyssPoint = abyssPoint;
	}

	public String getPrice2() {
		return price2;
	}

	public void setPrice2(String price2) {
		this.price2 = price2;
	}

	public String getCanBuyFromNpc() {
		return canBuyFromNpc;
	}

	@XmlElement(name = "can_buy_from_npc")
	public void setCanBuyFromNpc(String canBuyFromNpc) {
		this.canBuyFromNpc = canBuyFromNpc;
	}

	public String getCraftRecipeInfo() {
		return craftRecipeInfo;
	}

	@XmlElement(name = "craft_recipe_info")
	public void setCraftRecipeInfo(String craftRecipeInfo) {
		this.craftRecipeInfo = craftRecipeInfo;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	@XmlElement(name = "level_desc")
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public String getUseDelay() {
		return useDelay;
	}

	@XmlElement(name = "use_delay")
	public void setUseDelay(String useDelay) {
		this.useDelay = useDelay;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	
	public String getExtraInventory() {
		return extraInventory;
	}

	@XmlElement(name = "extra_inventory")
	public void setExtraInventory(String extraInventory) {
		this.extraInventory = extraInventory;
	}

	public String getPolishSetName() {
		return polishSetName;
	}

	@XmlElement(name = "polish_set_name")
	public void setPolishSetName(String polishSetName) {
		this.polishSetName = polishSetName;
	}

	public String getIsPublic() {
		return isPublic;
	}

	@XmlElement(name = "public")
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
	
	public String getBonusAttrA() {
		return bonusAttrA;
	}

	@XmlElement(name = "bonus_attr_a")
	public void setBonusAttrA(String bonusAttrA) {
		this.bonusAttrA = bonusAttrA;
	}

	public String getBonusAttrB() {
		return bonusAttrB;
	}

	@XmlElement(name = "bonus_attr_b")
	public void setBonusAttrB(String bonusAttrB) {
		this.bonusAttrB = bonusAttrB;
	}

	public String getChargeLevel() {
		return chargeLevel;
	}

	@XmlElement(name = "charge_level")
	public void setChargeLevel(String chargeLevel) {
		this.chargeLevel = chargeLevel;
	}

	public String getChargeLevel1Rank() {
		return chargeLevel1Rank;
	}

	@XmlElement(name = "charge_level_1_rank")
	public void setChargeLevel1Rank(String chargeLevel1Rank) {
		this.chargeLevel1Rank = chargeLevel1Rank;
	}

	public String getChargeLevel2Rank() {
		return chargeLevel2Rank;
	}

	@XmlElement(name = "charge_level_2_rank")
	public void setChargeLevel2Rank(String chargeLevel2Rank) {
		this.chargeLevel2Rank = chargeLevel2Rank;
	}

	public String getChargeLimit() {
		return chargeLimit;
	}

	@XmlElement(name = "charge_limit")
	public void setChargeLimit(String chargeLimit) {
		this.chargeLimit = chargeLimit;
	}

	public String getChargeWay() {
		return chargeWay;
	}

	@XmlElement(name = "charge_way")
	public void setChargeWay(String chargeWay) {
		this.chargeWay = chargeWay;
	}

	public String getRecommendRankDesc() {
		return recommendRankDesc;
	}

	@XmlElement(name = "recommend_rank_desc")
	public void setRecommendRankDesc(String recommendRankDesc) {
		this.recommendRankDesc = recommendRankDesc;
	}

	public String getUsableRankMin() {
		return usableRankMin;
	}

	@XmlElement(name = "usable_rank_min")
	public void setUsableRankMin(String usableRankMin) {
		this.usableRankMin = usableRankMin;
	}

	public String getUsableRankMinDesc() {
		return usableRankMinDesc;
	}

	@XmlElement(name = "usable_rank_min_desc")
	public void setUsableRankMinDesc(String usableRankMinDesc) {
		this.usableRankMinDesc = usableRankMinDesc;
	}

	@PrePersist
	public void prePersist() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date nowDate = new Date();
		this.date = dateFormat.format(nowDate);
	}

	@Override
	public String toString() {
		return "Item [md5=" + md5 + ", date=" + date + ", id=" + id + ", image=" + image + ", name=" + name
			+ ", label=" + label + ", level=" + level + ", descLong=" + descLong + ", price=" + price + ", quality="
			+ quality + ", lore=" + lore + ", canExchange=" + canExchange + ", canSellToNpc=" + canSellToNpc
			+ ", genderPermitted=" + genderPermitted + ", canDepositTocharacterWarehouse="
			+ canDepositTocharacterWarehouse + ", canDepositToAccountWarehouse=" + canDepositToAccountWarehouse
			+ ", canDepositToGuildWarehouse=" + canDepositToGuildWarehouse + ", breakable=" + breakable + ", soulBind="
			+ soulBind + ", removeWhenLogout=" + removeWhenLogout + ", racePermitted=" + racePermitted + ", quest="
			+ quest + ", itemType=" + itemType + ", equipmentSlots=" + equipmentSlots + ", bonusApply=" + bonusApply
			+ ", canSplit=" + canSplit + ", cashItem=" + cashItem + ", activationSkill=" + activationSkill
			+ ", activationLevel=" + activationLevel + ", attribute=" + attribute + ", bonusAttr=" + bonusAttr
			+ ", abyssPoint=" + abyssPoint + ", price2=" + price2 + ", canBuyFromNpc=" + canBuyFromNpc
			+ ", craftRecipeInfo=" + craftRecipeInfo + ", levelDesc=" + levelDesc + ", useDelay=" + useDelay + ", tag="
			+ tag + ", extraInventory=" + extraInventory + ", polishSetName=" + polishSetName + ", isPublic="
			+ isPublic + ", bonusAttrA=" + bonusAttrA + ", bonusAttrB=" + bonusAttrB + ", chargeLevel=" + chargeLevel
			+ ", chargeLevel1Rank=" + chargeLevel1Rank + ", chargeLevel2Rank=" + chargeLevel2Rank + ", chargeLimit="
			+ chargeLimit + ", chargeWay=" + chargeWay + ", recommendRankDesc=" + recommendRankDesc
			+ ", usableRankMin=" + usableRankMin + ", usableRankMinDesc=" + usableRankMinDesc + "]";
	}

}
