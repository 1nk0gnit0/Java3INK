package Lesson2.server;

import java.sql.*;

public interface AuthService {

    String getNick(String login, String pass);

    void connect();

    void disconnect();
}

class AuthServiceImpl implements AuthService {

    private static Connection connection;
    private static Statement statement;


    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:db");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNick(String login, String pass) {
        String query = String.format("select nick from users\n"
                + "where login = '%s'\n"
                + "  and password = '%s'\n", login, pass);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

