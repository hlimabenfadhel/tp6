package com.hlima.livres.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hlima.livres.entities.Livre;
import com.hlima.livres.service.LivreService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class LivreRESTController {
@Autowired
LivreService livreService;
@RequestMapping(method = RequestMethod.GET)
public List<Livre> getAllLivres() {
return livreService.getAllLivres();
}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Livre getLivreById(@PathVariable("id") Long id) {
return livreService.getLivre(id);

}


@RequestMapping(method = RequestMethod.POST)
public Livre createProduit(@RequestBody Livre livre) {
return livreService.saveLivre(livre);
}

@RequestMapping(method = RequestMethod.PUT)
public Livre updateLivre(@RequestBody Livre livre) {
return livreService.updateLivre(livre);
}

@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteLivre(@PathVariable("id") Long id)
{
livreService.deleteLivreById(id);
}

@RequestMapping(value="/prodscat/{idBib}",method = RequestMethod.GET)
public List<Livre> getLivresByCatId(@PathVariable("idBib") Long idBib) {
return livreService.findByBibliothequeIdBib(idBib);
}
}
