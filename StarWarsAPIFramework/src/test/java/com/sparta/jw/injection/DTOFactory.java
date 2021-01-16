package com.sparta.jw.injection;

import com.sparta.jw.dtos.*;

public class DTOFactory {

    public static DTO createDTO(String endPoint){

        if (endPoint.matches("films.*")){
            return new FilmsDTO();
        }
        if (endPoint.matches("people.*")){
            return new PeopleDTO();
        }
        if (endPoint.matches("planets.*")){
            return new PlanetsDTO();
        }
        if (endPoint.matches("species.*")){
            return new SpeciesDTO();
        }
        if (endPoint.matches("starships.*")){
            return new StarshipsDTO();
        }
        if (endPoint.matches("vehicles.*")){
            return new VehiclesDTO();
        }
        return null;
    }
}
