package bay.university.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SubmitTag extends TagSupport {
    private String okLabel;
    private String cancelLabel;

    public void setOkLabel(String okLabel) {
        this.okLabel = okLabel;
    }

    public void setCancelLabel(String cancelLabel) {
        this.cancelLabel = cancelLabel;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<input type='submit' value='" + okLabel + "'/>");
            pageContext.getOut().write("<input type='reset' value='" + cancelLabel + "'/>");
        } catch (Exception e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}
