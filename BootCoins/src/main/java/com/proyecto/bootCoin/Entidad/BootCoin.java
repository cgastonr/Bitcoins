package com.proyecto.bootCoin.Entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "BootCoin")
public class BootCoin {
    @Id
    private String id;
    private String nroDoc;
    private String tipoDoc;  //DNI, CEX, Pasaporte
    private Integer numCel;
    private String correo;
    private String tipPago;  //Yanki o transferencia
    private double monto;
    
	
	 
	 
}
