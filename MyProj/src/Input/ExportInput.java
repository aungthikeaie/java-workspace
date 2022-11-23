package Input;

import java.sql.SQLException;
import java.util.Scanner;

import DataAccess.ExportDataAccess;
import Model.LedgerModel;

public class ExportInput 
{
	public static LedgerModel ledger = null;
	public void save()
	{
		int Des = 0;
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Transaction(transaction_date, source, iinvoice_no, iinvoice_date, stock_in_hand, used, sign, remark, item_code, period_id) : ");
			
			int ledger_id = 0;
			String transaction_date = sc.next();
			String source = sc.next();
			int iinvoice_no = Integer.parseInt(sc.next());
			String iinvoice_date = sc.next();
			int count = 0;
			double unit_price = 0.0;
			double total_cost = 0.0;
			int used = Integer.parseInt(sc.next());
			int stock_in_hand = Integer.parseInt(sc.next());
			String sign = sc.next();
			String remark = sc.next();
			int item_code = Integer.parseInt(sc.next());
			int period_id = Integer.parseInt(sc.next());
			
			ledger = new LedgerModel(ledger_id, transaction_date, source, iinvoice_no, iinvoice_date, count, unit_price, total_cost, used, stock_in_hand, sign, remark, item_code, period_id);
			ExportDataAccess exportData = new ExportDataAccess();
			try 
			{
				boolean condition = exportData.saveExport(ledger);
				if(condition)
					System.out.println("Transaction is saved.");
				else	 
				System.out.println("Transaction is not saved.");
			}
			catch (SQLException e) 
			{
				System.out.println("Your SQL syntax is not correct!");
				e.printStackTrace();
			}
			System.out.println("Want to input another transaction?(1/0)");
			Des = Integer.parseInt(sc.next());
		}
		while(Des == 1);
	}
	public static void main(String args[])
	{
		ExportInput ei = new ExportInput();
		ei.save();
	}
}
