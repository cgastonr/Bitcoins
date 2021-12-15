package com.proyecto.bootCoin.Utils;


import org.springframework.beans.BeanUtils;

import com.proyecto.bootCoin.Dto.BootCoinDto;
import com.proyecto.bootCoin.Entidad.BootCoin;



public class AppUtils {
    public static BootCoinDto entityToDto(BootCoin bootCoin) {
        BootCoinDto bootCoinDto = new BootCoinDto();
        BeanUtils.copyProperties(bootCoin, bootCoinDto);
        return bootCoinDto;
    }

    public static BootCoin dtoToEntity(BootCoinDto bootCoinDto) {
        BootCoin bootCoin = new BootCoin();
        BeanUtils.copyProperties(bootCoinDto, bootCoin);
        return bootCoin;
    }
}
