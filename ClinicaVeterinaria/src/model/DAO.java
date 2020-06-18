package model;

import java.sql.*;

public abstract class DAO {

	static String username = "uehara_kevin";
    static String pass = "8%AluminA3";
    static String dbUrl = "jdbc:mysql://db4free.net:3306/vetpoo";
    private static Connection con;

    // metodo para criar a conexao com JavaDB
    public static Connection getConnection() {
        if (con == null) {
            try {
                //Class.forName(DRIVER).newInstance();
            	con = DriverManager.getConnection(dbUrl, username, pass);
                System.out.println(con.getClientInfo());
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            s.executeQuery(query);
            rs = s.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        ResultSet rs = null;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            rs = s.getResultSet();
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastId;
    }

    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}