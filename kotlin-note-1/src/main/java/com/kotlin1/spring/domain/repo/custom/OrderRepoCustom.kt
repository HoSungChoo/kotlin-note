package com.kotlin1.spring.domain.repo.custom

import com.kotlin1.spring.domain.dto.ReadOrderOutDTO

interface OrderRepoCustom {
    fun findAllByUserId(userId: Long): List<ReadOrderOutDTO>
    fun findAllUsingPage(page: Long, size: Long): List<ReadOrderOutDTO>
}