package ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Cliente;
import entity.Produto;
 
import persistence.ProdutoDao;

@Path("/produto")
public class WSProduto {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/gravar/{nome}/{preco}/")
	public String gravar(@PathParam("nome") String nome, @PathParam("preco") String preco) {
		try {
			Produto p = new Produto(null, nome, new Double(preco));
			new ProdutoDao().create(p);
			return "Produto cadastrado";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cadastrar")
	public String cadastrar(String produto) {
		try {
			 System.out.println(produto);
		 	 Produto p = new Gson().fromJson(produto, Produto.class);
			 new ProdutoDao().create(p);
			return "Produto cadastrado";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public String listar() {
		try {
			return new Gson().toJson(new ProdutoDao().findAll());
		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		}
	}

}
