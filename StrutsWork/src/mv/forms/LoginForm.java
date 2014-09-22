package mv.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {
	private String userid, password;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (userid.length() < 4) {
			// User ID must be minimum 4 chars
			errors.add("userid", new ActionMessage("short.userid"));
		}
		if (password.length() < 4) {
			// password must be minimum of 4 chars
			errors.add("password", new ActionMessage("short.password"));
		}
		return errors;
	}
	
	
}
