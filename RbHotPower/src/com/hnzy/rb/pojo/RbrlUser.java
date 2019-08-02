package com.hnzy.rb.pojo;

import java.io.Serializable;

public class RbrlUser implements Serializable
{
private String cLIENTNO ; //编号关联字段，
private String cLIENTNAME;//姓名
private String aDDRESS;//用户地址
private RbUser rbUser;
public RbUser getRbUser()
{
	return rbUser;
}
public void setRbUser(RbUser rbUser)
{
	this.rbUser = rbUser;
}
public String getcLIENTNO()
{
	return cLIENTNO;
}
public void setcLIENTNO(String cLIENTNO)
{
	this.cLIENTNO = cLIENTNO;
}
public String getcLIENTNAME()
{
	return cLIENTNAME;
}
public void setcLIENTNAME(String cLIENTNAME)
{
	this.cLIENTNAME = cLIENTNAME;
}
public String getaDDRESS()
{
	return aDDRESS;
}
public void setaDDRESS(String aDDRESS)
{
	this.aDDRESS = aDDRESS;
}
	
}
