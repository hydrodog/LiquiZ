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
				org.adastraeducation.liquiz.Image d = new org.adastraeducation.liquiz.Image(rs.getString("Element"));
			} else if (type.equals("aud")) {
				org.adastraeducation.liquiz.Audio d = new org.adastraeducation.liquiz.Audio(rs.getString("Element"));
			} else if (type.equals("vid")) {
				org.adastraeducation.liquiz.Video d = new org.adastraeducation.liquiz.Video(rs.getString("Element"));
			}

			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseMgr.returnConnection(conn);
		}
	}
}
