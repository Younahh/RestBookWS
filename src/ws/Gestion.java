package ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Livre;
import beans.Panier;
import beans.User;
import dao.LivreDAO;
import dao.PanierDAO;
import dao.UserDAO;

@Path("gestion")
public class Gestion {
	
	@GET
	@Path("chercherLivreId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Livre chercherLivreId(@PathParam("id") int id) {
		return LivreDAO.chercherLivreId(id);
	}
	
	@GET
	@Path("chercherLivre/{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Livre chercherLivre(@PathParam("nom") String nom) {
		return LivreDAO.chercherLivre(nom);
	}
	
	@GET
	@Path("chercherLivreCategorie/{categorie}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livre> chercherLivreCategorie(@PathParam("categorie") String categorie) {
		return LivreDAO.chercherLivreCategorie(categorie);
	}
	
	@GET
	@Path("chercherLivreNouveautes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livre> chercherLivreNouveautes() {
		return LivreDAO.chercherLivreNouveautes();
	}
	
	@POST
	@Path("ajouterLivre")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterLivre(Livre livre) {
		LivreDAO.ajouterLivre(livre);
	}
	
	@PUT
	@Path("modifierLivre/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifierLivre(@PathParam("id") int id) {
		LivreDAO.modifierLivre(id);
	}
	
	@PUT
	@Path("modifierLivreNbr/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifierLivreNbr(@PathParam("id") int id) {
		LivreDAO.modifierLivreNbr(id);
	}
	
	@DELETE
	@Path("supprimerLivre/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void supprimerLivre(@PathParam("id") int id) {
		LivreDAO.supprimerLivre(id);
	}
	
	@GET
	@Path("authentifierUser/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public User authentifierUser(@PathParam("email") String email, @PathParam("password") String password) {
		return UserDAO.authentifierUser(email, password);
	}
	
	@GET
	@Path("chercherUser/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User chercherUser(@PathParam("email") String email) {
		return UserDAO.chercherUser(email);
	}
	
	@POST
	@Path("ajouterUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterUser(User user) {
		UserDAO.ajouterUser(user);
	}
	
	@PUT
	@Path("modifierUser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifierUser(@PathParam("id") int id) {
		UserDAO.modifierUser(id);
	}
	
	@DELETE
	@Path("supprimerUser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void supprimerUser(@PathParam("id") int id) {
		UserDAO.supprimerUser(id);
	}
	
	@GET
	@Path("chercherPanier/{idd}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Panier> chercherPanier(@PathParam("idd") int idd) {
		return PanierDAO.chercherPanier(idd);
	}
	
	@POST
	@Path("ajouterPanier")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterPanier(Panier panier) {
		PanierDAO.ajouterPanier(panier);
	}
	
	@DELETE
	@Path("supprimerPanierIdd/{idd}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void supprimerPanierIdd(@PathParam("idd") int idd) {
		PanierDAO.supprimerPanierIdd(idd);
	}
	
	@DELETE
	@Path("supprimerPanier/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void supprimerPanier(@PathParam("id") int id) {
		PanierDAO.supprimerPanier(id);
	}

}
