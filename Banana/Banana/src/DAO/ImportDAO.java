package DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import Model.LedgerModel;

public class ImportDAO 
{
	public static void saveImport(LedgerModel ledger) throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String q = "insert into ledger(transaction_date,source,iinvoice_no,iinvoice_date,count,unit_price,total_cost,used,stock_in_hand,sign,remark,item_code,period_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt =conn.prepareStatement(q);
		stmt.setString(1, ledger.getTransaction_date());
		stmt.setString(2, ledger.getSource());
		stmt.setInt(3, ledger.getIinvoice_no());
		stmt.setString(4, ledger.getIinvoice_date());
		stmt.setInt(5, ledger.getCount());
		stmt.setDouble(6, ledger.getUnit_price());
		stmt.setDouble(7, ledger.getTotal_cost());
		stmt.setInt(8, ledger.getUsed());
		stmt.setInt(9, ledger.getStock_in_hand());
		stmt.setString(10, ledger.getSign());
		stmt.setString(11, ledger.getRemark());
		stmt.setInt(12, ledger.getItem_code());
		stmt.setInt(13, ledger.getPeriod_id());
		
		System.out.println(q);
		int r = stmt.executeUpdate();
		
		if( r >= 1)
			JOptionPane.showMessageDialog(null,"Transaction is successful.","Save",JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null,"Transaction is failed.","Error",JOptionPane.ERROR_MESSAGE);
		
		conn.close();
		
	}
	
	

}
