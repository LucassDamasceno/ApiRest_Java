package com.cardapio.rest;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.cardapio.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("auth")
public class Login {
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response login(Usuario usuario) {
		if(usuario.getUserName().equals("admin") && usuario.getSenha().equals("12345")) {
			
			String compactJws = Jwts.builder()
					.setSubject(usuario.getUserName())
					.setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS512, "ChaveJwt")
					.compact();
			return Response.status(Status.OK).entity(compactJws).build();
		}else {
			return Response.status(Status.UNAUTHORIZED)
					.entity("Email ou senha inválidos").build();
		}
	}
}
