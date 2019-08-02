package com.hnzy.rb.pojo;

public class CsTime
{
   private int id;
   private int cstime;
   private int Type;//抄表时间设定区分热表与阀门时间设定
public int getId()
{
	return id;
}
public void setId(int id)
{
	this.id = id;
}
public int getCstime()
{
	return cstime;
}
public void setCstime(int cstime)
{
	this.cstime = cstime;
}
public int getType()
{
	return Type;
}
public void setType(int type)
{
	Type = type;
}
   
   
}
