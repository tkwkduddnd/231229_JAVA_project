package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements DAO {
    private Connection conn;
    private PreparedStatement pst;
    private String query = "";

    public ProductDAOImpl() {
        DatabaseConnection dbc = DatabaseConnection.getInstance();
        conn = dbc.getConnection();
    }

    @Override
    public int insert(ProductVO p) {
        int result = 0;
        query = "INSERT INTO product(pname, price, madeby) VALUES (?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, p.getPname());
            pst.setInt(2, p.getPrice());
            pst.setString(3, p.getMadeby());

            result = pst.executeUpdate();

            pst.close();
        } catch (SQLException e) {
        	System.out.println("insert Error");
            e.printStackTrace();
        }
        return result;
    }

	@Override
	public List<ProductVO> selectList() {
		// TODO Auto-generated method stub
		System.out.println("list DAOImpl success");
		query="select * from product order by pno desc";
		List<ProductVO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			// list => executeQuery(); => return ResultSet
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price")));
			}
			return list;
		}
		catch(SQLException e) {
			System.out.println("list error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO selectOne(int pno) {
		// TODO Auto-generated method stub
		query="select * from product where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new ProductVO(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby")
						);
			}
		}
		catch (SQLException e) {
			System.out.println("detail error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(ProductVO p) {
		// TODO Auto-generated method stub
		System.out.println("update DAOImpl success");
		query = "update product set pname=?, price=?,madeby=?, regdate=now() where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			return pst.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("update error");
			e.printStackTrace();
		}
		return 0;
	}

	 @Override
	    public int delete(int pno) {
	        int result = 0;
	        query = "DELETE FROM product WHERE pno = ?";
	        try {
	            pst = conn.prepareStatement(query);
	            pst.setInt(1, pno);
	            
	            result = pst.executeUpdate();
	            
	            pst.close();
	        } catch (SQLException e) {
	            System.out.println("delete Error");
	            e.printStackTrace();
	        }
	        return 0;
	    }
	}
