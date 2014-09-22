package mv.forms;

import org.apache.struts.action.ActionForm;

public class DisplayForm extends RegistrationForm {
	private String searchTerm;

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
