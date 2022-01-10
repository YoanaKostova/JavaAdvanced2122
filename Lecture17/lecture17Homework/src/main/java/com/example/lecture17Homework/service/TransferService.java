package com.example.lecture17Homework.service;

import com.example.lecture17Homework.models.Firm;
import com.example.lecture17Homework.repositories.FirmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {
    private final FirmRepository firmRepository;

    public TransferService(FirmRepository firmRepository) {
        this.firmRepository = firmRepository;
    }

    @Transactional
    public void transferEmployees(Long idSender, Long idReceiver, int employees){
        Firm sender = firmRepository.findById(idSender).get();
        Firm receiver = firmRepository.findById(idReceiver).get();
        if(sender.getEmployees() < employees){
            throw new RuntimeException();
        }
        firmRepository.changeEmployees(idSender, sender.getEmployees() - employees);
        firmRepository.changeEmployees(idReceiver, receiver.getEmployees() + employees);
    }
}
