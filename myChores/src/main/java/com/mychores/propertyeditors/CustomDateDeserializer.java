package com.mychores.propertyeditors;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

  private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

  @Override
  public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext) throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim();
    try {
      return (StringUtils.isEmpty(str) ? null : dateFormat.parse(str));
    } 
    catch (ParseException e) {
      System.out.println("something went wrong man");
    }
    return paramDeserializationContext.parseDate(str);
  }

}
