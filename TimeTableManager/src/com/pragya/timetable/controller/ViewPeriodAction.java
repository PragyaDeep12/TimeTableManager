package com.pragya.timetable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pragya.timetable.dao.PeriodDao;
import com.pragya.timetable.model.Period;

public class ViewPeriodAction extends ActionSupport implements ServletRequestAware{
	int perid;
	Period period;
	HttpSession ses;
	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public int getPerid() {
		return perid;
	}

	public void setPerid(int perid) {
		this.perid = perid;
	}
	 public String viewPeriod()
	 {
		 try{
		 PeriodDao pdao=new PeriodDao();
	 this.setPeriod( pdao.getPeriod(getPerid()));
	 ses.setAttribute("period", this.getPeriod());
	 return "success";
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
		 return "fail";
	 }

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ses=request.getSession();
	}
}
