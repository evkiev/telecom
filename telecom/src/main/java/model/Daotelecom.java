package model;

import database.DatabaseConnector;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

public class Daotelecom<T, K> {
	private Class<T> entityClass;
	private Class<K> keyClass;
	private Connection connection;

	
	private static class TableColumn {
		String columnName;
		Class columnType;
		String dbColumnType;
		String fieldName;

		TableColumn(String fieldName, String columnName, Class columnType) {
			this.columnName = columnName;
			this.columnType = columnType;
			this.fieldName = fieldName;
		}

		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public Class getColumnType() {
			return columnType;
		}

		public void setColumnType(Class columnType) {
			this.columnType = columnType;
		}

		public String getDbColumnType() {
			return dbColumnType;
		}

		public void setDbColumnType(String dbColumnType) {
			this.dbColumnType = dbColumnType;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
	}

	public Daotelecom(Class<T> entityClass, Class<K> keyClass) {
		this.connection = DatabaseConnector.getInstance().getConnection();
		this.entityClass = entityClass;
		this.keyClass = keyClass;
	}

	public T getById(K id) {
		T entity = null;
		String select = "";
		String from = "";
		String where = " where ";
		String idFieldName = "";

		Annotation[] annotations = entityClass.getAnnotations();

		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(Table.class)) {
				from += ((Table) annotation).name();
			}
		}

		from = (from.equals("")) ? " from " + entityClass.getName() : " from " + from;

		java.lang.reflect.Field[] fields = entityClass.getDeclaredFields();
		List<TableColumn> columnList = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {

			if (field.isAnnotationPresent(Column.class) | field.isAnnotationPresent(Id.class)) {
				for (Annotation annotation : field.getAnnotations()) {
					String selectField = "";
					String columnName = "";

					if (annotation.annotationType().equals(Column.class)) {
						columnName = ((Column) annotation).name();
						selectField = (columnName == null || columnName.equals("")) ? field.getName() : columnName;
					} else {
						if (annotation.annotationType().equals(Id.class)) {
							columnName = ((Column) annotation).name();
							idFieldName = selectField = (columnName == null || columnName.equals("")) ? field.getName()
									: columnName;
						}
					}
					columnList.add(new TableColumn(field.getName(), selectField, field.getType()));
					selectField += ",";

					select += selectField;
				}

			}
		}

		select = "select " + select.replaceAll(",$", "");

		try {
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement(select + from + where + idFieldName + "=?");
			preparedStatement.setString(1, String.valueOf(id));
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				arrangeDatabaseTypes(columnList, resultSet.getMetaData());

				entity = entityClass.getConstructor().newInstance();
				for (TableColumn tableColumn : columnList) {
					Object columnValue = getValue(resultSet, tableColumn.columnName, tableColumn.dbColumnType);
					String methodName = "set" + Character.toUpperCase(tableColumn.getFieldName().charAt(0))
							+ tableColumn.getFieldName().substring(1);
					Method setMethod = entityClass.getDeclaredMethod(methodName, tableColumn.columnType);
					setMethod.invoke(entity, columnValue);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return entity;
	}

	private void arrangeDatabaseTypes(List<TableColumn> tableColumns, java.sql.ResultSetMetaData resultSetMetaData)
			throws SQLException {

		String[] columnNames = getColumnNames(resultSetMetaData);

		for (TableColumn tableColumn : tableColumns) {
			int columnIndex = getNameIndex(tableColumn.columnName, columnNames);
			String dbType = resultSetMetaData.getColumnTypeName(columnIndex + 1);
			tableColumn.setDbColumnType(dbType);
		}
	}

	private int getNameIndex(String name, String[] names) {
		for (int i = 0; i < names.length; i++) {
			if (name.equals(names[i])) {
				return i;
			}
		}
		return -1;
	}

	private String[] getColumnNames(java.sql.ResultSetMetaData resultSetMetaData) throws SQLException {
		String[] columns = new String[resultSetMetaData.getColumnCount()];

		for (int i = 0; i < columns.length; i++) {
			columns[i] = resultSetMetaData.getColumnName(i + 1);
		}
		return columns;
	}

	// 	private String[] getColumnTypes(ResultSetMetaData resultSetMetaData)
	// throws SQLException {
	// String[] types = new String[resultSetMetaData.getColumnCount()];
	//
	// for (int i = 0; i < types.length; i++) {
	// types[i] = resultSetMetaData.getColumnTypeName(i + 1);
	// }
	// return types;
	// }

	private Object getValue(ResultSet resultSet, String columnName, String columnType) throws SQLException {
		switch (columnType) {
		case "INT":
		case "BIGINT":
			return resultSet.getInt(columnName);
		case "DATE":
			return resultSet.getDate(columnName);
		case "DATETIME":
		case "TIMESTAMP":
			return resultSet.getTimestamp(columnName);
		case "CHAR":
		case "VARCHAR":
			return resultSet.getString(columnName);
		case "FLOAT":
			return resultSet.getFloat(columnName);
		case "DOUBLE":
			return resultSet.getDouble(columnName);
		case "BOOLEAN":
			return resultSet.getBoolean(columnName);
		default:
			return resultSet.getString(columnName);
		}
	}

}
