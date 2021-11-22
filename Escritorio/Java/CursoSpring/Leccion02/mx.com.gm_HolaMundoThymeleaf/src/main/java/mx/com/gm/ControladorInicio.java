package mx.com.gm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        String mensaje = "Hola mundo con Thymeleaf";
        log.info("Ejecutando el controlador Spring MVC");
        
        Persona persona = new Persona();
        persona.setNombre("Cris");
        persona.setApellido("Aguilar");
        persona.setEmail("cris@cris.es");
        persona.setTelefono("123456789");
        
        Persona persona2 = new Persona();
        persona2.setNombre("Eliz");
        persona2.setApellido("Quispe");
        persona2.setEmail("eliz@eliz.es");
        persona2.setTelefono("987654321");
        
        /*List<Persona> personas = Arrays.asList(persona, persona2);*/
        
        List<Persona> personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);
        
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
}
