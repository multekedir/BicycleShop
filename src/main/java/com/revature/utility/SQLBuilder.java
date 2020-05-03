package com.revature.utility;

/**
 * Builder class for building SQL statements
 * User: julian3
 * Date: 2013/11/10
 * Time: 7:16 PM
 * PROJECT: ${PROJECT}
 * DESCRIPTION:
 */
public class SQLBuilder {


    public static String insertInto(String tableName, String... columns) {

        StringBuilder builder = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        for (String column : columns) {
            builder.append(column).append(',');
        }
        builder.deleteCharAt(builder.length() - 1).append(") VALUES (");
        for (String column : columns) {
            builder.append("?,");
        }
        builder.deleteCharAt(builder.length() - 1).append(");");
        return builder.toString();
    }


    public static String update(String tableName, String whereColumn, String... columns) {
        StringBuilder builder = new StringBuilder("UPDATE ").append(tableName).append(" SET ");
        for (String column : columns) {
            builder.append(column).append("=?,");
        }
        return builder.deleteCharAt(builder.length() - 1).append(" WHERE ").append(whereColumn).append("=?;").toString();
    }

    public static String selectWhere(String tableName, String operator, String... columns) {
        StringBuilder builder = new StringBuilder("SELECT  * FROM ").append(tableName).append(" WHERE ");
        for (String column : columns) {
            builder.append(column).append(" = ? ").append(operator + " ");
        }

        return builder.deleteCharAt(builder.length() - 2).toString() + ";";
    }




//    public static String createTable(String schema, String tableName,  Pair<String, Pair<String, Boolean>> ... columns) {
//        StringBuilder builder = new StringBuilder("CREATE TABLE ").append(getTableName(schema, tableName)).append("(\n");
//        for (Pair<String, Pair<String, Boolean>> column : columns) {
//            builder.append(column.getCar()).append(' ').append(column.getCdr().getCar());
//            if (column.getCdr().getCdr()) {
//                builder.append(" NOT NULL");
//            }
//            builder.append(',');
//        }
//        return builder.deleteCharAt(builder.length()-1).append(");").toString();
//
//    }

    public static String setPrimaryKey(String schema, String tableName, String primaryKeyName, String... columns) {
        StringBuilder builder = new StringBuilder("ALTER TABLE ")
                .append(tableName)
                .append('(')
                .append("ADD CONSTRAINT ")
                .append(primaryKeyName)
                .append(" PRIMARY KEY (");
        for (String column : columns) {
            builder.append(column).append(",");
        }

        return builder.deleteCharAt(builder.length() - 1).append(");").toString();

    }


}