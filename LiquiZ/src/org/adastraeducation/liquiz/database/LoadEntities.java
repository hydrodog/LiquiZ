package org.adastraeducation.liquiz.database;

import java.sql.*;

public class LoadEntities {

	public void loadDispEl(int DispElID) {
		Connection conn = null;
		try {
			conn = DatabaseMgr.getConnection();
			PreparedStatement p = conn.prepareStatement("SELECT Element, Type FROM DispElSeq WHERE DispEl=? ORDER BY Sequence ASC");
			p.setInt(1, DispElID);
			
			ResultSet rs = p.executeQuery();
			String type = rs.getString("Type");
			if (type.equals("text")) {
				StringBuilder sb = new StringBuilder();
				while (rs.next()) {
					sb.append(rs.getString("Element"));
				}
				org.adastraeducation.liquiz.Text d = new org.adastraeducation.liquiz.Text(sb.toString());
			} else if (type.equals("img")) {
				
			} else if (type.equals("aud")) {
				
			} else if (type.equals("vid")) {
				
			}

			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseMgr.returnConnection(conn);
		}
	}
}
