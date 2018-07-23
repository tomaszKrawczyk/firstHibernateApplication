package pl.tomaszKrawczyk.wst.pJPA.models.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Tomek Krawczyk on 07.05.2018.
 */

@Service
public class StringServices {

    public String generateRandomString(){

        return UUID.randomUUID().toString();

    }
}
