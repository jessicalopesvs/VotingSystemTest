package org.jessicalopes.votingsystem.api.controller;

import org.jessicalopes.votingsystem.api.model.ParameterModel;
import org.jessicalopes.votingsystem.api.repository.ParameterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {

    private final ParameterRepo parameterRepository;

    public ParameterController(ParameterRepo parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    @GetMapping("/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("Api Parameters Connected");
    }

    @PostMapping("/save")
    public ResponseEntity<ParameterModel> getParameters(@RequestBody ParameterModel parameter){
        ParameterModel entity = parameterRepository.save(parameter);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/find")
    public ResponseEntity<ParameterModel> save(@RequestParam String key){
        Optional<ParameterModel> optParameter = parameterRepository.findById(key);
        return optParameter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
