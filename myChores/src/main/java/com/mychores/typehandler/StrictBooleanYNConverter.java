package com.mychores.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes(value=Boolean.class)
@MappedJdbcTypes(value = { JdbcType.CHAR, JdbcType.VARCHAR })
public class StrictBooleanYNConverter implements TypeHandler<Boolean>
{
   
  // MyBatis Stuff

  @Override
  public void setParameter(PreparedStatement ps, int columnIndex,
      Boolean parameter, JdbcType jdbcType) throws SQLException
  {
    ps.setString(columnIndex, convertToDB(parameter));
  }

  @Override
  public Boolean getResult(CallableStatement cs, int columnIndex)
      throws SQLException
  {
    return convertFromDB(cs.getString(columnIndex));
  }

  @Override
  public Boolean getResult(ResultSet rs, String columnName) throws SQLException
  {
    return convertFromDB(rs.getString(columnName));
  }

  @Override
  public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException
  {
    return convertFromDB(rs.getString(columnIndex));
  }
  
  
  // Code that handles String/Boolean codec
  private Boolean convertFromDB(String value)
  {
    if ("Y".equals(value))
    {
      return Boolean.TRUE;
    } else if ("N".equals(value))
    {
      return Boolean.FALSE;
    } else
    {
      throw new IllegalArgumentException("Invalid value:" + value
          + "returned from database. Acceptable boolean values are Y and N.");
    }
  }
  
  private String convertToDB(Boolean value)
  {
    if (value == null)
      throw new IllegalArgumentException("NULL is not a valid boolean value");
    return value ? "Y" : "N";
  }

}
