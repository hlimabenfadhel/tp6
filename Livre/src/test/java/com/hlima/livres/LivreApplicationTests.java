package com.hlima.livres;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hlima.livres.entities.Bibliotheque;
import com.hlima.livres.entities.Livre;
import com.hlima.livres.repos.LivreRepository;
import com.hlima.livres.service.LivreService;

@SpringBootTest
class LivreApplicationTests {
@Autowired
private LivreRepository livreRepository;
@Autowired
private LivreService livreService;
@Test
public void testCreatelivre() {
Livre liv = new Livre("les miserables",7.500,new Date());
livreRepository.save(liv);
}
@Test
public void testFindLivre()
{
	Livre l = livreRepository.findById(1L).get();
System.out.println(l);
}
@Test
public void testUpdateLivre()
{
	Livre l = livreRepository.findById(1L).get();
l.setPrixLivre(10.700);
livreRepository.save(l);
}
@Test
public void testDeleteLivre()
{
livreRepository.deleteById(1L);;
}

@Test
public void testListerTousLivres()
{
List<Livre> livs = livreRepository.findAll();
for (Livre l : livs)
{
System.out.println(l);
}
}
@Test
public void testFindByNomLivreContains()
{
	Page<Livre> livs =livreService.getAllLivresParPage(0,2);
System.out.println(livs.getSize());
System.out.println(livs.getTotalElements());
System.out.println(livs.getTotalPages());
livs.getContent().forEach(l -> {System.out.println(l.toString());
 });
/*ou bien
for (Livre l : livs)
{
System.out.println(l);
} */
}

@Test
public void testFindByNomLivre()
{
List<Livre> livs = livreRepository.findByNomLivre("livre5");
for (Livre l : livs)
{
System.out.println(l);
}
}
@Test
public void testFindByNomLivreContains1 ()
{
List<Livre> livs=livreRepository.findByNomLivreContains("livre5");
for (Livre l : livs)
{
System.out.println(l);
} }

@Test
public void testfindByNomPrix()
{
List<Livre> livs = livreRepository.findByNomPrix("livre5", 1000.0);
for (Livre l : livs)
{
System.out.println(l);
}
}

@Test
public void testfindByBibliotheque()
{
	Bibliotheque bib = new Bibliotheque();
	bib.setIdBib(1L);
List<Livre> livs = livreRepository.findByBibliotheque(bib);
for (Livre l : livs)
{
System.out.println(l);
}

}
@Test
public void findByBibliothequeIdBib()
{
List<Livre> livs = livreRepository.findByBibliothequeIdBib(1L);
for (Livre l : livs)
{
System.out.println(l);
}
 }



@Test
public void testfindByOrderByNomLivreAsc()
{
List<Livre> livs =
livreRepository.findByOrderByNomLivreAsc();
for (Livre l : livs)
{
System.out.println(l);
}
}

@Test
public void testTrierLivresNomsPrix()
{
List<Livre> livs = livreRepository.trierLivresNomsPrix();
for (Livre l : livs)
{
System.out.println(l);
}
}

}
