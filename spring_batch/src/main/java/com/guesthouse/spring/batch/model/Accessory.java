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
@Table(name = "accessory")
public class Accessory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6762720342742816427L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long no;

	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String md5;

	@Column(nullable = false, columnDefinition = "nvarchar(200)")
	private String id;

	@Column(nullable = false, length = 8)
	private String date;

	@Column(name = "image_url", nullable = true, columnDefinition = "nvarchar(400)")
	private String image;

	@Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String name;

	@Column(nullable = true, columnDefinition = "nvarchar(10)")
	private String level;

	@Column(name = "abyss_point", nullable = true, columnDefinition = "nvarchar(20)")
	private String abyssPoint;

	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String price2;

	@Column(name = "magical_resist", nullable = true, columnDefinition = "nvarchar(20)")
	private String magicalResist;

	@Column(name = "magical_skill_boost_resist", nullable = true, columnDefinition = "nvarchar(10)")
	private String magicalSkillBoostResist;

	@Column(name = "magical_defend", nullable = true, columnDefinition = "nvarchar(10)")
	private int magicalDefend;

	@Column(name = "physical_defend", nullable = true, columnDefinition = "nvarchar(10)")
	private int physicalDefend;

	@Column(nullable = true, columnDefinition = "nvarchar(10)")
	private String parry;

	@Column(nullable = true, columnDefinition = "nvarchar(10)")
	private String block;

	@Column(name = "hit_accuracy", nullable = true, columnDefinition = "nvarchar(10)")
	private String hitAccuracy;

	@Column(nullable = true, columnDefinition = "nvarchar(10)")
	private String dodge;

	@Column(name = "magical_hit_accuracy", nullable = true, columnDefinition = "nvarchar(10)")
	private String magicalHitAccuracy;

	@Column(name = "bonus_attr", nullable = true, columnDefinition = "nvarchar(200)")
	private String bonusAttr;

	@Column(name = "bonus_apply", nullable = true, columnDefinition = "nvarchar(20)")
	private String bonusApply;

	@Column(name = "item_type", nullable = true, columnDefinition = "nvarchar(20)")
	private String itemType;

	@Column(name = "equipment_slots2", nullable = true, columnDefinition = "nvarchar(40)")
	private String equipmentSlots2;

	private int price;

	@Column(columnDefinition = "bit")
	private boolean lore;

	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String quality;

	@Column(name = "can_exchange", nullable = true, columnDefinition = "nvarchar(20)")
	private String canExchange;

	@Column(name = "can_sell_to_npc", nullable = true, columnDefinition = "nvarchar(20)")
	private String canSellToNpc;

	@Column(name = "gender_permitted", nullable = true, columnDefinition = "nvarchar(20)")
	private String genderPermitted;

	@Column(name = "can_deposit_to_character_warehouse", nullable = true, columnDefinition = "nvarchar(20)")
	private boolean canDepositTocharacterWarehouse;

	@Column(name = "can_deposit_to_account_warehouse", nullable = true, columnDefinition = "nvarchar(20)")
	private boolean canDepositToAccountWarehouse;

	@Column(name = "can_deposit_to_guild_warehouse", nullable = true, columnDefinition = "nvarchar(20)")
	private boolean canDepositToGuildWarehouse;

	@Column(columnDefinition = "bit")
	private boolean breakable;

	@Column(name = "soul_bind", columnDefinition = "bit")
	private boolean soulBind;

	@Column(name = "remove_when_logout", columnDefinition = "bit")
	private boolean removeWhenLogout;

	@Column(name = "can_split", nullable = true, columnDefinition = "nvarchar(20)")
	private String canSplit;

	@Column(name = "cash_item", nullable = true, columnDefinition = "nvarchar(20)")
	private String cashItem;

	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String label;

	@Column(name = "cannot_changeskin", nullable = true, columnDefinition = "nvarchar(40)")
	private String cannotChangeskin;

	@Column(name = "acquisition_type", nullable = true, columnDefinition = "nvarchar(8)")
	private String acquisitionType;

	@Column(name = "drop_monster", nullable = true, columnDefinition = "nvarchar(500)")
	private String dropMonster;

	@Column(name = "acquisition_quest", nullable = true, columnDefinition = "nvarchar(300)")
	private String acquisitionQuest;

	@Column(name = "acquisition_race", nullable = true, columnDefinition = "nvarchar(20)")
	private String acquisitionRace;

	@Column(name = "rent_item", nullable = true, columnDefinition = "nvarchar(8)")
	private String rentItem;

	@Column(name = "expire_time", nullable = true, columnDefinition = "nvarchar(8)")
	private String expireTime;
	
	@Column(name = "class_label" , nullable = true, columnDefinition = "nvarchar(50)")
	private String classLabel;

	@Column(name = "level_desc", nullable = true, columnDefinition = "nvarchar(500)")
	private String levelDesc;

	@Column(name = "charge_level", nullable = true, columnDefinition = "nvarchar(1)")
	private String chargeLevel;

	@Column(name = "bonus_attr_a", nullable = true, columnDefinition = "nvarchar(500)")
	private String bonusAttrA;

	@Column(name = "bonus_attr_b", nullable = true, columnDefinition = "nvarchar(500)")
	private String bonusAttrB;

	@Column(name = "trade_in_item", nullable = true, columnDefinition = "nvarchar(200)")
	private String tradeInItem;
	
	@Column(name = "extract_skin_type", nullable = true, columnDefinition = "nvarchar(200)")
	private String extractSkinType;

	@Column(name = "charge_way", nullable = true, columnDefinition = "nvarchar(1)")
	private String chargeWay;

	@Column(name = "charge_limit", nullable = true, columnDefinition = "nvarchar(50)")
	private String chargeLimit;

	@Column(name = "usable_rank_min", nullable = true, columnDefinition = "nvarchar(2)")
	private String usableRankMin;

	@Column(nullable = true, columnDefinition = "nvarchar(50)")
	private String tag;
	
	@Column(name = "random_option_set", nullable = true, columnDefinition = "nvarchar(200)")
	private String randomOptionSet;

	@Column(name = "recommended_rank_desc", nullable = true, columnDefinition = "nvarchar(500)")
	private String recommendRankDesc;

	@Column(name = "charge_level1_rank", nullable = true, columnDefinition = "nvarchar(50)")
	private String chargeLevel1Rank;

	@Column(name = "charge_level2_rank", nullable = true, columnDefinition = "nvarchar(50)")
	private String chargeLevel2Rank;

	@Column(name = "[public]", nullable = true, columnDefinition = "nvarchar(20)")
	private String isPublic;
	
	@Column(name = "desc_long", nullable = true, columnDefinition = "nvarchar(2000)")
	private String descLong;
	
	@Column(name = "activation_skill", nullable = true, columnDefinition = "nvarchar(20)")
	private String activationSkill;
	
	@Column(name = "activation_level", nullable = true, columnDefinition = "nvarchar(20)")
	private String activationLevel;
	
	@Column(name = "equipment_slots", nullable = true, columnDefinition = "nvarchar(20)")
	private String equipmentSlots;
	
	@Column(name = "quest", columnDefinition = "bit")
	private boolean quest;
	
	@Column(name = "pc_light", nullable = true, columnDefinition = "tinyint")
	private int pcLight;
	
	@Column(name = "pc_dark", nullable = true, columnDefinition = "tinyint")
	private int pcDark;
	
	@Column(nullable = true, columnDefinition = "nvarchar(100)")
	private String race;
	
	@Column(name = "cannot_extraction",nullable = true, columnDefinition = "nvarchar(10)")
	private String cannotExtraction;
	
	@Column(name = "extrace_skin_type",nullable = true, columnDefinition = "nvarchar(1)")
	private String extraceSkinType ;
	
	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@PrePersist
	public void prePersist() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date nowDate = new Date();
		this.date = dateFormat.format(nowDate);
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public String getMagicalResist() {
		return magicalResist;
	}

	@XmlElement(name = "magical_resist")
	public void setMagicalResist(String magicalResist) {
		this.magicalResist = magicalResist;
	}

	public String getMagicalSkillBoostResist() {
		return magicalSkillBoostResist;
	}

	@XmlElement(name = "magical_skill_boost_resist")
	public void setMagicalSkillBoostResist(String magicalSkillBoostResist) {
		this.magicalSkillBoostResist = magicalSkillBoostResist;
	}

	public int getMagicalDefend() {
		return magicalDefend;
	}

	@XmlElement(name = "magical_defend")
	public void setMagicalDefend(int magicalDefend) {
		this.magicalDefend = magicalDefend;
	}

	public int getPhysicalDefend() {
		return physicalDefend;
	}

	@XmlElement(name = "physical_defend")
	public void setPhysicalDefend(int physicalDefend) {
		this.physicalDefend = physicalDefend;
	}

	public String getParry() {
		return parry;
	}

	public void setParry(String parry) {
		this.parry = parry;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getHitAccuracy() {
		return hitAccuracy;
	}

	@XmlElement(name = "hit_accuracy")
	public void setHitAccuracy(String hitAccuracy) {
		this.hitAccuracy = hitAccuracy;
	}

	public String getDodge() {
		return dodge;
	}

	public void setDodge(String dodge) {
		this.dodge = dodge;
	}

	public String getMagicalHitAccuracy() {
		return magicalHitAccuracy;
	}

	@XmlElement(name = "magical_hit_accuracy")
	public void setMagicalHitAccuracy(String magicalHitAccuracy) {
		this.magicalHitAccuracy = magicalHitAccuracy;
	}

	public String getBonusAttr() {
		return bonusAttr;
	}

	@XmlElement(name = "bonus_attr")
	public void setBonusAttr(String bonusAttr) {
		this.bonusAttr = bonusAttr;
	}

	public String getBonusApply() {
		return bonusApply;
	}

	@XmlElement(name = "bonus_apply")
	public void setBonusApply(String bonusApply) {
		this.bonusApply = bonusApply;
	}

	public String getItemType() {
		return itemType;
	}

	@XmlElement(name = "item_type")
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getEquipmentSlots2() {
		return equipmentSlots2;
	}

	@XmlElement(name = "equipment_slots2")
	public void setEquipmentSlots2(String equipmentSlots2) {
		this.equipmentSlots2 = equipmentSlots2;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isLore() {
		return lore;
	}

	public void setLore(boolean lore) {
		this.lore = lore;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
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

	public boolean getCanDepositTocharacterWarehouse() {
		return canDepositTocharacterWarehouse;
	}

	@XmlElement(name = "can_deposit_to_character_warehouse")
	public void setCanDepositTocharacterWarehouse(boolean canDepositTocharacterWarehouse) {
		this.canDepositTocharacterWarehouse = canDepositTocharacterWarehouse;
	}

	public boolean getCanDepositToAccountWarehouse() {
		return canDepositToAccountWarehouse;
	}

	@XmlElement(name = "can_deposit_to_account_warehouse")
	public void setCanDepositToAccountWarehouse(boolean canDepositToAccountWarehouse) {
		this.canDepositToAccountWarehouse = canDepositToAccountWarehouse;
	}

	public boolean getCanDepositToGuildWarehouse() {
		return canDepositToGuildWarehouse;
	}

	@XmlElement(name = "can_deposit_to_guild_warehouse")
	public void setCanDepositToGuildWarehouse(boolean canDepositToGuildWarehouse) {
		this.canDepositToGuildWarehouse = canDepositToGuildWarehouse;
	}

	public boolean isBreakable() {
		return breakable;
	}

	public void setBreakable(boolean breakable) {
		this.breakable = breakable;
	}

	public boolean isSoulBind() {
		return soulBind;
	}

	@XmlElement(name = "soul_bind")
	public void setSoulBind(boolean soulBind) {
		this.soulBind = soulBind;
	}

	public boolean isRemoveWhenLogout() {
		return removeWhenLogout;
	}

	@XmlElement(name = "remove_when_logout")
	public void setRemoveWhenLogout(boolean removeWhenLogout) {
		this.removeWhenLogout = removeWhenLogout;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCannotChangeskin() {
		return cannotChangeskin;
	}

	@XmlElement(name = "cannot_changeskin")
	public void setCannotChangeskin(String cannotChangeskin) {
		this.cannotChangeskin = cannotChangeskin;
	}

	public String getAcquisitionType() {
		return acquisitionType;
	}

	@XmlElement(name = "acquisition_type")
	public void setAcquisitionType(String acquisitionType) {
		this.acquisitionType = acquisitionType;
	}

	public String getDropMonster() {
		return dropMonster;
	}

	@XmlElement(name = "drop_monster")
	public void setDropMonster(String dropMonster) {
		this.dropMonster = dropMonster;
	}

	public String getAcquisitionQuest() {
		return acquisitionQuest;
	}

	@XmlElement(name = "acquisition_quest")
	public void setAcquisitionQuest(String acquisitionQuest) {
		this.acquisitionQuest = acquisitionQuest;
	}

	public String getAcquisitionRace() {
		return acquisitionRace;
	}

	@XmlElement(name = "acquisition_race")
	public void setAcquisitionRace(String acquisitionRace) {
		this.acquisitionRace = acquisitionRace;
	}

	public String getRentItem() {
		return rentItem;
	}

	@XmlElement(name = "rent_item")
	public void setRentItem(String rentItem) {
		this.rentItem = rentItem;
	}

	public String getExpireTime() {
		return expireTime;
	}

	@XmlElement(name = "expire_time")
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public String getClassLabel() {
		return classLabel;
	}

	@XmlElement(name = "class_label")
	public void setClassLabel(String classLabel) {
		this.classLabel = classLabel;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	@XmlElement(name = "level_desc")
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

	public String getChargeLevel() {
		return chargeLevel;
	}

	@XmlElement(name = "charge_level")
	public void setChargeLevel(String chargeLevel) {
		this.chargeLevel = chargeLevel;
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

	public String getTradeInItem() {
		return tradeInItem;
	}

	@XmlElement(name = "trade_in_item")
	public void setTradeInItem(String tradeInItem) {
		this.tradeInItem = tradeInItem;
	}

	public String getExtractSkinType() {
		return extractSkinType;
	}

	@XmlElement(name = "extract_skin_type")
	public void setExtractSkinType(String extractSkinType) {
		this.extractSkinType = extractSkinType;
	}

	public String getChargeWay() {
		return chargeWay;
	}

	@XmlElement(name = "charge_way")
	public void setChargeWay(String chargeWay) {
		this.chargeWay = chargeWay;
	}

	public String getChargeLimit() {
		return chargeLimit;
	}

	@XmlElement(name = "charge_limit")
	public void setChargeLimit(String chargeLimit) {
		this.chargeLimit = chargeLimit;
	}

	public String getUsableRankMin() {
		return usableRankMin;
	}

	@XmlElement(name = "usable_rank_min")
	public void setUsableRankMin(String usableRankMin) {
		this.usableRankMin = usableRankMin;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getRandomOptionSet() {
		return randomOptionSet;
	}

	@XmlElement(name = "random_option_set")
	public void setRandomOptionSet(String randomOptionSet) {
		this.randomOptionSet = randomOptionSet;
	}

	public String getRecommendRankDesc() {
		return recommendRankDesc;
	}

	@XmlElement(name = "recommend_rank_desc")
	public void setRecommendRankDesc(String recommendRankDesc) {
		this.recommendRankDesc = recommendRankDesc;
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

	public String getDescLong() {
		return descLong;
	}

	@XmlElement(name = "desc_long")
	public void setDescLong(String descLong) {
		this.descLong = descLong;
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

	public String getEquipmentSlots() {
		return equipmentSlots;
	}

	@XmlElement(name = "equipment_slots")
	public void setEquipmentSlots(String equipmentSlots) {
		this.equipmentSlots = equipmentSlots;
	}

	public boolean isQuest() {
		return quest;
	}

	public void setQuest(boolean quest) {
		this.quest = quest;
	}

	public int getPcLight() {
		return pcLight;
	}

	@XmlElement(name = "pc_light")
	public void setPcLight(int pcLight) {
		this.pcLight = pcLight;
	}

	public int getPcDark() {
		return pcDark;
	}

	@XmlElement(name = "pc_dark")
	public void setPcDark(int pcDark) {
		this.pcDark = pcDark;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getCannotExtraction() {
		return cannotExtraction;
	}

	@XmlElement(name = "cannot_extraction")
	public void setCannotExtraction(String cannotExtraction) {
		this.cannotExtraction = cannotExtraction;
	}

	public String getExtraceSkinType() {
		return extraceSkinType;
	}

	@XmlElement(name = "extrace_skin_type")
	public void setExtraceSkinType(String extraceSkinType) {
		this.extraceSkinType = extraceSkinType;
	}
	
	

	@Override
	public String toString() {
		return "Accessory [md5=" + md5 + ", id=" + id + ", date=" + date + ", image=" + image + ", name=" + name
			+ ", level=" + level + ", abyssPoint=" + abyssPoint + ", price2=" + price2 + ", magicalResist="
			+ magicalResist + ", magicalSkillBoostResist=" + magicalSkillBoostResist + ", magicalDefend="
			+ magicalDefend + ", physicalDefend=" + physicalDefend + ", parry=" + parry + ", block=" + block
			+ ", hitAccuracy=" + hitAccuracy + ", dodge=" + dodge + ", magicalHitAccuracy=" + magicalHitAccuracy
			+ ", bonusAttr=" + bonusAttr + ", bonusApply=" + bonusApply + ", itemType=" + itemType
			+ ", equipmentSlots2=" + equipmentSlots2 + ", price=" + price + ", lore=" + lore + ", quality=" + quality
			+ ", canExchange=" + canExchange + ", canSellToNpc=" + canSellToNpc + ", genderPermitted="
			+ genderPermitted + ", canDepositTocharacterWarehouse=" + canDepositTocharacterWarehouse
			+ ", canDepositToAccountWarehouse=" + canDepositToAccountWarehouse + ", canDepositToGuildWarehouse="
			+ canDepositToGuildWarehouse + ", breakable=" + breakable + ", soulBind=" + soulBind
			+ ", removeWhenLogout=" + removeWhenLogout + ", canSplit=" + canSplit + ", cashItem=" + cashItem
			+ ", label=" + label + ", cannotChangeskin=" + cannotChangeskin + ", acquisitionType=" + acquisitionType
			+ ", dropMonster=" + dropMonster + ", acquisitionQuest=" + acquisitionQuest + ", acquisitionRace="
			+ acquisitionRace + ", rentItem=" + rentItem + ", expireTime=" + expireTime + ", classLabel=" + classLabel
			+ ", levelDesc=" + levelDesc + ", chargeLevel=" + chargeLevel + ", bonusAttrA=" + bonusAttrA
			+ ", bonusAttrB=" + bonusAttrB + ", tradeInItem=" + tradeInItem + ", extractSkinType=" + extractSkinType
			+ ", chargeWay=" + chargeWay + ", chargeLimit=" + chargeLimit + ", usableRankMin=" + usableRankMin
			+ ", tag=" + tag + ", randomOptionSet=" + randomOptionSet + ", recommendRankDesc=" + recommendRankDesc
			+ ", chargeLevel1Rank=" + chargeLevel1Rank + ", chargeLevel2Rank=" + chargeLevel2Rank + ", isPublic="
			+ isPublic + ", descLong=" + descLong + ", activationSkill=" + activationSkill + ", activationLevel="
			+ activationLevel + ", equipmentSlots=" + equipmentSlots + ", quest=" + quest + ", pcLight=" + pcLight
			+ ", pcDark=" + pcDark + ", race=" + race + ", cannotExtraction=" + cannotExtraction + ", extraceSkinType="
			+ extraceSkinType + "]";
	}


}
