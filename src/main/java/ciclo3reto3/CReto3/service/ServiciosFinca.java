package ciclo3reto3.CReto3.service;

import ciclo3reto3.CReto3.repository.RepositorioFinca;
import ciclo3reto3.CReto3.model.Farm;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosFinca {
    @Autowired
    private RepositorioFinca metodosCrud;

    public List<Farm> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Farm> getFincas(int fincaId) {
        return metodosCrud.getFinca(fincaId);
    }

    public Farm save(Farm finca){
        if(finca.getId()==null){
            return metodosCrud.save(finca);
        }else{
            Optional<Farm> e=metodosCrud.getFinca(finca.getId());
            if(e.isEmpty()){
                return metodosCrud.save(finca);
            }else{
                return finca;
            }
        }
    }

    public Farm update(Farm finca){
        if(finca.getId()!=null){
            Optional<Farm> e=metodosCrud.getFinca(finca.getId());
            if(!e.isEmpty()){
                if(finca.getAddress()!=null){
                    e.get().setAddress(finca.getAddress());
                }
                if(finca.getExtension()!=null){
                    e.get().setExtension(finca.getExtension());
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
