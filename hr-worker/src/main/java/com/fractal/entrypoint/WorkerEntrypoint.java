package com.fractal.entrypoint;

import com.fractal.domain.entity.Worker;
import com.fractal.infrastructure.WorkerRepository;
import com.fractal.usecase.Usecase;
import com.fractal.usecase.WorkerUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/worker")
public class WorkerEntrypoint {

    Usecase<Worker, Long> usecase;
    @Autowired
    private WorkerEntrypoint(WorkerUsecase usecase){
        this.usecase = usecase;
    }

    @GetMapping("s")
    public ResponseEntity<List<Worker>> getAll(){
        List<Worker> list =  usecase.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
