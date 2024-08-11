package com.kotlin1.spring.domain.api

import com.kotlin1.spring.domain.dto.ProviderDTO
import com.kotlin1.spring.domain.service.ProviderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/provider")
class ProviderController(private val providerService: ProviderService) {
    @GetMapping()
    fun readProviderById(@RequestParam id: Long): ResponseEntity<ProviderDTO.ReadProviderOutDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(providerService.readProviderById(id))
    }

    @GetMapping("/sort")
    fun readProviderSortByCount(): ResponseEntity<ProviderDTO.ReadProviderSortByCountOutDTOS>{
        return ResponseEntity.status(HttpStatus.OK).body(providerService.readProviderSortByCount())
    }
    @PostMapping()
    fun createProvider(@RequestBody createProviderInDTO: ProviderDTO.CreateProviderInDTO):
            ResponseEntity<ProviderDTO.CreateProviderOutDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(providerService.createProvider(createProviderInDTO))
    }

}