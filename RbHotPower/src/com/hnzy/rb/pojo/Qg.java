package com.hnzy.rb.pojo;

import java.io.Serializable;
import java.util.Date;

public class Qg implements Serializable {

	private static final long serialVersionUID = -4072646355182930123L;
	private int id;
	private String qgID;
	private String jzqID;
	private String xqName;
	private int qgStatus;
	private String version;
	private String mode;
	private Integer readCycle;
	private String vALstID;
	private String vALedID;
	private String installAd;
	private Date recordTime;
	private String skqSbh;
    private Jzq jzq;
    private int qgFl;
    private int fmCou;
    
	public int getQgFl()
	{
		return qgFl;
	}

	public void setQgFl(int qgFl)
	{
		this.qgFl = qgFl;
	}

	public int getFmCou()
	{
		return fmCou;
	}

	public void setFmCou(int fmCou)
	{
		this.fmCou = fmCou;
	}

	public String getSkqSbh()
	{
		return skqSbh;
	}

	public void setSkqSbh(String skqSbh)
	{
		this.skqSbh = skqSbh;
	}

	public Jzq getJzq() {
		return jzq;
	}

	public void setJzq(Jzq jzq) {
		this.jzq = jzq;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQgID() {
		return qgID;
	}

	public void setQgID(String qgID) {
		this.qgID = qgID;
	}

	public String getJzqID() {
		return jzqID;
	}

	public void setJzqID(String jzqID) {
		this.jzqID = jzqID;
	}

	public String getXqName() {
		return xqName;
	}

	public void setXqName(String xqName) {
		this.xqName = xqName;
	}


	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}


	public int getQgStatus()
	{
		return qgStatus;
	}

	public void setQgStatus(int qgStatus)
	{
		this.qgStatus = qgStatus;
	}

	public Integer getReadCycle()
	{
		return readCycle;
	}

	public void setReadCycle(Integer readCycle)
	{
		this.readCycle = readCycle;
	}

	public String getvALstID() {
		return vALstID;
	}

	public void setvALstID(String vALstID) {
		this.vALstID = vALstID;
	}

	public String getvALedID() {
		return vALedID;
	}

	public void setvALedID(String vALedID) {
		this.vALedID = vALedID;
	}

	public String getInstallAd() {
		return installAd;
	}

	public void setInstallAd(String installAd) {
		this.installAd = installAd;
	}


	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	@Override
	public String toString() {
		return "Qg [id=" + id + ", qgID=" + qgID + ", jzqID=" + jzqID + ", xqName=" + xqName + ", qgStatus=" + qgStatus
				+ ", version=" + version + ", mode=" + mode + ", readCycle=" + readCycle + ", vALstID=" + vALstID
				+ ", vALedID=" + vALedID + ", installAd=" + installAd + ", recordTime=" + recordTime + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
