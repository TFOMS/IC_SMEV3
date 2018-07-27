package com.tfoms.smev3.model;

public class Zl {
	
	private Integer regionCode;
    private String surname;
    private String firstname;
    private String lastname;
    private String datebythday;
    private Long enp;
    private String dataFrom;
    private String dataEnd;

	
	public Zl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Zl(Integer regionCode, String surname, String firstname, String lastname, String datebythday, Long enp,
			String dataFrom, String dataEnd) {
		super();
		this.regionCode = regionCode;
		this.surname = surname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.datebythday = datebythday;
		this.enp = enp;
		this.dataFrom = dataFrom;
		this.dataEnd = dataEnd;
	}


	public Integer getRegionCode() {
		return regionCode;
	}


	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDatebythday() {
		return datebythday;
	}


	public void setDatebythday(String datebythday) {
		this.datebythday = datebythday;
	}


	public Long getEnp() {
		return enp;
	}


	public void setEnp(Long enp) {
		this.enp = enp;
	}


	public String getDataFrom() {
		return dataFrom;
	}


	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}


	public String getDataEnd() {
		return dataEnd;
	}


	public void setDataEnd(String dataEnd) {
		this.dataEnd = dataEnd;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Zl [regionCode=");
		builder.append(regionCode);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", firstname=");
		builder.append(firstname);
		builder.append(", lastname=");
		builder.append(lastname);
		builder.append(", datebythday=");
		builder.append(datebythday);
		builder.append(", enp=");
		builder.append(enp);
		builder.append(", dataFrom=");
		builder.append(dataFrom);
		builder.append(", dataEnd=");
		builder.append(dataEnd);
		builder.append("]");
		return builder.toString();
	}

}