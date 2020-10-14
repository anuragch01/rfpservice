package com.bettaway.rfp.modal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author Home
 *
 */
public class PostLoad {

	/**
	 * Metadata info
	 */
	@Id
	String id;
	ObjectId userId;
	ObjectId buyerId;
	Long authId;
	Long createdAtUTC;
	Long updatedAtUTC;
	Long bidCloseTimeUTC;

	/**
	 * State info
	 */
	String title;
	String shipperName;
	Address shippingAddress;
	String commodity;
	String grade;
	Integer quantity;
	Integer lots;
	String dropLive;
	LocalDateTime bidCloseTime;
	LocalDate requestDeliveryDate;
	LocalTime appt1;
	LocalTime deliveryWindowBegin;
	LocalTime deliveryWindowEnd;
	LocalTime appt2;
	String clientTimeZoneId;
	/**
	 * FLAT_BED, VAN, NO_PREFERENCES
	 */
	String preferences;
	String notes;
	String postingMethod;
	List<String> listGroupId;
	List<String> listSellerId;
	String bidAcceptanceMethod;
	Double basePrice;
	Boolean displayCostToMarketPrice;
	String status;

	public String getShipperName() {
		return shipperName;
	}

	public String getCommodity() {
		return commodity;
	}

	public String getGrade() {
		return grade;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getLots() {
		return lots;
	}

	public String getDropLive() {
		return dropLive;
	}

	public LocalDate getRequestDeliveryDate() {
		return requestDeliveryDate;
	}

	public LocalTime getAppt1() {
		return appt1;
	}

	public LocalTime getDeliveryWindowBegin() {
		return deliveryWindowBegin;
	}

	public LocalTime getDeliveryWindowEnd() {
		return deliveryWindowEnd;
	}

	public LocalTime getAppt2() {
		return appt2;
	}

	public String getClientTimeZoneId() {
		return clientTimeZoneId;
	}

	public String getPreferences() {
		return preferences;
	}

	public String getNotes() {
		return notes;
	}

	public String getId() {
		return id;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public ObjectId getBuyerId() {
		return buyerId;
	}

	public Long getAuthId() {
		return authId;
	}

	public Long getCreatedAtUTC() {
		return createdAtUTC;
	}

	public Long getUpdatedAtUTC() {
		return updatedAtUTC;
	}

	public Long getBidCloseTimeUTC() {
		return bidCloseTimeUTC;
	}

	public String getTitle() {
		return title;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public LocalDateTime getBidCloseTime() {
		return bidCloseTime;
	}

	public String getPostingMethod() {
		return postingMethod;
	}

	public String getBidAcceptanceMethod() {
		return bidAcceptanceMethod;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public Boolean getDisplayCostToMarketPrice() {
		return displayCostToMarketPrice;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}

	public void setBuyerId(ObjectId buyerId) {
		this.buyerId = buyerId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public void setCreatedAtUTC(Long createdAtUTC) {
		this.createdAtUTC = createdAtUTC;
	}

	public void setUpdatedAtUTC(Long updatedAtUTC) {
		this.updatedAtUTC = updatedAtUTC;
	}

	public void setBidCloseTimeUTC(Long bidCloseTimeUTC) {
		this.bidCloseTimeUTC = bidCloseTimeUTC;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void setBidCloseTime(LocalDateTime bidCloseTime) {
		this.bidCloseTime = bidCloseTime;
	}

	public void setPostingMethod(String postingMethod) {
		this.postingMethod = postingMethod;
	}

	public List<String> getListGroupId() {
		return listGroupId;
	}

	public List<String> getListSellerId() {
		return listSellerId;
	}

	public void setListGroupId(List<String> listGroupId) {
		this.listGroupId = listGroupId;
	}

	public void setListSellerId(List<String> listSellerId) {
		this.listSellerId = listSellerId;
	}

	public void setBidAcceptanceMethod(String bidAcceptanceMethod) {
		this.bidAcceptanceMethod = bidAcceptanceMethod;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public void setDisplayCostToMarketPrice(Boolean displayCostToMarketPrice) {
		this.displayCostToMarketPrice = displayCostToMarketPrice;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setLots(Integer lots) {
		this.lots = lots;
	}

	public void setDropLive(String dropLive) {
		this.dropLive = dropLive;
	}

	public void setRequestDeliveryDate(LocalDate requestDeliveryDate) {
		this.requestDeliveryDate = requestDeliveryDate;
	}

	public void setAppt1(LocalTime appt1) {
		this.appt1 = appt1;
	}

	public void setDeliveryWindowBegin(LocalTime deliveryWindowBegin) {
		this.deliveryWindowBegin = deliveryWindowBegin;
	}

	public void setDeliveryWindowEnd(LocalTime deliveryWindowEnd) {
		this.deliveryWindowEnd = deliveryWindowEnd;
	}

	public void setAppt2(LocalTime appt2) {
		this.appt2 = appt2;
	}

	public void setClientTimeZoneId(String clientTimeZoneId) {
		this.clientTimeZoneId = clientTimeZoneId;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static Builder createBuilder() {
		return new Builder();
	}

	public static Builder updateBuilder(PostLoad postLoad) {
		return new Builder(postLoad);
	}

	public static class Builder {
		PostLoad postLoad;

		public Builder() {
			this.postLoad = new PostLoad();
		}

		public Builder(PostLoad postLoad) {
			super();
			this.postLoad = postLoad;
		}

		public Builder setShipperName(String shipperName) {
			postLoad.shipperName = shipperName;
			return this;
		}

		public Builder setCommodity(String commodity) {
			postLoad.commodity = commodity;
			return this;
		}

		public Builder setGrade(String grade) {
			postLoad.grade = grade;
			return this;
		}

		public Builder setQuantity(Integer quantity) {
			postLoad.quantity = quantity;
			return this;
		}

		public Builder setLots(Integer lots) {
			postLoad.lots = lots;
			return this;
		}

		public Builder setDropLive(String dropLive) {
			postLoad.dropLive = dropLive;
			return this;
		}

		public Builder setRequestDeliveryDate(LocalDate requestDeliveryDate) {
			postLoad.requestDeliveryDate = requestDeliveryDate;
			return this;
		}

		public Builder setAppt1(LocalTime appt1) {
			postLoad.appt1 = appt1;
			return this;
		}

		public Builder setDeliveryWindowBegin(LocalTime deliveryWindowBegin) {
			postLoad.deliveryWindowBegin = deliveryWindowBegin;
			return this;
		}

		public Builder setDeliveryWindowEnd(LocalTime deliveryWindowEnd) {
			postLoad.deliveryWindowEnd = deliveryWindowEnd;
			return this;
		}

		public Builder setAppt2(LocalTime appt2) {
			postLoad.appt2 = appt2;
			return this;
		}

		public Builder setClientTimeZoneId(String clientTimeZoneId) {
			postLoad.clientTimeZoneId = clientTimeZoneId;
			return this;
		}

		public Builder setPreferences(String preferences) {
			postLoad.preferences = preferences;
			return this;
		}

		public Builder setNotes(String notes) {
			postLoad.notes = notes;
			return this;
		}

		public Builder setTitle(String title) {
			postLoad.title = title;
			return this;
		}

		public Builder setShippingAddress(Address shippingAddress) {
			postLoad.shippingAddress = shippingAddress;
			return this;
		}

		public Builder setBidCloseTime(LocalDateTime bidCloseTime) {
			postLoad.bidCloseTime = bidCloseTime;
			return this;
		}

		public Builder setPostingMethod(String postingMethod) {
			postLoad.postingMethod = postingMethod;
			return this;
		}

		public Builder setGroupId(List<String> groupId) {
			postLoad.listGroupId = groupId;
			return this;
		}

		public Builder setSellerObjectId(List<String> sellerObjectId) {
			postLoad.listSellerId = sellerObjectId;
			return this;
		}

		public Builder setBidAcceptanceMethod(String bidAcceptanceMethod) {
			postLoad.bidAcceptanceMethod = bidAcceptanceMethod;
			return this;
		}

		public Builder setBasePrice(Double basePrice) {
			postLoad.basePrice = basePrice;
			return this;
		}

		public Builder setDisplayCostToMarketPrice(Boolean displayCostToMarketPrice) {
			postLoad.displayCostToMarketPrice = displayCostToMarketPrice;
			return this;
		}

		public Builder setStatus(String status) {
			postLoad.status = status;
			return this;
		}

		public Builder setId(String id) {
			postLoad.id = id;
			return this;
		}

		public PostLoad build() {
			return this.postLoad;
		}
	}

	public enum Preferences {
		FLAT_BED("FLAT_BED"), VAN("VAN"), NO_PREFERENCES("NO_PREFERENCES");

		String code;

		private Preferences(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	public enum PostingMethod {
		GROUP("GROUP"), INDIVIDUAL("INDIVIDUAL"), MARKET("MARKET");

		String code;

		private PostingMethod(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	public enum BidAcceptanceMethod {
		UNDER_TARGET_THRESHOLD("UNDER_TARGET_THRESHOLD"), APPROVE_AND_ACCEPT("APPROVE_AND_ACCEPT");

		String code;

		private BidAcceptanceMethod(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	public enum DropLive {
		DROP("DROP"), LIVE("LIVE");

		String code;

		private DropLive(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}

	public enum Status {
		PENDING("PENDING");

		String code;

		private Status(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
	}
}
