package jdbc;

import java.util.List;

public interface DAO {

	int insert(ProductVO p);

	List<ProductVO> selectList();

	ProductVO selectOne(int pno);

	int update(ProductVO p);

	int delete(int pno);

}
