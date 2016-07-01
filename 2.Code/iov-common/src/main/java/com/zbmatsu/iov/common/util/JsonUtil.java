package com.zbmatsu.iov.common.util;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;



/**
 * 对ObjectMapper重新封装, 方便调用
 *
 * 用法:
 *   1. JsonUtil.toJSONString()
 *   2. JsonUtil.toBean()
 *   3. JsonUtil.mapper.writeValueAsString()
 *   ...
 */
public class JsonUtil extends ObjectMapper{

	public static final JsonUtil mapper = new JsonUtil();
    static {
        mapper.setDateFormat(new SimpleDateFormat("yyyyMMddHHmmss"));
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        mapper.setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.DEFAULT);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public JsonUtil(){
        super();
    }

    public static String toJSONString(Object o) throws Exception{
        return mapper.writeValueAsString(o);
    }

    @SuppressWarnings("unchecked")
	public static <T> T toBean(String json, Class<?> clazz) throws Exception{
        return (T)mapper.readValue(json, clazz);
    }
}
