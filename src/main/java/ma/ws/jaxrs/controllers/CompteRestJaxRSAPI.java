package ma.ws.jaxrs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.ws.jaxrs.entities.Compte;
import ma.ws.jaxrs.repositories.CompteRepository;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

  @Autowired
  private CompteRepository compteRepository;

  // READ: Récupérer tous les comptes (JSON et XML)
  @Path("/comptes")
  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public List<Compte> getComptes() {
    return compteRepository.findAll();
  }

  // READ: Récupérer un compte par son identifiant (JSON et XML)
  @Path("/comptes/{id}")
  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Compte getCompte(@PathParam("id") Long id) {
    return compteRepository.findById(id).orElse(null);
  }

  // CREATE: Ajouter un nouveau compte (JSON et XML)
  @Path("/comptes")
  @POST
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Compte addCompte(Compte compte) {
    return compteRepository.save(compte);
  }

    // UPDATE: Mettre à jour un compte existant (JSON et XML)
    @PUT
    @Path("/comptes/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
        Compte existingCompte = compteRepository.findById(id).orElse(null);
        if (existingCompte != null) {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setType(compte.getType());
            return compteRepository.save(existingCompte);
        }
        return null;
    }



  // DELETE: Supprimer un compte (JSON et XML)
  @Path("/comptes/{id}")
  @DELETE
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public void deleteCompte(@PathParam("id") Long id) {
    compteRepository.deleteById(id);
  }
}