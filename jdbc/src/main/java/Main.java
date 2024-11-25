import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 메모리에 JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 데이터베이스 연결
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/edu10", "edu10", "edu10p");

        // SQL 준비
        //PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM member");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM member WHERE id=?");

        preparedStatement.setInt(1, 3);
        // 실행한 후 결과 셋을 가져온다
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Member member = new Member(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getInt("age"));
            System.out.println("member = " + member);
        }

        preparedStatement.setInt(1, 2);
        // 실행한 후 결과 셋을 가져온다
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Member member = new Member(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("age"));
            System.out.println("member = " + member);
        }

        connection.close();
    }
}

