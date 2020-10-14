package com.bettaway.rfp.modal;

import com.bettaway.rfp.modal.PostLoad.Builder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
	/**
	 * Address line 1 (e.g., street, PO Box, or company name).
	 */
	private String line1;
	/**
	 * Address line 2 (e.g., apartment, suite, unit, or building).
	 */
	private String line2;
	/**
	 * City, district, suburb, town, or village.
	 */
	private String city;
	/**
	 * State, county, province, or region.
	 */
	private String state;
	/**
	 * ZIP or postal code.
	 */
	private String zip;

	/**
	 * Country code
	 */
	private String country;
	/**
	 * Address geo location
	 */
	private String geoLocation;

	/**
	 * Time-Zone Id for the location based on geoLocation
	 */
	private String timeZoneId;

	private Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(com.stripe.model.Address address) {
		this.line1 = address.getLine1();
		this.line2 = address.getLine2();
		this.city = address.getCity();
		this.state = address.getState();
		this.country = address.getCountry();
		this.zip = address.getPostalCode();
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public static Builder createBuilder() {
		return new Builder();
	}

	public static Builder updateBuilder(Address address) {
		return new Builder(address);
	}

	public static class Builder {
		Address address;

		public Builder() {
			this.address = new Address();
		}

		public Builder(Address address) {
			super();
			this.address = address;
		}

		public Builder setLine1(String line1) {
			address.line1 = line1;
			return this;
		}

		public Builder setLine2(String line2) {
			address.line2 = line2;
			return this;
		}

		public Builder setCity(String city) {
			address.city = city;
			return this;
		}

		public Builder setState(String state) {
			address.state = state;
			return this;
		}

		public Builder setZip(String zip) {
			address.zip = zip;
			return this;
		}

		public Builder setCountry(String country) {
			address.country = country;
			return this;
		}

		public Builder setGeoLocation(String geoLocation) {
			address.geoLocation = geoLocation;
			return this;
		}

		public Builder setTimeZoneId(String timeZoneId) {
			address.timeZoneId = timeZoneId;
			return this;
		}

		public Address build() {
			return address;
		}
	}

}
