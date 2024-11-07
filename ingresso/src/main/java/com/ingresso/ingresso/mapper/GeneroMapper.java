package com.ingresso.ingresso.mapper;

import com.ingresso.ingresso.enums.GeneroEnum;

public class GeneroMapper {

    public static Integer getGenero(String genero) {
        for (GeneroEnum g : GeneroEnum.values()) {
            if(g.getCodigo().equals(genero)){
                return g.getCodigoBanco();
            }
        }
        return null;
    }
    public static String getCode(Integer genero) {
        for (GeneroEnum g : GeneroEnum.values()) {
            if(g.getCodigoBanco()== genero){
                return g.getCodigo();
            }
        }
        return null;
    }
}
