package bay.university.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class DossierTag extends BodyTagSupport {
    private String action;

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<form action='" + action + "' method='POST'>");
        } catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            BodyContent bodyContent = getBodyContent();
            bodyContent.writeOut(getPreviousOut());
            pageContext.getOut().write("</form>");
        } catch (Exception e) {
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }
}
