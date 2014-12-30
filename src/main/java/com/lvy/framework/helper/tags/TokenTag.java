package com.lvy.framework.helper.tags;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

/**
 * Created by livvy on 14-5-13.
 */
public class TokenTag extends RequestContextAwareTag {
    private String name;
    private String id;
    private String cssStyle;
    private String cssClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    protected int doStartTagInternal() throws Exception {
        return 0;
    }
}
