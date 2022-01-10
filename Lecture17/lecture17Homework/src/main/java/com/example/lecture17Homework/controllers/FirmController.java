package com.example.lecture17Homework.controllers;

import com.example.lecture17Homework.models.Firm;
import com.example.lecture17Homework.repositories.FirmRepository;
import com.example.lecture17Homework.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirmController {

    private final FirmRepository firmRepository;
    private final TransferService transferService;

    public FirmController(FirmRepository firmRepository, TransferService transferService) {
        this.firmRepository = firmRepository;
        this.transferService = transferService;
    }

    @GetMapping("/firm")
    public Iterable<Firm> findAll(@RequestParam (required = false) String name){
        if(name != null){
            return firmRepository.findByName(name);
        }
        return firmRepository.findAll();
    }

    @PostMapping("/firm")
    public Firm createFirm(@RequestBody Firm firm){
        return firmRepository.save(firm);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        firmRepository.deleteById(id);
    }

    @PostMapping("/changeCity/{id}")
    public void change(@PathVariable Long id, @RequestParam String city){
        firmRepository.changeCity(id, city);
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestParam Long idSender,
                              @RequestParam Long idReceiver,
                              @RequestParam Integer employees){
        transferService.transferEmployees(idSender,idReceiver,employees);
    }
}
