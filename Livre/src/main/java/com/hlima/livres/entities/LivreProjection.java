package com.hlima.livres.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomProd", types = { Livre.class })
public interface LivreProjection {
public String getNomLivre();
}