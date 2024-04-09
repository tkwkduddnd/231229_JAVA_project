package jdbcboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class boardDAOImpl implements DAO {
    private Connection conn;
    private PreparedStatement pst;
    private String query = "";

    public boardDAOImpl() {
        DatabaseConnection dbc = DatabaseConnection.getInstance();
        conn = dbc.getConnection();
    }

    @Override
    public int insert(boardVO b) {
        int result = 0;
        query = "INSERT INTO board(title, writer, content) VALUES (?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, b.getTitle());
            pst.setString(2, b.getWriter());
            pst.setString(3, b.getContent());

            result = pst.executeUpdate();

            pst.close();
        } catch (SQLException e) {
            System.out.println("Insert Error");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<boardVO> selectList() {
        List<boardVO> list = new ArrayList<>();
        query = "SELECT * FROM board ORDER BY bno DESC";
        try {
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new boardVO(
                        rs.getInt("bno"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getString("content"),
                        rs.getString("regdate"),
                        rs.getString("moddate")
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Select List Error");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boardVO selectOne(int bno) {
        query = "SELECT * FROM board WHERE bno=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, bno);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new boardVO(
                        rs.getInt("bno"),
                        rs.getString("title"),
                        rs.getString("writer"),
                        rs.getString("content"),
                        rs.getString("regdate"),
                        rs.getString("moddate")
                );
            }
        } catch (SQLException e) {
            System.out.println("Select One Error");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(boardVO b) {
        query = "UPDATE board SET title=?, writer=?, content=?, moddate=now() WHERE bno=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, b.getTitle());
            pst.setString(2, b.getWriter());
            pst.setString(3, b.getContent());
            pst.setInt(4, b.getBno());
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update Error");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int bno) {
        query = "DELETE FROM board WHERE bno=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, bno);
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete Error");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int remove(int bno) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<boardVO> selectlist() {
        // TODO Auto-generated method stub
        return null;
    }
}
