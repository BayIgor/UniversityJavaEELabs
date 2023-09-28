package bay.university.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SurnameTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<input type='text' name='surname'/>");
        } catch (Exception e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}
