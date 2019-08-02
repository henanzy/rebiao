package com.hnzy.rb.pojo;

import java.util.Date;

public class RbJs {

	private Integer id;
	private String yhBm; // 用户编码
	private String rbAd;// 仪表编码
	private String status;// 运行状态
	private String dj;// 单价类型
	private String zf;// 作废
	private String sta;// 状态
	private Date cbsj;// 抄表日期
	private Double scBs;// 上次表数
	private Double bcBs;// 本次表数
	private String jsBs;// 结算用量
	private String Bz;// 用户备注
	private String resNum;// 用户编码
	private String rbType;// 热表类型
	private Double energy;// 累计热量
	// 瞬时热量
	private String power;
	// 瞬时流量
	private String flow;
	// 进水温度
	private Double inTmp;
	// 回水温度
	private Double outTmp;
	// 温差
	private Double diffTmp;
	// 错误代码
	private String errCode;
	// 更新时间
	private Date recordTime;
	// 累计流量
	private Double energyLj;
	//热量差值
	private Double rlc;
	private String rbfl; //热表分类
	
	public String getRbfl() {
		return rbfl;
	}

	public void setRbfl(String rbfl) {
		this.rbfl = rbfl;
	}

	private Yh yh;

	public Double getRlc() {
		return rlc;
	}

	public void setRlc(Double rlc) {
		this.rlc = rlc;
	}

	public String getBz() {
		return Bz;
	}

	public void setBz(String bz) {
		Bz = bz;
	}

	public String getResNum() {
		return resNum;
	}

	public void setResNum(String resNum) {
		this.resNum = resNum;
	}

	public String getRbType() {
		return rbType;
	}

	public void setRbType(String rbType) {
		this.rbType = rbType;
	}
	public Double getEnergy() {
		return energy;
	}

	public void setEnergy(Double energy) {
		this.energy = energy;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public Double getInTmp() {
		return inTmp;
	}

	public void setInTmp(Double inTmp) {
		this.inTmp = inTmp;
	}

	public Double getOutTmp() {
		return outTmp;
	}

	public void setOutTmp(Double outTmp) {
		this.outTmp = outTmp;
	}

	public Double getDiffTmp() {
		return diffTmp;
	}

	public void setDiffTmp(Double diffTmp) {
		this.diffTmp = diffTmp;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public Double getEnergyLj() {
		return energyLj;
	}

	public void setEnergyLj(Double energyLj) {
		this.energyLj = energyLj;
	}

	public Yh getYh() {
		return yh;
	}

	public void setYh(Yh yh) {
		this.yh = yh;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getYhBm() {
		return yhBm;
	}

	public void setYhBm(String yhBm) {
		this.yhBm = yhBm;
	}

	public String getRbAd() {
		return rbAd;
	}

	public void setRbAd(String rbAd) {
		this.rbAd = rbAd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDj() {
		return dj;
	}

	public void setDj(String dj) {
		this.dj = dj;
	}

	public String getZf() {
		return zf;
	}

	public void setZf(String zf) {
		this.zf = zf;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	public Date getCbsj() {
		return cbsj;
	}

	public void setCbsj(Date cbsj) {
		this.cbsj = cbsj;
	}
	public Double getScBs() {
		return scBs;
	}

	public void setScBs(Double scBs) {
		this.scBs = scBs;
	}

	public Double getBcBs() {
		return bcBs;
	}

	public void setBcBs(Double bcBs) {
		this.bcBs = bcBs;
	}

	public String getJsBs() {
		return jsBs;
	}

	public void setJsBs(String jsBs) {
		this.jsBs = jsBs;
	}

}
