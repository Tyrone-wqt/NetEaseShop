package com.wqt.Handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lenovo on 2018/3/7.
 */
public class EmptyIntegerIfNull implements TypeHandler<Integer> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Integer integer, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Integer getResult(ResultSet resultSet, String s) throws SQLException {
        return (resultSet.getString(s) == null) ? Integer.valueOf(0) : Integer.valueOf(resultSet.getString(s));
    }

    @Override
    public Integer getResult(ResultSet resultSet, int i) throws SQLException {
        return (resultSet.getString(i) == null) ? Integer.valueOf(0) : Integer.valueOf(resultSet.getString(i));

    }

    @Override
    public Integer getResult(CallableStatement callableStatement, int i) throws SQLException {
        return (callableStatement.getString(i) == null) ? Integer.valueOf(0) : Integer.valueOf(callableStatement.getString(i));
    }
}
