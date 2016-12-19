package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection =
                DriverManager.getConnection("jdbc:h2:file:D:/Java/Lesson/user_db",
                        "sa", "sa");
        JdbcTest jdbcTest = new JdbcTest();
        jdbcTest.dropTable(connection);
        jdbcTest.createTable(connection);
        jdbcTest.insertRecords(connection);
        jdbcTest.savePointExample(connection);

    }

    private void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE USER (id INT not NULL AUTO_INCREMENT, NAME VARCHAR (35) NOT NULL) ");
    }

    private void dropTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP  TABLE USER ");
    }

    private void insertRecords(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER(Name) VALUES (?)");
        for (int i = 0; i < 10; i++) {
            preparedStatement.setString(1, "user_name" + i);
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
    }

    private void savePointExample(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        Savepoint sp1 = connection.setSavepoint("sp1");
        String insertSql = "INSERT INTO USER(Name) VALUES ('XXX')";
        String selectSql = "select * from USER";

        Statement statement = connection.createStatement();
        statement.executeUpdate(insertSql);
        selectFromTable(selectSql, statement);
        System.out.println("------------------------------");
        connection.rollback(sp1);
        selectFromTable(selectSql, statement);
    }

    private void selectFromTable(String selectSql, Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(selectSql);

        while (resultSet.next()) {
            System.out.println("--->" + resultSet.getString("name"));
        }
    }
}
