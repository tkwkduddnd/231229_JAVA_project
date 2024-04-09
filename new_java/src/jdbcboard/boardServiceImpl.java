package jdbcboard;

//boardServiceImpl.java
import java.util.List;

public class boardServiceImpl implements boardService {
 private DAO dao;

 public boardServiceImpl() {
     this.dao = new boardDAOImpl();
 }

 @Override
 public int remove(int bno) {
     return dao.delete(bno);
 }

 @Override
 public List<boardVO> getList() {
     return dao.selectList();
 }

 @Override
 public int register(boardVO b) {
     return dao.insert(b);
 }

 @Override
 public boardVO getDetail(int bno) {
     return dao.selectOne(bno);
 }

 @Override
 public int modify(boardVO p) {
     return dao.update(p);
 }
}
