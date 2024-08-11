package com.kotlin1.spring.domain.repo.custom

import com.kotlin1.spring.domain.dto.ReadUserOutDTO

interface UserRepoCustom {
    fun findAllUsingProvider(userId: Long): List<ReadUserOutDTO>
}