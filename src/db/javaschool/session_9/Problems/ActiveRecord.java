package db.javaschool.session_9.Problems;

import db.javaschool.session_8.DatabaseManager;
import db.javaschool.session_8.DatabaseObject;
import db.javaschool.session_9.AnnotationFieldExample;

import java.lang.reflect.Field;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;

public class ActiveRecord {
    DatabaseManager databaseManager;

    public ActiveRecord(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void update(DatabaseObject databaseObject) {
        String tableName = getTableName(databaseObject);
        String primaryKey = getPrimaryKey(databaseObject);
        HashMap<String, String> hashMap = getDatabaseObjectData(databaseObject, true);
        String statement = "UPDATE " + tableName + " SET ";

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            statement += entry.getKey() + " = " + entry.getValue() + " ,";
        }
        statement = statement.substring(0, statement.length() - 1);
        statement = statement + " WHERE " + primaryKey + " = " + hashMap.get(primaryKey);
        System.out.println(statement);
        try {
            Connection connection = databaseManager.connection;
            Statement st = connection.createStatement();
            st.execute(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public String getTableName(DatabaseObject databaseObject) {
        Class<?> clazz = databaseObject.getClass();
        if (clazz.isAnnotationPresent(ActiveRecordEntity.class)) {
            ActiveRecordEntity ac = clazz.getAnnotation(ActiveRecordEntity.class);
            return ac.tableName();
        }
        throw new RuntimeException("Class is not annotated");
    }

    public String getPrimaryKey(DatabaseObject databaseObject) {
        Class<?> clazz = databaseObject.getClass();
        if (clazz.isAnnotationPresent(ActiveRecordEntity.class)) {
            ActiveRecordEntity ac = clazz.getAnnotation(ActiveRecordEntity.class);
            return ac.primaryKey();
        }
        throw new RuntimeException("Class is not annotated");
    }

    public List<?> select(DatabaseObject databaseObject) {
        return new ArrayList<>();
    }

    public HashMap<String, String> getDatabaseObjectData(DatabaseObject databaseObject, boolean formatForSQL) {
        HashMap<String, String> hashMap = new HashMap<>();
        Field[] fields = databaseObject.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true); // if private
                Class<?> fieldType = field.getType();

                String columnName = null;
                if (field.isAnnotationPresent(Column.class)) {
                    columnName = field.getAnnotation(Column.class).value();
                }

                String columnValue = null;
                if (fieldType.isAssignableFrom(String.class)) {
                    columnValue = (String) field.get(databaseObject);
                    if (formatForSQL)
                        columnValue = "'" + columnValue + "'";
                } else if (fieldType.isPrimitive()) {
                    columnValue = field.get(databaseObject).toString();
                } else if (fieldType.isAssignableFrom(Date.class)) {
                    Date date = (Date) field.get(databaseObject);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    columnValue = simpleDateFormat.format(date);
                    if (formatForSQL)
                        columnValue = "'" + columnValue + "'";
                } else {
                    Object object = field.get(databaseObject);
                    if (object == null) {
                        if (formatForSQL)
                            columnValue = "NULL";
                    }
                }
                if (columnName != null)
                    hashMap.put(columnName, columnValue);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return hashMap;
    }

    public void setDatabaseObject(DatabaseObject databaseObject, Map<String, String> hashMap) {

        Field[] fields = databaseObject.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true); // if private
                Class<?> fieldType = field.getType();

                String columnName = null;
                if (field.isAnnotationPresent(Column.class)) {
                    columnName = field.getAnnotation(Column.class).value();
                }

                if (columnName == null)
                    continue;

                String columnValue = null;
                if (fieldType.isAssignableFrom(String.class)) {
                    columnValue = hashMap.get(columnName);
                    field.set(databaseObject, columnValue);
                } else if (fieldType.isPrimitive()) {
                    if (hashMap.get(columnName) == null)
                        continue;

                    if (fieldType.equals(Integer.TYPE)) {
                        field.setInt(databaseObject, Integer.parseInt(hashMap.get(columnName)));
                    } else if (fieldType.equals(Float.TYPE)) {
                        field.setFloat(databaseObject, Float.parseFloat(hashMap.get(columnName)));
                    }
                } else if (fieldType.isAssignableFrom(Date.class)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(sdf.parse(hashMap.get(columnName)).getTime());
                    field.set(databaseObject, date);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
