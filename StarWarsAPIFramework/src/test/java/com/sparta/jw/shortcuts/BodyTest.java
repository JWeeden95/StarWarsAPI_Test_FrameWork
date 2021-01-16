package com.sparta.jw.shortcuts;

import com.sparta.jw.dtos.DTO;
import com.sparta.jw.dtos.PeopleDTO;
import org.junit.jupiter.api.Assertions;

public class BodyTest {

    public static void checkType(String expectedType, DTO dtoActual){
        String dtoType = dtoActual.getClass().getTypeName();
        Assertions.assertEquals(expectedType, dtoType.substring(19, dtoType.length()));
    }

//    public static int getNumberOfPeople(PeopleDTO peopleDTO){
//        for (int i = 0; i < 100; i++){
//
//        }
//    }

}
