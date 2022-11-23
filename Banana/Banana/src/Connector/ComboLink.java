package Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Database;
import Form.Item;
import Form.MainFrame;

public class ComboLink 
{
	public static int idofselectedCategory() throws SQLException
	{
		Connection conn = Database.getInstance().getConnection();
		String categoryIdQuery = "select * from category where category_name ='"+ MainFrame.categorycombobox.getSelectedItem().toString() +"'";
		/*PreparedStatement stmt = conn.prepareStatement(categoryIdQuery);
		stmt.setString(1, name);*/
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(categoryIdQuery);
		res.next();
		int i = res.getInt(1);
		
		return i;
	}
}
