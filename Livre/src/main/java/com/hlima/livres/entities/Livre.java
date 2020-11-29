package com.hlima.livres.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Livre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idLivre;


@NotNull
@Size (min = 4,max = 15)
private String nomLivre;

@Min(value = 10)
@Max(value = 10000)
private Double prixLivre;


@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;
@ManyToOne
private Bibliotheque bibliotheque;
public Livre() {
super();
}
public Bibliotheque getBibliotheque() {
	return bibliotheque;
}
public void setBibliotheque(Bibliotheque bibliotheque) {
	this.bibliotheque = bibliotheque;
}
public Livre(String nomLivre, Double prixLivre, Date dateCreation) {
super();
this.nomLivre = nomLivre;
this.prixLivre= prixLivre;
this.dateCreation = dateCreation;
}
public Long getIdLivre() {
return idLivre;
}
public void setIdLivre(Long idLivre) {
this.idLivre = idLivre;
}
public String getNomLivre() {
return nomLivre;
}
public void setNomLivre(String nomLivre) {
this.nomLivre = nomLivre;
}
public Double getPrixLivre() {
return prixLivre;
}
public void setPrixLivre(Double prixLivre) {
this.prixLivre = prixLivre;
}
public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}
@Override
public String toString() {
return "Livre [idLivre=" + idLivre + ", nomLivre=" +
nomLivre + ", prixLivre=" + prixLivre
+ ", dateCreation=" + dateCreation + "]";
}
}