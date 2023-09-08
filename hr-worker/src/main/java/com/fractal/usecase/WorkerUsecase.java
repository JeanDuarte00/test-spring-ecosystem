package com.fractal.usecase;

import com.fractal.domain.entity.Worker;
import com.fractal.domain.entity.exception.WorkerNotFound;
import com.fractal.infrastructure.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class WorkerUsecase implements Usecase<Worker, Long>{

    private final WorkerRepository repository;

    @Autowired
    public WorkerUsecase(WorkerRepository workerRepository){
        this.repository = workerRepository;
    }

    @Override
    public List<Worker> getAll() {
        return repository.findAll();
    }

    @Override
    public Worker getById(Long id) {
        return repository.findById(id).orElseThrow(WorkerNotFound::new);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Worker create(Worker object) {
        return repository.save(object);
    }

    @Override
    public Worker update(Worker object) {
        Optional<Worker> optionalWorker = repository.findById(object.getId());
        if(optionalWorker.isEmpty())
            throw new WorkerNotFound();
        return repository.save(object);
    }

    @Override
    public Worker updateName(Long id, String name) {
        Optional<Worker> optionalWorker = repository.findById(id);
        if(optionalWorker.isEmpty())
            throw new WorkerNotFound();
        Worker worker = optionalWorker.get().changeName(name);
        return repository.save(worker);
    }

    @Override
    public Worker updateDailyIncome(Long id, Double income) {
        Optional<Worker> optionalWorker = repository.findById(id);
        if(optionalWorker.isEmpty())
            throw new WorkerNotFound();
        Worker worker = optionalWorker.get().changeIncome(income);
        return repository.save(worker);
    }
}
