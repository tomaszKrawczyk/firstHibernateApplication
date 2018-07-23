package pl.tomaszKrawczyk.wst.pJPA.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tomaszKrawczyk.wst.pJPA.models.forms.ReservationForm;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reservation")
@NoArgsConstructor
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    //@Column(name = "name1")
    private String name;
    private String lastname;
    private LocalDate date;
    private String adress;

    public ReservationModel (ReservationForm form){

        name=form.getName();
        lastname=form.getLastname();
        date=form.getFormatedDate();
        adress=form.getAdress();

    }
}



