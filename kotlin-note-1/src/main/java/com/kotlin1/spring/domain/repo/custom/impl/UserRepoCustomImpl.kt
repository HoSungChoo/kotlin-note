package com.kotlin1.spring.domain.repo.custom.impl

import com.kotlin1.spring.domain.dto.ReadOrderOutDTO
import com.kotlin1.spring.domain.dto.ReadUserOutDTO
import com.kotlin1.spring.domain.entity.QUser
import com.kotlin1.spring.domain.repo.custom.UserRepoCustom
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQuery
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
class UserRepoCustomImpl: UserRepoCustom {
    @PersistenceContext
    lateinit var em: EntityManager
    private var qUser: QUser = QUser.user
    override fun findAllUsingProvider(userId: Long): List<ReadUserOutDTO> {
        val result: List<ReadUserOutDTO> = listOf()
        return result
    }

}