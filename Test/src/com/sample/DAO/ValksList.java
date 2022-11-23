package com.sample.DAO;

import java.util.ArrayList;
import java.util.List;

import com.sample.model.Valkaryine;

public class ValksList 
{
	public static List<Valkaryine> getValks()
	{
		List<Valkaryine> valk = new ArrayList<Valkaryine>();
		valk.add(new Valkaryine("Kiana","Mech",16,"A"));
		valk.add(new Valkaryine("Mei","Bio",17,"B"));
		valk.add(new Valkaryine("Bronya","Physic",15,"AB"));
		valk.add(new Valkaryine("Treasa","Physic",32,"O"));
		valk.add(new Valkaryine("Fuha","Bio",19,"B"));
		return valk; 
	}
}
