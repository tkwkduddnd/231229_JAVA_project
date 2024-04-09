package jdbc;

import java.util.List;

public class ProductServiceImpl implements Service {

    private DAO dao;

    public ProductServiceImpl() {
        dao = new ProductDAOImpl();
    }

    public int register(ProductVO p) {
        System.out.println("register serviceImpl success");
        return dao.insert(p);
    }

	@Override
	public List<ProductVO> getlist() {
		// TODO Auto-generated method stub
		System.out.println("getlist serviceImpl success");
		return dao.selectList();
	}

	@Override
	public ProductVO getDetail(int pno) {
		// TODO Auto-generated method stub
		System.out.println("getDetail serviceImpl success");
		return dao.selectOne(pno);
	}

	@Override
	public int modify(ProductVO p) {
		// TODO Auto-generated method stub
		System.out.println("modify serviceImpl success");
		return dao.update(p);
	}

	@Override
	public int remove(int pno) {
		// TODO Auto-generated method stub
		System.out.println("delete serviceImpl success");
		return dao.delete(pno);
	}
}
