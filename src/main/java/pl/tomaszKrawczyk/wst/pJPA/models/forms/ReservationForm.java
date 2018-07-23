package pl.tomaszKrawczyk.wst.pJPA.models.forms;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Tomek Krawczyk on 18.07.2018.
 */
public class ReservationForm {



    @Getter
    @Setter
    @NotBlank
    @Size(min=3, max=25)
    private String name;
    @Getter
    @Setter
    @NotBlank
    @Size(min=3, max=25)
    private String lastname;
    @Getter
    @Setter
    @Pattern(regexp = "2[0-9]{3}-[0-1][0-9]-[0-3][0-9]", message = "Data musi być w formacie yyyy-MM-dd")
    private String date;
    @Getter
    @Setter
    @NotBlank
    @Size(min=5, max=75)
    private String adress;


    // Nowe podejscie do czasu
    DateTimeFormatter format =  DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate getFormatedDate(){
        return LocalDate.parse(date, format);
    }
}



