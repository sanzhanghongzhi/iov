package com.zbmatsu.iov.common.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DateConver implements Converter<String, Date> {
	
	private static Logger logger=LoggerFactory.getLogger(DateConver.class);

	@Override
	public Date convert(String source) {
		logger.info("转换的时间source>>>>>>>>>>>"+source);
		if(source == null || source.length()==0) return null;
		String fromatString="yyyy-MM-dd";
		if(source.length() > 13) {
			fromatString="yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(fromatString);
	    dateFormat.setLenient(false);
	    try {
	        return dateFormat.parse(source);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

		return null;
	}

}

