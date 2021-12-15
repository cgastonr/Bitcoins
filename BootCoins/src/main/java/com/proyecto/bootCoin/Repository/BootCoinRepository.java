package com.proyecto.bootCoin.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.bootCoin.Entidad.BootCoin;



@Repository
public interface BootCoinRepository extends ReactiveMongoRepository<BootCoin,String> {
}
