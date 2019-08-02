package com.hnzy.rb.pojo;

import java.util.Date;

public class RbrlInfo
{
   private String mBUSID;//通道号
   private String mETERID;//热表号
   private Double mETERNLLJ;//累计热量
   private Double mETERTJ;//瞬时流量
   private Double mETERLS;//流量
   private Double mETERGL;//功率
   private Double mETERJSWD;//进水温度
   private Double mETERHSWD;//回水温度
   private Double mETERWC;//温差
   private Date dDATE;//抄表时间
   private Double AREAGUID;
   private Tarea tmeter;
   
public Double getAREAGUID()
{
	return AREAGUID;
}
public void setAREAGUID(Double aREAGUID)
{
	AREAGUID = aREAGUID;
}
public Tarea getTmeter()
{
	return tmeter;
}
public void setTmeter(Tarea tmeter)
{
	this.tmeter = tmeter;
}
public String getmBUSID()
{
	return mBUSID;
}
public void setmBUSID(String mBUSID)
{
	this.mBUSID = mBUSID;
}
public String getmETERID()
{
	return mETERID;
}
public void setmETERID(String mETERID)
{
	this.mETERID = mETERID;
}
public Double getmETERNLLJ()
{
	return mETERNLLJ;
}
public void setmETERNLLJ(Double mETERNLLJ)
{
	this.mETERNLLJ = mETERNLLJ;
}
public Double getmETERTJ()
{
	return mETERTJ;
}
public void setmETERTJ(Double mETERTJ)
{
	this.mETERTJ = mETERTJ;
}
public Double getmETERLS()
{
	return mETERLS;
}
public void setmETERLS(Double mETERLS)
{
	this.mETERLS = mETERLS;
}
public Double getmETERGL()
{
	return mETERGL;
}
public void setmETERGL(Double mETERGL)
{
	this.mETERGL = mETERGL;
}
public Double getmETERJSWD()
{
	return mETERJSWD;
}
public void setmETERJSWD(Double mETERJSWD)
{
	this.mETERJSWD = mETERJSWD;
}
public Double getmETERHSWD()
{
	return mETERHSWD;
}
public void setmETERHSWD(Double mETERHSWD)
{
	this.mETERHSWD = mETERHSWD;
}
public Double getmETERWC()
{
	return mETERWC;
}
public void setmETERWC(Double mETERWC)
{
	this.mETERWC = mETERWC;
}
public Date getdDATE()
{
	return dDATE;
}
public void setdDATE(Date dDATE)
{
	this.dDATE = dDATE;
}
   
}
