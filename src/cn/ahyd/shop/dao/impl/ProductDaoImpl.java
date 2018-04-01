package cn.ahyd.shop.dao.impl;



import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.ahyd.shop.dao.ProductDao;
import cn.ahyd.shop.model.Product;


public class ProductDaoImpl implements ProductDao {
	
/*	@Override
	protected Product getRow(ResultSet rs) throws SQLException {
		
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setRemark(rs.getString("remark"));
		return product;
		
	}*/
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* (non-Javadoc)
	 * @see cn.ahyd.shop.dao.ProductDao#queryByBame(java.lang.String)
	 */
	@Override
	public List<Product> queryByBame(String name){
		
		String sql = "select * from product where name like ?";
		return jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, new BeanPropertyRowMapper<Product>(Product.class));
		}
	
	
	/* (non-Javadoc)
	 * @see cn.ahyd.shop.dao.ProductDao#queryByBame(java.lang.String, int, int)
	 */
	@Override
	public List<Product> queryByBame(String name, int page, int size){
		
		String sql = "select id,name,price from product where name like ? limit ?,?";
		return jdbcTemplate.query(sql, new Object[] { "%" + name + "%",
				(page - 1) * size, size },new BeanPropertyRowMapper<Product>(Product.class));
	}	
	
	
	
	/* (non-Javadoc)
	 * @see cn.ahyd.shop.dao.ProductDao#getById(int)
	 */
	@Override
	public Product getById(int id) {
		String sql = "select * from product where id = ?";
	   
		return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Product>(Product.class), id);
		
		
	}
	
/*	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		// 接口是不能new,除非实现了接口的定义的所有方法
		return jdbcTemplate.queryForObject(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setRemark(rs.getString("remark"));
				return product;
			}

		}, id);
	}*/
	
	
	/* (non-Javadoc)
	 * @see cn.ahyd.shop.dao.ProductDao#save(cn.ahyd.shop.model.Product)
	 */
	@Override
	public void save(Product product) {
		System.out.println(product.getPrice());
		String sql = "insert into product (name,price,remark,pic) values (?,?,?,?)";

		jdbcTemplate.update(sql, new Object[] { product.getName(), product.getPrice(),
				product.getRemark(), product.getPic()});

	}

	/* (non-Javadoc)
	 * @see cn.ahyd.shop.dao.ProductDao#update(cn.ahyd.shop.model.Product)
	 */
	@Override
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id=?";

		jdbcTemplate.update(sql, new Object[] { product.getName(), product.getPrice(),
				product.getRemark(), product.getId()});

	}

	/* (non-Javadoc)
	 * @see cn.ahyd.shop.dao.ProductDao#delete(int)
	 */
	@Override
	public void delete(int i) {
		String sql = "delete from product  where id=?";

		jdbcTemplate.update(sql, new Object[] { new Integer(i) });

	}


	
	
	/*
	public Product getByid(int id){
		Product product = null;
		String sql = "select * from product  where id=?";
		Connection conn = null; PreparedStatement pre = null; ResultSet rs = null;
		
		conn = JdbcUtil.getConnection();
		 try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			if(rs.next()){
				
				product = new Product();
				product.setName(rs.getString("name"));
				product.setPrice(new Double(rs.getDouble("price")));
				product.setRemark(rs.getString("remark"));
				
			}
			return product;
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		}finally{
			JdbcUtil.close(conn, pre, rs);
		}
	}*/


	/*public ArrayList<Product> queryByBame(String name){
		ArrayList<Product> proList = new ArrayList<Product>();
		String sql = "select * from product where name like ?";
		
		
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		
		
		try {
			
			conn = JdbcUtil.getConnection();
			pre = conn.prepareStatement(sql);
			pre.setString(1,"%" + name + "%");
			rs = pre.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				proList.add(product);				
			}
			return proList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, pre, rs);
		}
	
	}
*/	

}

/*
 * public class ProductDaolmpl {
 * 
 * public void save(Product product) {
 * 
 * String sql = "insert into product (name,price,remark) values (?,?,?)";
 * 
 * Connection connection = JdbcUtil.getConnection();
 * 
 * PreparedStatement pre;
 * 
 * try { pre = connection.prepareStatement(sql);
 * 
 * pre.setString(1, product.getName()); pre.setDouble(2,
 * product.getPrice().doubleValue()); pre.setString(3, product.getRemark());
 * 
 * pre.executeUpdate();
 * 
 * connection.close();
 * 
 * } catch (Exception e) { throw new RuntimeException(e);
 * 
 * } }
 * 
 * 
 * 
 * public void update(Product product) {
 * 
 * String sql = "update product set name=?,price=?,remark=? where id=?";
 * 
 * Connection connection = JdbcUtil.getConnection();
 * 
 * PreparedStatement pre;
 * 
 * try { pre = connection.prepareStatement(sql);
 * 
 * pre.setString(1, product.getName()); pre.setDouble(2,
 * product.getPrice().doubleValue()); pre.setString(3, product.getRemark());
 * pre.setInt(4, product.getId().intValue()); pre.executeUpdate();
 * 
 * connection.close();
 * 
 * } catch (Exception e) { throw new RuntimeException(e);
 * 
 * } }
 * 
 * public void delet(int i) {
 * 
 * String sql = "delete from product  where id=?";
 * 
 * Connection connection = JdbcUtil.getConnection();
 * 
 * PreparedStatement pre;
 * 
 * try { pre = connection.prepareStatement(sql);
 * 
 * 
 * pre.setInt(1,i);
 * 
 * pre.executeUpdate();
 * 
 * connection.close();
 * 
 * } catch (Exception e) { throw new RuntimeException(e);
 * 
 * } } }
 */