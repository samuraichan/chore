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

/**
 * Custom deserializer for JSON properties bound to java.util.Date in order to handle the date formatting 
 * of MM/dd/yyyy
 * 
 * @author rchiari
 */
public class CustomDateDeserializer extends JsonDeserializer<Date> {

  private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

  @Override
  public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext) throws IOException, JsonProcessingException {
    String str = paramJsonParser.getText().trim();
    try {
      return (StringUtils.isEmpty(str) ? null : dateFormat.parse(str));
    } 
    catch (ParseException e) {
      throw new IllegalArgumentException(String.format(
          "Failed to parse Date value '%s': %s", str, e.getMessage()));
    }
  }

}
