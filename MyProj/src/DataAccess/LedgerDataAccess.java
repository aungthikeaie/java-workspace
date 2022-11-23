package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.LedgerModel;

public class LedgerDataAccess 
{
	public static ArrayList<LedgerModel> getLedger(int itemCode, int periodId) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		String ledgerQuery = "SELECT * FROM ledger WHERE item_code = ? AND period_id = ?";
		PreparedStatement stmt = cnn.prepareStatement(ledgerQuery);
		stmt.setInt(1, itemCode);
		stmt.setInt(2, periodId);
		
		ArrayList<LedgerModel> ledgerList = new ArrayList<LedgerModel>();
		ResultSet res = stmt.executeQuery();
		while(res.next())
		{
			int ledger_id = res.getInt("ledger_id");
			String transaction_date = res.getString("transaction_date");
			String source = res.getString("source");
			int iinvoice_no = res.getInt("iinvoice_no");
			String iinvoice_date = res.getString("iinvoice_date");
			int count = res.getInt("count");
			double unit_price = res.getDouble("unit_price");
			double total_cost = res.getDouble("total_cost");
			int used = res.getInt("used");
			int stock_in_hand = res.getInt("stock_in_hand");
			String sign = res.getString("sign");
			String remark = res.getString("remark");
			int item_code = res.getInt("item_code");
			int period_id = res.getInt("period_id");
			LedgerModel ledger = new LedgerModel(ledger_id, transaction_date, source, iinvoice_no, iinvoice_date, count, unit_price, total_cost, used, stock_in_hand, sign, remark, item_code, period_id);
			
			ledgerList.add(ledger);
		}
		return ledgerList;
	}
}
