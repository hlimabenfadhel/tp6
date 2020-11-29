package com.hlima.livres.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.hlima.livres.entities.Bibliotheque;
import com.hlima.livres.entities.Livre;
public interface LivreService {
Livre saveLivre(Livre l);
Livre updateLivre(Livre l);
void deleteLivre(Livre l);
void deleteLivreById(Long id);
Livre getLivre(Long id);
List<Livre> getAllLivres();
List<Livre> findByNomLivre(String nom);
List<Livre> findByNomLivreContains(String nom);
List<Livre> findByNomPrix (String nom, Double prix);
List<Livre> findByBibliotheque (Bibliotheque bibliotheque);
List<Livre> findByBibliothequeIdBib(Long id);
List<Livre> findByOrderByNomLivreAsc();
List<Livre> trierLivresNomsPrix();
Page<Livre> getAllLivresParPage(int page, int size);

}