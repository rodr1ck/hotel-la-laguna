package com.hotelresort.lalaguna.controller;

import java.util.List;

//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import com.hotelresort.lalaguna.model.Pasajero;
import com.hotelresort.lalaguna.service.PasajeroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/pasajero")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @ApiOperation(value = "Obtener todos los pasajeros",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Pasajeros")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron pasajeros en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    @CrossOrigin
    public List<Pasajero> findAll(){
        return pasajeroService.findAll();
    }


    @ApiOperation(value = "Obtener un pasajero",
            notes = "Necesita el id de entrada",
            response = List.class,
            responseContainer = "Producto")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron pasajeros en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping("/{id}")
    @CrossOrigin
    public Pasajero findById(@PathVariable("id") Integer id){
        return pasajeroService.findById(id);
    }


    @ApiOperation(value = "Guarda un pasajero",
            notes = "Necesita ingresar los datos del pasajero",
            response = List.class,
            responseContainer = "Pasajeros")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron pasajeros en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PostMapping
    @CrossOrigin
    public @ResponseBody Pasajero save(@RequestBody Pasajero pasajero){
        return pasajeroService.save(pasajero);
    }

    @ApiOperation(value = "Modifica un pasajero",
            notes = "Necesita ingresar los datos del pasajero",
            response = List.class,
            responseContainer = "Pasajeros")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encuentra el pasajero en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PutMapping
    public ResponseEntity<Pasajero> modificar(@Valid @RequestBody Pasajero pasajero) {
        Pasajero obj = pasajeroService.update(pasajero);
        return new ResponseEntity<Pasajero>(obj, HttpStatus.OK);
    }


    @ApiOperation(value = "Borra un pasajero",
            notes = "Necesita ingresar el id del pasajero a eliminar",
            response = List.class,
            responseContainer = "Pasajeros")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encuentra el pasajero en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
        pasajeroService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
