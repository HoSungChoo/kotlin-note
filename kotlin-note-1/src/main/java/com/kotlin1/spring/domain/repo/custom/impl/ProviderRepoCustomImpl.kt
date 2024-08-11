package com.kotlin1.spring.domain.repo.custom.impl

import com.kotlin1.spring.domain.dto.ProviderDTO
import com.kotlin1.spring.domain.dto.ReadOrderOutDTO
import com.kotlin1.spring.domain.entity.Provider
import com.kotlin1.spring.domain.entity.QItem
import com.kotlin1.spring.domain.entity.QOrderItem
import com.kotlin1.spring.domain.entity.QProvider
import com.kotlin1.spring.domain.repo.custom.ProviderRepoCustom
import com.querydsl.core.types.Expression
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQuery
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.hibernate.Hibernate
import org.hibernate.HibernateError
import org.hibernate.Session
import org.hibernate.internal.SessionImpl
import org.springframework.stereotype.Repository

@Repository
class ProviderRepoCustomImpl : ProviderRepoCustom {
    @PersistenceContext
    lateinit var em: EntityManager
    private val qProvider: QProvider = QProvider.provider
    private val qItem: QItem = QItem.item
    private val qOrderItem: QOrderItem = QOrderItem.orderItem
    override fun readProviderSortByCount(): List<ProviderDTO.ReadProviderSortByCountOutDTO> {
        return JPAQuery<List<ReadOrderOutDTO>>(em)
            .select(
                Projections.constructor(
                    ProviderDTO.ReadProviderSortByCountOutDTO::class.java,
                    qProvider.providerId,
                    qProvider.email,
                    qProvider.birth,
                    qProvider.gender,
                    qProvider.city,
                    qProvider.street,
                    qProvider.zipcode,
                    qProvider.state,
                    qOrderItem.count.sum()
                )
            )
            .from(qProvider)
            .join(qItem)
            .on(qProvider.providerId.eq(qItem.provider.providerId))
            .join(qOrderItem)
            .on(qItem.itemId.eq(qOrderItem.item.itemId))
            .groupBy(qProvider.providerId)
            .orderBy(qOrderItem.count.sum().desc())
            .limit(10)
            .fetch()
    }


}