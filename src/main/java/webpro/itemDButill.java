package webpro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class itemDButill {
	private Connection con;
	private static String query;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public itemDButill(Connection con) {

		this.con = con;
		
	}
	public List<item> getAllItem(){
		List<item> item=new ArrayList<item>();
		
		try {
			query="select * from item";
			pst=this.con.prepareStatement(query);
			rs= pst.executeQuery();
			
			while (rs.next()) {
            	item row = new item();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImg(rs.getString("image"));
                item.add(row);
            }

			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public List<cart> getCartitem(ArrayList<cart> cartList){
		List<cart> item=new ArrayList<cart>();
		
		
		
		try {
			if(cartList.size()>0) {
				for(cart Item:cartList) {
					query="select * from item where id=?";
					pst=this.con.prepareStatement(query);
					pst.setInt(1,Item.getId());
					rs=pst.executeQuery();
					
					while(rs.next()) {
						cart row=new cart();
						row.setId(rs.getInt("id"));
						row.setCategory(rs.getString("category"));
						row.setName(rs.getString("name"));
						row.setPrice(rs.getDouble("price")*Item.getQuantity()); //calculate the total price
						row.setQuantity(Item.getQuantity());
						item.add(row);
						System.out.println(rs.getString("name"));
						
					}
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		return item;
	}
	public double getTotCartPrice(ArrayList<cart> cartList) {
		double sum=0;
		
		try {
			if(cartList.size()>0) {
				for(cart item:cartList) {
					query="select price from item where id=?";
					pst=this.con.prepareStatement(query);
					pst.setInt(1,item.getId());
					rs=pst.executeQuery();
					
					while(rs.next()) {
						sum+=rs.getDouble("price")*item.getQuantity();
						System.out.println(sum);
					}
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return sum;
		
	}
	
	
	
	public item getSingleProduct(int id) {
		 item row = null;
	        try {
	            query = "select * from products where id=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new item();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getDouble("price"));
	                row.setImg(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	
	
	
	
	
}
