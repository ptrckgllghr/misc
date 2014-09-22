package mv.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import mv.forms.RegistrationForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.validator.DynaValidatorForm;



public class RegistrationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

//		ActionForward forward = null;
//		RegistrationForm reg = (RegistrationForm) form;
//
//		if (persist(reg))
//			forward = mapping.findForward("success");
//		else// invalid login
//			forward = mapping.findForward("failure");
//
//		return forward;
		
		DynaValidatorForm disp = (DynaValidatorForm) form;
		disp.set("message","Add method executed");
		return mapping.findForward("success");	
	}

//	private Connection newConnection() throws SQLException {
//		try {
//			Context initCtx = new InitialContext();
//			Context envCtx = (Context) initCtx.lookup("java:comp/env");
//			DataSource dataSrc = (DataSource) envCtx.lookup("jdbc/myds");
//			return dataSrc.getConnection();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}

//	public boolean persist(RegistrationForm user) {
//		String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?)";
//		Connection conn = null;
//
//		try {
//			conn = newConnection();
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, user.getUserid());
//			stmt.setString(2, user.getName());
//			stmt.setInt(3, user.getAge());
//			stmt.setString(4, user.getCity());
//			stmt.setString(5, user.getEmail());
//			stmt.setString(6, user.getPhone());
//			stmt.setString(7, user.getPassword());
//			stmt.executeQuery();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
