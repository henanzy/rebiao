package com.hnzy.rb.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.RbDao;
import com.hnzy.rb.pojo.Rb;
import com.hnzy.rb.service.RbService;
import com.hnzy.rb.util.ExcelUtilRb;

@Service
public class RbServiceImpl implements RbService
{
	@Autowired
	private RbDao rbDao;
	public List<Rb> findRb(String xqName,String rbLyName,String cellNO,String houseNO ){
		return rbDao.findRb(xqName, rbLyName, cellNO, houseNO);
	}
	@Override
	public List<Rb> find()
	{
		return rbDao.find();
	}
	@Override
	public List<Rb> searchSbb(String xqName, String buildNo, String cellNo, String houseNo, String recordTime1,
			String recordTime2,Integer rbfl)
	{
		return rbDao.searchSbb(xqName, buildNo, cellNo, houseNo, recordTime1, recordTime2,rbfl);
	}
	@Override
	public List<Rb> searchHis(String xqName, String buildNo, String cellNo, String houseNo, String recordTime1,
			String recordTime2)
	{
		return rbDao.searchHis(xqName, buildNo, cellNo, houseNo, recordTime1, recordTime2);
	}

	@Override
	public void exportExcel(List<Rb> rbList, ServletOutputStream outputStream) throws IOException
	{
		ExcelUtilRb.exportExcel(rbList, outputStream);	
	}
	@Override
	public List<Rb> SbSelExp(Double gs, Double hs, Integer wc)
	{
		return rbDao.SbSelExp(gs, hs, wc);
	}
	@Override
	public List<Rb> SelRbExp()
	{
		return rbDao.SelRbExp();
	}
	@Override
	public List<Rb> SelRbEp(String rbAd)
	{
		return rbDao.SelRbEp(rbAd);
	}
	@Override
	public void UpExp(String rbAd, int rbExp)
	{
		rbDao.UpExp(rbAd, rbExp);
	}
	@Override
	public Rb findById(Integer id)
	{
		return rbDao.findById(id);
	}
	@Override
	public void UpSbxx(Rb rb)
	{
      rbDao.UpSbxx(rb);		
	}
	@Override
	public void UpRbVal(Rb rb)
	{
		 rbDao.UpRbVal(rb);
	}
	@Override
	public Rb findByRbAd(String rbAd)
	{
		return rbDao.findByRbAd(rbAd);
	}
	@Override
	public Rb  findBzxx(String xqName, String buildNO, String cellNO, String houseNO)
	{
		return rbDao.findBzxx(xqName, buildNO, cellNO, houseNO);
	}
	@Override
	public void Upbz(String bz,String xqName, String buildNO, String cellNO, String houseNO)
	{
		rbDao.Upbz(bz,xqName, buildNO, cellNO, houseNO);
	}
	@Override
	public List<Rb> SelRbAd(String xqName, String buildNO, String cellNO, String houseNO)
	{
		return rbDao.SelRbAd(xqName, buildNO, cellNO, houseNO);
	}
	@Override
	public List<Rb> SelRb(String RbAd,String date)
	{
		return rbDao.SelRb(RbAd,date);
	}
	@Override
	public List<Rb> findRbHis(String recordTime1, String recordTime2)
	{
		return rbDao.findRbHis(recordTime1, recordTime2);
	}
	@Override
	public Rb findWxxByFmId(String fmId)
	{
		return rbDao.findWxxByFmId(fmId);
	}
	@Override
	public void updateRbById(Rb rb)
	{
		rbDao.updateRbById(rb);
	}
	@Override
	public void InsertRbHis(Rb rb)
	{
		rbDao.InsertRbHis(rb);
	}
	@Override
	public void upRbbz(String rbAd, String bz)
	{
		rbDao.upRbbz(rbAd, bz);
	}
	@Override
	public List<Rb> JrCb(String xqName, String buildNO, String cellNO,String time)
	{
		return rbDao.JrCb(xqName,buildNO,cellNO,time);
	}
	@Override
	public List<Rb> JrWCb(String xqName, String buildNO, String cellNO,String time)
	{
		return rbDao.JrWCb(xqName,buildNO,cellNO,time);
	}
	@Override
	public List<Rb> findRbAll(String xqName, String buildNO, String cellNO, String houseNO, Integer rbfl)
	{
		// TODO Auto-generated method stub
		return rbDao.findRbAll(xqName, buildNO, cellNO, houseNO,rbfl);
	}
	@Override
	public void updateRbAd(String rbAd, String xrbAd)
	{
		rbDao.updateRbAd(rbAd, xrbAd);
	}
	@Override
	public void updateYhRbAd(String rbAd, String xrbAd)
	{
		rbDao.updateYhRbAd(rbAd, xrbAd);
	}
	@Override
	public void InsertRbId(String rbAd, String recordTime)
	{
		rbDao.InsertRbId(rbAd, recordTime);
	}
	@Override
	public void DeleteRbId()
	{
		rbDao.DeleteRbId();
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Rb> findRbId()
	{
		// TODO Auto-generated method stub
		return rbDao.findRbId();
	}
	@Override
	public Rb findRbflByQgId(String qgId)
	{
		// TODO Auto-generated method stub
		return rbDao.findRbflByQgId(qgId);
	}
	@Override
	public List<Rb> searchHisExcel(String xqName, String rbLyName, String cellNo, String houseNo, String recordTime1,
			String recordTime2)
	{
		// TODO Auto-generated method stub
		return rbDao.searchHisExcel(xqName, rbLyName, cellNo, houseNo, recordTime1, recordTime2);
	}
	@Override
	public List<Rb> findRbGzxx(String status) {
		// TODO Auto-generated method stub
		return rbDao.findRbGzxx(status);
	}
	@Override
	public List<Rb> findRbYh(String qgId) {
		// TODO Auto-generated method stub
		return rbDao.findRbYh(qgId);
	}
	@Override
	public List<Rb> findRblb(String qgId) {
		// TODO Auto-generated method stub
		return rbDao.findRblb(qgId);
	}
}
