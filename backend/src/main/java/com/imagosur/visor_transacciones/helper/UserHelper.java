package com.imagosur.visor_transacciones.helper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.imagosur.security.domain.User;
import com.imagosur.visor_transacciones.response.model.PuntoEntity;
import com.imagosur.security.SecurityUserDetails;

public class UserHelper {

    private static final Logger logger = LoggerFactory.getLogger(UserHelper.class);
    public User user;

    
    
    public UserHelper() {
    	this.user =
                ((SecurityUserDetails) SecurityContextHolder
                		.getContext()
                		.getAuthentication()
                		.getPrincipal())
                .getUser();
	}

	public User getUser() {
    	return user;
    }

    private long getPuntoPrincipal() {
        long puntoPrincipal = 0;
    	if (user.getSucursal() != null) {
            puntoPrincipal = user.getSucursal();
        }
        return puntoPrincipal;
    }
    
    public List<Integer> getPuntosSecundarios() {
        List<Integer> puntosSecundarios = new ArrayList<>();
        logger.info("getPuntosSecundarios() => Está extrayendo los puntos");
        if (user.getPuntosSecundarios() != null) {
            user.getPuntosSecundarios().stream().map(UserHelper::toLocalDomainPunto).forEach(p -> {
                puntosSecundarios.add(p);
            });
        }
        return puntosSecundarios;
    }

    private static int toLocalDomainPunto(Long numeroPunto) {
    	logger.info("LocalDomainPunto() => " + numeroPunto);
        return numeroPunto.intValue();
    }

}
