package com.proyecto.bootCoin.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.bootCoin.Dto.BootCoinDto;
import com.proyecto.bootCoin.Repository.BootCoinRepository;
import com.proyecto.bootCoin.Utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootCoinService {
    @Autowired
    private BootCoinRepository repository;
    //Creditos
    public Flux<BootCoinDto> getBootCoins(){
        return repository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<BootCoinDto> getBootCoin(String id){
        return repository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<BootCoinDto> saveBootCoin(Mono<BootCoinDto> bootCoinDtoMono){
        
        return  bootCoinDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtils::entityToDto);
     
    }

    public Mono<BootCoinDto> updateBootCoin(Mono<BootCoinDto> BootCoinDtoMono,String id){
        System.out.println("service method called ...");

        return repository.findById(id)
                .flatMap(p->BootCoinDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(AppUtils::entityToDto);

    }

    public Mono<Void> deleteBootCoin(String id){
        return repository.deleteById(id);
    }
}
