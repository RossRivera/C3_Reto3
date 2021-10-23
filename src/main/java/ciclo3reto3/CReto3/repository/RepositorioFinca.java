package ciclo3reto3.CReto3.repository;

import ciclo3reto3.CReto3.repository.crud.InterfaceFinca;
import ciclo3reto3.CReto3.model.Finca;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFinca {
    @Autowired
    private InterfaceFinca crud;

    public List<Finca> getAll(){
        return (List<Finca>) crud.findAll();
    }

    public Optional<Finca> getFinca(int id){
        return crud.findById(id);
    }

    public Finca save(Finca finca){
        return crud.save(finca);
    }
    
    public void delete(Finca finca){
        crud.delete(finca);
    }
}
