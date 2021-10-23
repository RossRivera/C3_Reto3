package ciclo3reto3.CReto3.service;

import ciclo3reto3.CReto3.repository.RepositorioFinca;
import ciclo3reto3.CReto3.model.Finca;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosFinca {
    @Autowired
    private RepositorioFinca metodosCrud;

    public List<Finca> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Finca> getFincas(int fincaId) {
        return metodosCrud.getFinca(fincaId);
    }

    public Finca save(Finca finca){
        if(finca.getId()==null){
            return metodosCrud.save(finca);
        }else{
            Optional<Finca> e=metodosCrud.getFinca(finca.getId());
            if(e.isEmpty()){
                return metodosCrud.save(finca);
            }else{
                return finca;
            }
        }
    }

    public Finca update(Finca finca){
        if(finca.getId()!=null){
            Optional<Finca> e=metodosCrud.getFinca(finca.getId());
            if(!e.isEmpty()){
                if(finca.getAddress()!=null){
                    e.get().setAddress(finca.getAddress());
                }
                if(finca.getExension()!=null){
                    e.get().setExension(finca.getExension());
                }
                if(finca.getCategory_id()!=null){
                    e.get().setCategory_id(finca.getCategory_id());
                }
                if(finca.getName()!=null){
                    e.get().setName(finca.getName());
                }
                if(finca.getCategory()!=null){
                    e.get().setCategory(finca.getCategory());
                }
                if(finca.getMessages()!=null){
                    e.get().setMessages(finca.getMessages());
                }
                if(finca.getReservations()!=null){
                    e.get().setReservations(finca.getReservations());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return finca;
            }
        }else{
            return finca;
        }
    }


    public boolean deleteFinca(int fincaId) {
        Boolean aBoolean = getFincas(fincaId).map(finca -> {
            metodosCrud.delete(finca);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
