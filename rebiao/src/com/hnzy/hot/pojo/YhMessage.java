package com.hnzy.hot.pojo;

import java.io.Serializable;

public class YhMessage implements Serializable{

	/**
	 * 用户表1
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String  yhbh  ;  //用户编号
	private String  yhxm  ;  //用户姓名
	private String  cgbh  ;   //层管编号
	private String  xqm  ;   //小区
	private String ldh  ;  //楼栋
	private String dyh  ;  //单元
	private String hh  ;  //户号
	private Integer fpdz ;  //风盘地址
	private String  lxdh  ;  //联系电话
	private String  bz    ;     //备注
	private int yf;//月份
	private String yzbh;//业主编号
	private String ssgs;	//所属公司
	private Double  mj   ;  //面积
	private String  yhlx ;  //用户类型
	private String xqh;//小区编号
    private String jzqip;
    private String jzqport;
    
	public String getJzqip() {
		return jzqip;
	}
	public void setJzqip(String jzqip) {
		this.jzqip = jzqip;
	}
	public String getJzqport() {
		return jzqport;
	}
	public void setJzqport(String jzqport) {
		this.jzqport = jzqport;
	}
	public String getXqh() {
		return xqh;
	}
	public void setXqh(String xqh) {
		this.xqh = xqh;
	}
	public String getSsgs() {
		return ssgs;
	}
	public void setSsgs(String ssgs) {
		this.ssgs = ssgs;
	}
	
	public String getYzbh()
	{
		return yzbh;
	}
	public void setYzbh(String yzbh)
	{
		this.yzbh = yzbh;
	}
	public int getYf()
	{
		return yf;
	}
	public void setYf(int yf)
	{
		this.yf = yf;
	}
	public Integer getFpdz()
	{
		return fpdz;
	}
	public void setFpdz(Integer fpdz)
	{
		this.fpdz = fpdz;
	}
	
	
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getYhxm() {
		return yhxm;
	}
	public void setYhxm(String yhxm) {
		this.yhxm = yhxm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYhbh() {
		return yhbh;
	}
	public void setYhbh(String yhbh) {
		this.yhbh = yhbh;
	}
	public String getCgbh() {
		return cgbh;
	}
	public void setCgbh(String cgbh) {
		this.cgbh = cgbh;
	}
	public String getXqm() {
		return xqm;
	}
	public void setXqm(String xqm) {
		this.xqm = xqm;
	}

	public String getLdh()
	{
		return ldh;
	}
	public void setLdh(String ldh)
	{
		this.ldh = ldh;
	}
	public String getDyh()
	{
		return dyh;
	}
	public void setDyh(String dyh)
	{
		this.dyh = dyh;
	}

	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	public Double getMj() {
		return mj;
	}
	public void setMj(Double mj) {
		this.mj = mj;
	}
	public Integer getfpdz() {
		return fpdz;
	}
	public void setfpdz(Integer fpdz) {
		this.fpdz = fpdz;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getYhlx() {
		return yhlx;
	}
	public void setYhlx(String yhlx) {
		this.yhlx = yhlx;
	}
	
	
	 
	
	
	
	
	
}
