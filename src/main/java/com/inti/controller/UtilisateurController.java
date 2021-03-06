package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired 
	IUtilisateurService utilisateurService;

	/*@GetMapping("users") 
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}*/

	@GetMapping("users/{idU}")
	public Utilisateur findOne(@PathVariable("idU") Long idUtilisateur) { 
		return utilisateurService.findOne(idUtilisateur);
	}

	@PostMapping("users")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur user) {
		return utilisateurService.save(user);
	}

	@DeleteMapping("users/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
		utilisateurService.delete(idUtilisateur);
	}

	@PutMapping("users/{idU}")
	public Utilisateur updateUtilisateur(@PathVariable("idU") Long idUtilisateur, @RequestBody Utilisateur user) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(idUtilisateur);
		currentUtilisateur.setNomUtilisateur(user.getNomUtilisateur());
		currentUtilisateur.setPrenomUtilisateur(user.getPrenomUtilisateur());
		currentUtilisateur.setUsername(user.getUsername());
		currentUtilisateur.setPassword(user.getPassword());
		currentUtilisateur.setRoles(user.getRoles());
		return utilisateurService.save(currentUtilisateur);
	}
	@GetMapping("users")
	public int nbrUtilisateurs() {
		return utilisateurService.nbrUtilisateurs();
	}
}

