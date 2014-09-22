package mv.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

public class DisplayAction extends DispatchAction {

	
	public ActionForward Add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm disp = (DynaActionForm) form;
		disp.set("message","Add method executed");
		return mapping.findForward("success");
	}

	public ActionForward View(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm disp = (DynaActionForm) form;
		disp.set("message","Add method executed");
		return mapping.findForward("success");
	}

//with display form
//	DisplayForm disp = (DisplayForm) form;
//	disp.setMessage("View method executed");

	
	
}
