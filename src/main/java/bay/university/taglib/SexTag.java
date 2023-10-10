package bay.university.taglib;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

public class SexTag extends BodyTagSupport {
    private String maleLabel;
    private String femaleLabel;

    public void setMaleLabel(String maleLabel) {
        this.maleLabel = maleLabel;
    }

    public void setFemaleLabel(String femaleLabel) {
        this.femaleLabel = femaleLabel;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<input type='radio' name='sex' value='male'/>" + maleLabel);
            pageContext.getOut().write("<input type='radio' name='sex' value='female'/>" + femaleLabel);
        } catch (Exception e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}