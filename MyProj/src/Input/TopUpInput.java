package Input;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import DataAccess.TopupDataAccess;
import Model.TopUpModel;

public class TopUpInput 
{
	static TopupDataAccess topup = null;
	public static void main(String args[]) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Category id and Period Id : ");
			
		int category_id = Integer.parseInt(sc.next());
		int period_id = Integer.parseInt(sc.next());
	
		topup = new TopupDataAccess();
		ArrayList<TopUpModel> TopupList = topup.getTopup(category_id, period_id);
		Iterator<TopUpModel> iterator = TopupList.iterator();
		while(iterator.hasNext())
		{
			TopUpModel topuup = iterator.next();
			System.out.println(topuup.getNo()+"\t"+topuup.getName()+"\t"+topuup.getUnit()+"\t"+topuup.getStock());
		}
	}
}
