package com.kotlin1.spring.domain.repo.origin

import com.kotlin1.spring.domain.entity.Provider
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProviderRepo :JpaRepository<Provider, Long>