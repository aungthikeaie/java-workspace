package Input;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import DataAccess.PeriodDataAccess;
import Model.PeriodModel;

public class PeriodInput 
{
	static PeriodModel period = null;
	
	public static void save()
	{
		int Des = 0;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Start Date, End Date and Description : ");
			
			int period_id = 0;
			String start_date = sc.next();
			String end_date = sc.next();
			String description = sc.next();
		
			period = new PeriodModel(period_id, start_date, end_date, description);
			
			PeriodDataAccess periodData = new PeriodDataAccess();
			
			try 
			{
				boolean condition = periodData.saveCategory(period);
				if(condition)
					System.out.println("Period is created.");
				else	 
					System.out.println("Period is not created.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to input another period?(1/0)");
			Des = Integer.parseInt(sc.next());
		}
		while(Des == 1);
	}
	
	public static void update()
	{
		int Des = 0;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Period ID and Description : ");
			
			int period_id = Integer.parseInt(sc.next());
			String start_date = "";
			String end_date = "";
			String description = sc.next();
		
			period = new PeriodModel(period_id, start_date, end_date, description);
			
			PeriodDataAccess periodData = new PeriodDataAccess();
			
			try 
			{
				boolean condition = periodData.updatePeriod(period);
				if(condition)
					System.out.println("Period is updated.");
				else	 
					System.out.println("Period is not updated.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to update another period?(1/0)");
			Des = Integer.parseInt(sc.next());
		}
		while(Des == 1);
	}
	
	public static void delete()
	{
		int Des = 0;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Period ID for deletion : ");
			
			int period_id = Integer.parseInt(sc.next());
			String start_date = "";
			String end_date = "";
			String description = "";
		
			period = new PeriodModel(period_id, start_date, end_date, description);
			
			PeriodDataAccess periodData = new PeriodDataAccess();
			
			try 
			{
				boolean condition = periodData.deletePeriod(period);
				if(condition)
					System.out.println("Period is deleted.");
				else	 
					System.out.println("Period is not deleted.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to delete another period?(1/0)");
			Des = Integer.parseInt(sc.next());
		}
		while(Des == 1);
	}
	
	public static void main(String args[]) throws SQLException
	{
		PeriodInput pi = new PeriodInput();
		/*pi.save();
		pi.update();
		pi.delete();*/
		ArrayList<PeriodModel> periodList = PeriodDataAccess.getPeriod();
		Iterator<PeriodModel> iterator = periodList.iterator();
		while(iterator.hasNext())
		{
			PeriodModel period = iterator.next();
			System.out.println(period.getPeriod_id()+"\t"+period.getStart_date()+"\t"+period.getEnd_date()+"\t"+period.getDescription());
		}
	}
	
}
