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
import mv.forms.LoginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = null;
		LoginForm login = (LoginForm) form;

		if (validate(login))
			forward = mapping.findForward("success");
		else //invalid login
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

	private boolean validate(LoginForm login) {
		String sql = "select * from users where userid=? and password=?";
		Connection conn = null;

		try {
			conn = newConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getUserid());
			stmt.setString(2, login.getPassword());
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
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
