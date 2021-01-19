package com.imagosur.visor_transacciones.helper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.imagosur.visor_transacciones.request.model.*;
import com.imagosur.visor_transacciones.response.model.Detalle;
import com.imagosur.visor_transacciones.response.model.DetalleFront;
import com.imagosur.visor_transacciones.response.model.Pago;
import com.imagosur.visor_transacciones.response.model.PagoFront;
import com.imagosur.visor_transacciones.response.model.Tipo;
import com.imagosur.visor_transacciones.response.model.TipoFront;
import com.imagosur.visor_transacciones.response.view.Tipos;

public class MapUtil {
	
	public static Consulta mapearConsulta(ConsultaFront consulta) {
		return crear().map(consulta, Consulta.class);
	}
	
	public static DetalleFront mapearDetalle(Detalle detalle) {
		return crear().map(detalle,DetalleFront.class);
	}
	
	public static PagoFront mapearPago(Pago pago) {
		return crear().map(pago,PagoFront.class);
	}

	private static ModelMapper crear(){
		return new ModelMapper();
	}

}
