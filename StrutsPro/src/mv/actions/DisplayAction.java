package mv.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import mv.forms.DisplayForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DisplayAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		DisplayForm search = (DisplayForm) form;

		if (getInfo(search) != null)
			forward = mapping.findForward("success");
		else
			// invalid login
			forward = mapping.findForward("failure");

		return forward;
	}

	private Connection newConnection() throws SQLException {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource dataSrc = (DataSource) envCtx.lookup("jdbc/myds");
			return dataSrc.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private DisplayForm getInfo(DisplayForm search) {
		String sql = "select * from users where userid=?";
		Connection conn = null;

		try {
			conn = newConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, search.getSearchTerm());
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				search.setUserid(rs.getString("userid"));
				search.setName(rs.getString("name"));
				search.setAge(rs.getInt("age"));
				search.setCity(rs.getString("city"));
				search.setEmail(rs.getString("email"));
				search.setPhone(rs.getString("phone"));
				search.setPassword(rs.getString("password"));
			}
			return search;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
