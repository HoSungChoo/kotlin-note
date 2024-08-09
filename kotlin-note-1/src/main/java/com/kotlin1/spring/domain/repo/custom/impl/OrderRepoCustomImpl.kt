package com.kotlin1.spring.domain.repo.custom.impl

import com.kotlin1.spring.domain.dto.ReadOrderOutDTO
import com.kotlin1.spring.domain.entity.QOrder
import com.kotlin1.spring.domain.repo.custom.OrderRepoCustom
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQuery
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
class OrderRepoCustomImpl: OrderRepoCustom {
    @PersistenceContext
    lateinit var em: EntityManager
    val qOrder: QOrder = QOrder.order

    override fun findAllByUserId(userId: Long) :List<ReadOrderOutDTO> {
        return JPAQuery<List<ReadOrderOutDTO>>(em)
            .select(Projections.constructor(
                ReadOrderOutDTO::class.java,
                qOrder.orderId,
                qOrder.date,
                qOrder.user.userId))
            .from(qOrder)
            .where(qOrder.user.userId.eq(userId))
            .fetch()
    }

    override fun findAllUsingPage(page: Long, size: Long): List<ReadOrderOutDTO> {
        return JPAQuery<List<ReadOrderOutDTO>>(em)
            .select(Projections.constructor(
                ReadOrderOutDTO::class.java,
                qOrder.orderId,
                qOrder.date,
                qOrder.user.userId))
            .from(qOrder)
            .limit(size)
            .offset(page * size)
            .fetch()
    }
}