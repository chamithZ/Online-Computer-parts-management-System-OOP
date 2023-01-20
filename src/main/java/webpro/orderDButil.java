package webpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class orderDButil {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public orderDButil(Connection con) {
		this.con=con;
		
	}
	
	

	public boolean insertOrder(order model) {
		boolean result=false;
		
		try {
			
			query="insert into `order` (`p_id`,`u_id`,`o_quantity`,`o_date`) values(?,?,?,?)";
			
			pst=this.con.prepareStatement(query);
			pst.setInt(1, model.getId());
			pst.setInt(2, model.getUid());
			pst.setInt(3, model.getQuantity());
			pst.setString(4,model.getDate());
			pst.executeUpdate();
			System.out.println("dsvsdvsdrrrr");
			result= true;
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<order> userOrder(int id){
		List<order> list =new ArrayList<>();
		
		try {
			
			query ="select * from `order` where `u_id`=? order by `order`.`o_id` desc";
			
			pst=this.con.prepareStatement(query);
			
			 rs = pst.executeQuery();
			System.out.println("heheeeeeeeee");
			while(rs.next()) {
				order odr=new order();
				itemDButill itdb=new itemDButill(this.con);
				int pId=rs.getInt("p_id");
				
				item itm=itdb.getSingleProduct(pId);
				
				odr.setOrderId(rs.getInt("`o_id`"));
				odr.setId(pId);
				odr.setCategory(itm.getCategory());
				odr.setPrice(itm.getPrice()*rs.getInt("`o_quantity`"));
				odr.setQuantity(rs.getInt("`o_quantity`"));
				odr.setDate(rs.getString("`o_date`"));
				list.add(odr);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}



	public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from `order` where `o_id`=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
	

}
