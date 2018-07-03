package com.library.app.customeditor;

import java.beans.PropertyEditorSupport;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.web.util.HtmlUtils;

public class CustomInputEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String x) throws IllegalArgumentException {
			if(x==null) {
				this.setValue(null);
			}else {
				try{
					this.setValue(HtmlUtils.htmlEscape(x, "UTF-8"));
				}catch(Exception e){
					this.setValue(null);
				}
			}
			
		}

}
