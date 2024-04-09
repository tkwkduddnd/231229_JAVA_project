package jdbcboard;
import java.util.List;

public interface DAO {

    int remove(int bno);

    List<boardVO> selectlist();

    int insert(boardVO b);

    boardVO selectOne(int bno);

    int update(boardVO p);

    int delete(int bno);

	List<boardVO> selectList();

    

}
