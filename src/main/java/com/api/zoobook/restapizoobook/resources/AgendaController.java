package com.api.zoobook.restapizoobook.resources;

import com.api.zoobook.restapizoobook.domain.agenda.Eventos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/agenda")
public class AgendaController {


    @RequestMapping(value = "/montaAgenda", method = RequestMethod.GET)
    public ModelAndView MontaAgenda() {

        ModelAndView mv = new ModelAndView("AgendaEventos");

        return mv;
    }

    @RequestMapping(value = "/getEventos", method = RequestMethod.GET)
    public @ResponseBody List<Eventos> GetEventos(){

        List<Eventos> eventos = new ArrayList();

        String mesAtual = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+ 1);

        if(mesAtual.length() <2)
            mesAtual = "0" + mesAtual;

        String anoAtual = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));


        return eventos;

    }

}

