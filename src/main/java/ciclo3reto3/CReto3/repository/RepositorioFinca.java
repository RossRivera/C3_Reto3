package ciclo3reto3.CReto3.repository;

import ciclo3reto3.CReto3.repository.crud.InterfaceFinca;
import ciclo3reto3.CReto3.model.Farm;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFinca {
    @Autowired
    private InterfaceFinca crud;

    public List<Farm> getAll(){
        return (List<Farm>) crud.findAll();
    }

    public Optional<Farm> getFinca(int id){
        return crud.findById(id);
    }

    public Farm save(Farm finca){
        return crud.save(finca);
    }
    
    public void delete(Farm finca){
        crud.delete(finca);
    }
}
