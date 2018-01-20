package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Cliente;
import entity.Produto;

public class ProdutoDao extends Dao{

	public void create(Produto p) throws Exception {
		open();
		stmt = con.prepareStatement("insert into produto values(null,?,?)");
		stmt.setString(1, p.getNome());
		stmt.setDouble(2, p.getPreco());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public List<Produto> findAll()throws Exception{
		open();
		stmt = con.prepareStatement("select * from produto ");
		rs = stmt.executeQuery();
		List<Produto> dados = new ArrayList<>();
		while(rs.next()){
			Produto p = new Produto();
			 p.setId(rs.getInt("id"));
			 p.setNome(rs.getString("nome"));
			 p.setPreco(rs.getDouble("preco"));
			dados.add(p);
		}
		close();
		return dados;
	}
	
 public static void main(String[] args) {
	 try {
		 new ProdutoDao().create(new Produto(null,"feijao",300.));
		 new ProdutoDao().create(new Produto(null,"xanxung",100.));
		 
		 System.out.println("Tabelas geradas ...");
		 
	 }catch(Exception ex) {
		 System.out.println("Error :" + ex.getMessage());
	 }
	 
	 
}
	
	
}
