package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.TopUpModel;

public class TopupDataAccess 
{
	public static ArrayList<TopUpModel> getTopup(int category_id,int period_id) throws SQLException
	{
		Connection cnn = DataConnection.connect();
		String topupQuery = "SELECT item.item_name AS Name,item.unit AS Unit,SUM(IF(ledger.count!=0,ledger.count,-1*ledger.used)) AS Stock "
							+ "FROM item,ledger "
							+ "WHERE item.item_code=ledger.item_code AND item.category_id = ? AND ledger.period_id = ? "
							+ "GROUP BY ledger.item_code";
		
		PreparedStatement stmt = cnn.prepareStatement(topupQuery);
		stmt.setInt(1, category_id);
		stmt.setInt(2, period_id);
		ResultSet res = stmt.executeQuery();
		
		ArrayList<TopUpModel> topupList = new ArrayList<TopUpModel>();
		int no =0;
		while(res.next())
		{
			no++;
			String name = res.getString(1);
			String unit = res.getString(2);
			int stock = res.getShort(3);
			
			TopUpModel topup = new TopUpModel(no, name, unit, stock);
			topupList.add(topup);
		}
		return topupList;
	}
}
