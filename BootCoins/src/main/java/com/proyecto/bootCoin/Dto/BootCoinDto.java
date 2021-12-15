package com.proyecto.bootCoin.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinDto {
	    private String id;
	    private String nroDoc;
	    private String tipoDoc;  //DNI, CEX, Pasaporte
	    private Integer numCel;
	    private String correo;
	    private String tipPago;  //Yanki o transferencia
	    private double monto;
	    
}
