package com.hnzy.custompojo;

public class villageXq
{
 private Integer id;
 private String pId;
 private String name;
 private String BuildNo;
 private String CellNo;
 private String isParent;
 private Integer type;
public Integer getId()
{
	return id;
}
public void setId(Integer id)
{
	this.id = id;
}

public String getpId()
{
	return pId;
}
public void setpId(String pId)
{
	this.pId = pId;
}
public void setCellNo(String cellNo)
{
	CellNo = cellNo;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name = name;
}


public String getIsParent()
{
	return isParent;
}
public void setIsParent(String isParent)
{
	this.isParent = isParent;
}
public Integer getType()
{
	return type;
}
public void setType(Integer type)
{
	this.type = type;
}


public String getBuildNo()
{
	return BuildNo;
}
public void setBuildNo(String buildNo)
{
	BuildNo = buildNo;
}
public String getCellNo()
{
	return CellNo;
}
public void String(String cellNo)
{
	CellNo = cellNo;
}

public villageXq(Integer id, String pId, String name, String buildNo, String cellNo, String isParent, Integer type)
{
	super();
	this.id = id;
	this.pId = pId;
	this.name = name;
	BuildNo = buildNo;
	CellNo = cellNo;
	this.isParent = isParent;
	this.type = type;
}
public villageXq()
{
	super();
}
 
}
