package com.cardapio.rest;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.cardapio.model.Cardapio;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Path("resources")
public class ResourcesRest {
	BancoDeDados banco = new BancoDeDados();
	
	@POST
	@Path("savarCardapio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserirCardapio(Cardapio cardapio){
		try {
			banco.conectar();
			banco.inserirCardapio(cardapio.getTipo(),cardapio.getNome());
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			System.out.println("Deu ruim");
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();	
		}
	}
	

//}
	
//	
//	
//	
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("cardapio/{tipo}")
//	public String getCardapio(@PathParam("tipo") String tipo) {
//		return tipo;
//	}
//	
//	
//	
//
//	//Usu·rio e jwt
//	@GET
//	@Path("usuarios/{getNomeDeUsuario}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response getUsuario(
//			@HeaderParam("Authorization") String token,
//			@PathParam("NomeDeUsuario") String nomeDeUsuario) {
//		
//		Claims claim;
//		try {
//			claim = Jwts.parser().setSigningKey("ChaveJwt")
//					.parseClaimsJws(token).getBody();
//		}catch (Exception e) {
//			e.printStackTrace();
//			return Response.status(Status.UNAUTHORIZED).build();
//		}
//		//Acredito que n„o ser· necess·rio essa parte, pois vai ser salvo no BD
////		List<Aluno> alunos = new ArrayList<>();
////		alunos.add(new Aluno(123, "Robson Ferreira"));
////		alunos.add(new Aluno(456, "Thiago Mesquita"));
////		alunos.add(new Aluno(789, "Anderson Pereira"));
////		
////		for (Aluno aluno : alunos ) {
////			if(aluno.getMatricula().equals(matricula))
////				return Response.status(Status.OK).entity(aluno).build();
////		}
//		return Response.status(Status.NOT_FOUND).build();
//	}
//
//    //Validar usuario pelo token
//	@GET
//    @Path("validar-usuario")
//	public void validarUsuario(
//			 @HeaderParam("Authorization") String authorization) {
//		
//		if(!authorization.equals("querty")) {
//			throw new NotAuthorizedException("Token inv√°lido");
//		}
//	}
//    
//    //Guardar usu√°rio com suas informa√ß√µes declarada em sua classe
//	@POST
//	@Path("usuarios")
//	public Response salvarUsuario(Usuario usuario) {  
//		System.out.println("Nome Completo: "+usuario.getNomeCompleto());
//		System.out.println("Nome de Usu√°rio: "+usuario.getUserName());
//		System.out.println("Email: "+usuario.getEmail());
//		System.out.println("Senha: "+usuario.getSenha());
//		//TODO l√≥gica para salvar o usuario
//		
//		
//		return Response.status(Status.CREATED).entity(usuario).build();
//	}
//
//    //Fazer upload da imagem de perfil do usu·rio
//    @POST
//	@Path("upload")
//	@Consumes("multipart/form-data")
//    public Response upload(@FormDataParam("arquivo") InputStream arquivoInputStream,
//    		               @FormDataParam("arquivo") FormDataContentDisposition arquivoMetaData) {
//		try {
//			System.out.println("Upload de arquivo: "+ arquivoMetaData.getFileName());
//			
//			BufferedImage image = ImageIO.read(arquivoInputStream);
//			if(image == null) {
//				return Response.status(Status.BAD_REQUEST)
//						.entity("Arquivo enviado n√£o √© uma imagem v√°lida para o perfil.").build();
//			}
//				//TODO tratar e salvar a imagem enviada
//				
//				return Response.status(Status.OK).build();
//			}catch(Exception e) {
//				e.printStackTrace();
//				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
//			
//
//			}
//	}
}
