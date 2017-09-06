package com.shifeng.util;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Json 格式化double数据  保留两位小数
 * 使用方法   @JsonSerialize(using = CustomDoubleSerialize.class) 此注解用于属性或者getter方法上
 * @author WinZhong
 *
 */
public class CustomDoubleSerialize extends JsonSerializer<Double> {  
	  
    private DecimalFormat df = new DecimalFormat("##.00");  
  
    @Override  
    public void serialize(Double value, JsonGenerator jgen,  
            SerializerProvider provider) throws IOException,  
            JsonProcessingException {  
  
        jgen.writeString(df.format(value));  
    }  
}  