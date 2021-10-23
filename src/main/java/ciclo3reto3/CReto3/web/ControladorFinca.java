
package ciclo3reto3.CReto3.web;

import ciclo3reto3.CReto3.service.ServiciosFinca;
import ciclo3reto3.CReto3.model.Farm;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControladorFinca {
    @Autowired
    private ServiciosFinca servicio;
    
    @GetMapping("/all")
    public List<Farm> getFincas(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Farm> getFincas(@PathVariable("id") int fincaId) {
        return servicio.getFincas(fincaId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm finca) {
        return servicio.save(finca);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm update(@RequestBody Farm finca) {
        return servicio.update(finca);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int fincaId) {
        return servicio.deleteFinca(fincaId);
    } 
}
