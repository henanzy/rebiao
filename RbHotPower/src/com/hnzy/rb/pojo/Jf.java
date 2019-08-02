package com.hnzy.rb.pojo;

import java.util.Date;

public class Jf {
	private Integer id;// 主键
	private Date rEAD_TIME;// 抄表日期
	private Double tHIS_VALUE;// 本次表数
	private String mETER_CODE;// 仪表code
	private String iNSTANT_FLOW;// 瞬时流量
	private Double aCCUMULATE_FLOW;// 累计流量
	private String sTEAM_BACKWATER;// 蒸汽回水
	private String rEMARK;// 备注
	private Double pRESSURE;// 压力
	private Double tEMPERATURE;// 温度
	private Double lAST_VALUE;// 上次表数
	private Double uSE_VALUE_KWH;// 表计用量KWH
	private Double uSE_VALUE_GJ;// 表计用量GJ
	private String rEAD_STATE; // 抄表状态
	private String sETTLE_TYPE;// 结算方式
	private String cYCLE;// 采暖期

	public String getcYCLE() {
		return cYCLE;
	}

	public void setcYCLE(String cYCLE) {
		this.cYCLE = cYCLE;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getsETTLE_TYPE() {
		return sETTLE_TYPE;
	}

	public void setsETTLE_TYPE(String sETTLE_TYPE) {
		this.sETTLE_TYPE = sETTLE_TYPE;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public Date getrEAD_TIME() {
		return rEAD_TIME;
	}

	public void setrEAD_TIME(Date date) {
		this.rEAD_TIME = date;
	}

	public Double gettHIS_VALUE() {
		return tHIS_VALUE;
	}

	public void settHIS_VALUE(Double tHIS_VALUE) {
		this.tHIS_VALUE = tHIS_VALUE;
	}

	public String getmETER_CODE() {
		return mETER_CODE;
	}

	public void setmETER_CODE(String mETER_CODE) {
		this.mETER_CODE = mETER_CODE;
	}

	public String getiNSTANT_FLOW() {
		return iNSTANT_FLOW;
	}

	public void setiNSTANT_FLOW(String string) {
		this.iNSTANT_FLOW = string;
	}

	public Double getaCCUMULATE_FLOW() {
		return aCCUMULATE_FLOW;
	}

	public void setaCCUMULATE_FLOW(Double aCCUMULATE_FLOW) {
		this.aCCUMULATE_FLOW = aCCUMULATE_FLOW;
	}

	public String getsTEAM_BACKWATER() {
		return sTEAM_BACKWATER;
	}

	public void setsTEAM_BACKWATER(String sTEAM_BACKWATER) {
		this.sTEAM_BACKWATER = sTEAM_BACKWATER;
	}

	public String getrEMARK() {
		return rEMARK;
	}

	public void setrEMARK(String rEMARK) {
		this.rEMARK = rEMARK;
	}

	public Double getpRESSURE() {
		return pRESSURE;
	}

	public void setpRESSURE(Double pRESSURE) {
		this.pRESSURE = pRESSURE;
	}

	public Double gettEMPERATURE() {
		return tEMPERATURE;
	}

	public void settEMPERATURE(Double tEMPERATURE) {
		this.tEMPERATURE = tEMPERATURE;
	}

	public Double getlAST_VALUE() {
		return lAST_VALUE;
	}

	public void setlAST_VALUE(Double lAST_VALUE) {
		this.lAST_VALUE = lAST_VALUE;
	}

	public Double getuSE_VALUE_KWH() {
		return uSE_VALUE_KWH;
	}

	public void setuSE_VALUE_KWH(Double uSE_VALUE_KWH) {
		this.uSE_VALUE_KWH = uSE_VALUE_KWH;
	}

	public Double getuSE_VALUE_GJ() {
		return uSE_VALUE_GJ;
	}

	public void setuSE_VALUE_GJ(Double uSE_VALUE_GJ) {
		this.uSE_VALUE_GJ = uSE_VALUE_GJ;
	}

	public String getrEAD_STATE() {
		return rEAD_STATE;
	}

	public void setrEAD_STATE(String rEAD_STATE) {
		this.rEAD_STATE = rEAD_STATE;
	}
}
