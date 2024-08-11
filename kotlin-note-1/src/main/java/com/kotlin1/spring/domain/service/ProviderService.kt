package com.kotlin1.spring.domain.service

import com.kotlin1.spring.domain.dto.ProviderDTO

interface ProviderService {
    fun readProviderById(id: Long): ProviderDTO.ReadProviderOutDTO
    fun readProviderSortByCount(): ProviderDTO.ReadProviderSortByCountOutDTOS
    fun createProvider(createProviderInDTO: ProviderDTO.CreateProviderInDTO): ProviderDTO.CreateProviderOutDTO
}