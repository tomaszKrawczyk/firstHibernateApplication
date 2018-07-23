package pl.tomaszKrawczyk.wst.pJPA.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tomaszKrawczyk.wst.pJPA.models.ReservationModel;
import pl.tomaszKrawczyk.wst.pJPA.models.forms.ReservationForm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomek Krawczyk on 08.05.2018.
 */

@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel, Integer> {

    //List<ReservationModel> findByName(String name);
    //ReservationModel findByNameAndLastname(String name, String lastname);
    //List<ReservationModel>findByLastnameContaining(String a);
    //List<ReservationModel>findByIdGreaterThan(int a );
    //List<ReservationModel>findByDateBefore(LocalDate date);

    boolean existsByDateEquals(LocalDate date);

    List<ReservationModel> findByDateIsBetween(LocalDate date1, LocalDate date2);







    }


