
package com.portfolio.mr.Controller;

import com.portfolio.mr.Dto.dtoEducacion;
import com.portfolio.mr.Entity.Educacion;
import com.portfolio.mr.Security.Controller.Mensaje;
import com.portfolio.mr.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://porfolio-mr.web.app"}, allowedHeaders = "*")
public class CEducacion {
    
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list= sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole ('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(
                    new Mensaje(
                    "No existe el id"
            )
                    , HttpStatus.NOT_FOUND);
            
        }
        sEducacion.delete(id);
        return new ResponseEntity(
new Mensaje(
                "Educacion eliminada"
        )
                , HttpStatus.OK);
    }
    
   @PreAuthorize("hasRole ('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(
                    new Mensaje(
                    "El nombre es obligatorio"
            )
                    , HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getDescripcionEd())){
            return new ResponseEntity(
                    new Mensaje(
                    "La Descripcion es obligatoria"
            )
                    , HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombreEdu(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(
                     new Mensaje (
                    "Ese nombre ya existe"
             )
                    , HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
                dtoeducacion.getNombreEdu(), dtoeducacion.getDescripcionEd()
        );
        sEducacion.save(educacion);
        return new ResponseEntity(
                 new Mensaje(
                "Educacion creada"
         )
                , HttpStatus.OK);
    }
    
     @PreAuthorize("hasRole ('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(
                     new Mensaje(
                    "no existe el id"
             )
                    , HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
     @PreAuthorize("hasRole ('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(
                     new Mensaje(
                    "No ixiste el id"
             )
                    , HttpStatus.NOT_FOUND);
           
        }
        if(sEducacion.existsByNombreEdu(dtoeducacion.getNombreEdu()) && sEducacion.getByNombreEdu(dtoeducacion.getNombreEdu()).get().getId() != id){
            return new ResponseEntity(
                     new Mensaje(
                    "Ese nombre ya existe"
             )
                    , HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getNombreEdu())){
            return new ResponseEntity(
                     new Mensaje(
                    "El campo no puede estar vacío"
             )
                    , HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getDescripcionEd())){
            return new ResponseEntity(
                     new Mensaje(
                    "La Descripcion es obligatoria" )
                    , HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setNombreEdu(dtoeducacion.getNombreEdu());
        educacion.setDescripcionEd(dtoeducacion.getDescripcionEd());
        
        sEducacion.save(educacion);
        
        return new ResponseEntity(
                 new Mensaje(
                "Educacion Actualizada"
         )
                , HttpStatus.OK);
    }
    
}
