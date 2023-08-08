package com.realestate.controller;


import com.realestate.payload.SaleDto;
import com.realestate.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleDto> createSale(@RequestBody SaleDto saleDto) {
        SaleDto savedSaleDto = saleService.saveSale(saleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSaleDto);
    }
}

