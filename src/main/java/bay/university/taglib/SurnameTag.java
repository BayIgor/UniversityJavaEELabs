package bay.university.taglib;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;

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
