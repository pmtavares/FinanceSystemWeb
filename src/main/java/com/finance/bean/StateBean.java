package com.finance.bean;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;




@ManagedBean()
public class StateBean {
	
	public void save()
	{
		Messages.addGlobalInfo("Programming web");
	}

}
