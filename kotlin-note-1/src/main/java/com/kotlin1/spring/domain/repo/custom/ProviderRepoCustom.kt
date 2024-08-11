package com.kotlin1.spring.domain.repo.custom

import com.kotlin1.spring.domain.dto.ProviderDTO
import org.springframework.stereotype.Repository


interface ProviderRepoCustom {
    fun readProviderSortByCount(): List<ProviderDTO.ReadProviderSortByCountOutDTO>
}