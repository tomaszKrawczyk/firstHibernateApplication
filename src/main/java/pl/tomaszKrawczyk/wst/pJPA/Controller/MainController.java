package pl.tomaszKrawczyk.wst.pJPA.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tomaszKrawczyk.wst.pJPA.models.forms.ReservationForm;
import pl.tomaszKrawczyk.wst.pJPA.models.repositories.ReservationRepository;
import pl.tomaszKrawczyk.wst.pJPA.models.ReservationModel;
import pl.tomaszKrawczyk.wst.pJPA.models.services.StringServices;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


/**
 * Created by Tomek Krawczyk on 07.05.2018.
 */
@Controller
public class MainController {

    @Autowired
    StringServices stringService;

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("reservationForm", new ReservationForm());
        model.addAttribute("reservations",reservationRepository.findByDateIsBetween(LocalDate.now(),LocalDate.now().plusWeeks(1)));
        return "index";

    }



    @PostMapping("/")
    public String index(@ModelAttribute("reservationForm") @Valid ReservationForm form, BindingResult result, Model model){
        if(result.hasErrors()){
            return "index";
        }else if(reservationRepository.existsByDateEquals(form.getFormatedDate())){
            model.addAttribute("error", "Ten dzień jest już zajęty");

        }
        reservationRepository.save(new ReservationModel(form));
        return "index";
    }



//    //@GetMapping("/test")
//    @ResponseBody
//    public String index(ReservationForm form){
//        if (reservationRepository.existsByDateEquals(form.getFormatedDate())==false) {
//            return "This termin is free. You booked this termin.";
//        }else {
//            return "This termin is not free. You must book another termin";
//        }
//
//
//    }
}