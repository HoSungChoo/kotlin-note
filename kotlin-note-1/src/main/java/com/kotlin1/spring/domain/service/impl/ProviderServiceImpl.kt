package com.kotlin1.spring.domain.service.impl

import com.kotlin1.spring.domain.dto.ProviderDTO
import com.kotlin1.spring.domain.entity.Provider
import com.kotlin1.spring.domain.repo.origin.ProviderRepo
import com.kotlin1.spring.domain.service.ProviderService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ProviderServiceImpl(private val providerRepo: ProviderRepo): ProviderService {
    override fun readProviderById(id: Long): ProviderDTO.ReadProviderOutDTO {
        return ProviderDTO.ReadProviderOutDTO.toDTO(providerRepo.findByIdOrNull(id) ?: throw NoSuchElementException())
    }
    override fun createProvider(createProviderInDTO: ProviderDTO.CreateProviderInDTO): ProviderDTO.CreateProviderOutDTO {
        val provider = Provider.toEntity(
            providerId = 0L,
            email = createProviderInDTO.email,
            birth = createProviderInDTO.birth,
            gender = createProviderInDTO.gender,
            city = createProviderInDTO.city,
            street = createProviderInDTO.street,
            zipcode = createProviderInDTO.zipcode,
            state = createProviderInDTO.state
        )

        return ProviderDTO.CreateProviderOutDTO.toDTO(providerRepo.save(provider))
    }
}