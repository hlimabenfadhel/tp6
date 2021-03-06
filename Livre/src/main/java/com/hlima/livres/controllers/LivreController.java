package com.hlima.livres.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hlima.livres.entities.Livre;
import com.hlima.livres.service.LivreService;
@Controller
public class LivreController {
@Autowired
LivreService livreService;


@RequestMapping("/modifierLivre")
public String editerLivre(@RequestParam("id") Long id,ModelMap modelMap)
{
Livre l= livreService.getLivre(id);
modelMap.addAttribute("livre", l);
modelMap.addAttribute("mode", "edit");
return "formLivre";
}

@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
modelMap.addAttribute("livre", new Livre());
modelMap.addAttribute("mode", "new");
return "formLivre";
}
@RequestMapping("/saveLivre")
public String saveLivre(@Valid Livre livre,
BindingResult bindingResult)

{
if (bindingResult.hasErrors()) return "formLivre";
livreService.saveLivre(livre);
return "formLivre";
}



@RequestMapping("/ListeLivres")
public String listeLivres(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Livre> livs = livreService.getAllLivresParPage(page, size);
modelMap.addAttribute("livres", livs);
 modelMap.addAttribute("pages", new int[livs.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeLivres";
}





@RequestMapping("/supprimerLivre")
public String supprimerLivre(@RequestParam("id") Long id,
		ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
livreService.deleteLivreById(id);
Page<Livre> livs = livreService.getAllLivresParPage(page,size);

modelMap.addAttribute("livres", livs);
modelMap.addAttribute("pages", new int[livs.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeLivres";
}






@RequestMapping("/updateLivre")
public String updateLivre(@ModelAttribute("livre") Livre livre,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 livre.setDateCreation(dateCreation);

 livreService.updateLivre(livre);
 List<Livre> livs = livreService.getAllLivres();
 modelMap.addAttribute("livres", livs);
return "listeLivres";
}


}