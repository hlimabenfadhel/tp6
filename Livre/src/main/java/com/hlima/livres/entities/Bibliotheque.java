package com.hlima.livres.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bibliotheque {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idBib;
private String nomBib;
private String descriptionBib;
@JsonIgnore
@OneToMany(mappedBy = "bibliotheque")
private List<Livre> livres;
}
