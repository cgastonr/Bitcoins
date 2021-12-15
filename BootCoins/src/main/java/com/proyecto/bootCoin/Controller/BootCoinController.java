package com.proyecto.bootCoin.Controller;

import java.net.URI;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.bootCoin.Dto.BootCoinDto;
import com.proyecto.bootCoin.Service.BootCoinService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bootcoin")
public class BootCoinController {
    @Autowired
    private BootCoinService service;

    @GetMapping(value = "/listar")
    public  Mono<ResponseEntity<Flux<BootCoinDto>>> getBootCoin(){
       // return service.getClientes();
    	  return Mono.just(ResponseEntity.ok()
         	     .contentType(MediaType.APPLICATION_JSON)
         		 .body(service.getBootCoins()));
    }
   
    /*
     * 	@GetMapping("/listar")
	public Mono<ResponseEntity<Flux<BootCoin>>> listar(){

         return Mono.just(ResponseEntity.ok()
        	     .contentType(MediaType.APPLICATION_JSON)
        		 .body(service.buscartodos()));
	}*/
    
    
    
    
    @GetMapping("/listar/{id}")
    public  Mono<ResponseEntity<BootCoinDto>> getObtenerPorId(@PathVariable String id){
        //return service.getCliente(id);
    	return service.getBootCoin(id).map(p -> ResponseEntity.ok()
       		 .contentType(MediaType.APPLICATION_JSON)
       		 .body(p))
       		 .defaultIfEmpty(ResponseEntity.notFound().build());
    	
    }
    
  
    /*
      @PostMapping("/create")
    public Mono<BootCoinDto> saveClient(@RequestBody Mono<BootCoinDto> clienteDtoMono){

        return service.saveCliente(clienteDtoMono);
    }
     
     */
    

    @PostMapping("/create")
	public Mono<ResponseEntity<BootCoinDto>> guardar(@RequestBody Mono<BootCoinDto> clienteDtoMono){

         return service.saveBootCoin(clienteDtoMono).map(p -> ResponseEntity
        		 .created(URI.create("".concat(p.getId())))
        		 
        		 .contentType(MediaType.APPLICATION_JSON)
        		 .body(p));		
	}
/*
    @PutMapping("/update/{id}")
    public Mono<BootCoinDto> updateTarjetaCredito(@RequestBody Mono<BootCoinDto> clienteDtoMono,@PathVariable String id){
        return service.updateCliente(clienteDtoMono,id);
    }
*/    
     
    @PutMapping("/update")
	public Mono<ResponseEntity<BootCoinDto>> editar(@RequestBody Mono<BootCoinDto> clie, @PathVariable String id){
		return service.updateBootCoin(clie, id)
				.map(p->ResponseEntity.created(URI.create("".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(p))
		.defaultIfEmpty(ResponseEntity.notFound().build());
	}

     
    
    
    /*
    @DeleteMapping("/delete/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id){
    	return service.getCliente(id)
    			.flatMap(p ->{
			return service.deleteCliente(id).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
    
    */
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id){

	  	
    	return service.getBootCoin(id).flatMap(p -> {
    		
    		return service.deleteBootCoin(id).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
    	}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

	}
    

	
     
}
