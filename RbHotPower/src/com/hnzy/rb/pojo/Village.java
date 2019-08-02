package com.hnzy.rb.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Village implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7330701928268498441L;

	private Integer id;

	private String yhName; // 

	private String numID;

	private String valAd; //ַ

	private String rbAd;

	private String rbType;

	private String buildNO; // ¥����

	private String cellNO; // ��Ԫ��

	private String houseNO; // ����

	private String telephone;

	private String mobilephone;

	private String email;

	private String xqName; // С������

	private BigDecimal buileArea;

	private BigDecimal useArea;

	private BigDecimal heatArea;

	private String billWay;

	private String SFJF; // �Ƿ�ɷ�

	private String SFQF; // �Ƿ�Ƿ��

	private String SFTR; // �Ƿ�ͣ��

	private String WCAd;

	private String AZWZ;
	
    private String YLFQ;
    
    private int yhRb;//区分热表用户和非热表用户
    private String rbLyName; //楼宇号
	private String faultInfor;
	
	public int getYhRb()
	{
		return yhRb;
	}

	public void setYhRb(int yhRb)
	{
		this.yhRb = yhRb;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYhName() {
		return yhName;
	}

	public void setYhName(String yhName) {
		this.yhName = yhName;
	}

	public String getNumID() {
		return numID;
	}

	public void setNumID(String numID) {
		this.numID = numID;
	}

	public String getValAd() {
		return valAd;
	}

	public void setValAd(String valAd) {
		this.valAd = valAd;
	}

	public String getRbAd() {
		return rbAd;
	}

	public void setRbAd(String rbAd) {
		this.rbAd = rbAd;
	}

	public String getRbType() {
		return rbType;
	}

	public void setRbType(String rbType) {
		this.rbType = rbType;
	}
	public String getBuildNO()
	{
		return buildNO;
	}

	public void setBuildNO(String buildNO)
	{
		this.buildNO = buildNO;
	}

	public String getCellNO()
	{
		return cellNO;
	}

	public void setCellNO(String cellNO)
	{
		this.cellNO = cellNO;
	}

	public String getHouseNO()
	{
		return houseNO;
	}

	public void setHouseNO(String houseNO)
	{
		this.houseNO = houseNO;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getXqName() {
		return xqName;
	}

	public void setXqName(String xqName) {
		this.xqName = xqName;
	}

	public BigDecimal getBuileArea() {
		return buileArea;
	}

	public void setBuileArea(BigDecimal buileArea) {
		this.buileArea = buileArea;
	}

	public BigDecimal getUseArea() {
		return useArea;
	}

	public void setUseArea(BigDecimal useArea) {
		this.useArea = useArea;
	}

	public BigDecimal getHeatArea() {
		return heatArea;
	}

	public void setHeatArea(BigDecimal heatArea) {
		this.heatArea = heatArea;
	}

	public String getBillWay() {
		return billWay;
	}

	public void setBillWay(String billWay) {
		this.billWay = billWay;
	}

	public String getSFJF() {
		return SFJF;
	}

	public void setSFJF(String sFJF) {
		SFJF = sFJF;
	}

	public String getSFQF() {
		return SFQF;
	}

	public void setSFQF(String sFQF) {
		SFQF = sFQF;
	}

	public String getSFTR() {
		return SFTR;
	}

	public void setSFTR(String sFTR) {
		SFTR = sFTR;
	}

	public String getWCAd() {
		return WCAd;
	}

	public void setWCAd(String wCAd) {
		WCAd = wCAd;
	}

	public String getAZWZ() {
		return AZWZ;
	}

	public void setAZWZ(String aZWZ) {
		AZWZ = aZWZ;
	}

	public String getYLFQ() {
		return YLFQ;
	}

	public void setYLFQ(String yLFQ) {
		YLFQ = yLFQ;
	}

	public String getFaultInfor() {
		return faultInfor;
	}

	public void setFaultInfor(String faultInfor) {
		this.faultInfor = faultInfor;
	}

	public String getRbLyName()
	{
		return rbLyName;
	}

	public void setRbLyName(String rbLyName)
	{
		this.rbLyName = rbLyName;
	}
	
}
