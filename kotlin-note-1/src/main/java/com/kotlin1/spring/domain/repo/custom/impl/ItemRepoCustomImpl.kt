package com.kotlin1.spring.domain.repo.custom.impl

import com.kotlin1.spring.domain.dto.ItemDTO
import com.kotlin1.spring.domain.dto.ItemDTO.ReadItemOutDTO
import com.kotlin1.spring.domain.dto.ReadOrderOutDTO
import com.kotlin1.spring.domain.entity.QItem
import com.kotlin1.spring.domain.entity.QOrder
import com.kotlin1.spring.domain.enumerate.ItemType
import com.kotlin1.spring.domain.repo.custom.ItemRepoCustom
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQuery
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
class ItemRepoCustomImpl: ItemRepoCustom {
    @PersistenceContext
    lateinit var em: EntityManager
    val qItem: QItem = QItem.item
    override fun findAllByItemType(itemType: ItemType): List<ItemDTO.ReadItemOutDTO> {
        return JPAQuery<List<ItemDTO.ReadItemOutDTO>>(em)
            .select(
                Projections.constructor(
                    ItemDTO.ReadItemOutDTO::class.java,
                qItem.itemId,
                        qItem.name,
                    qItem.type,
                    qItem.price,
                    qItem.content,
                    qItem.provider.providerId
                ))
            .from(qItem)
            .where(qItem.type.eq(itemType))
            .fetch()
    }

    override fun findAllByPrice(min: Long, max: Long): List<ItemDTO.ReadItemOutDTO> {
        return JPAQuery<List<ItemDTO.ReadItemOutDTO>>(em)
            .select(
                Projections.constructor(
                    ItemDTO.ReadItemOutDTO::class.java,
                    qItem.itemId,
                    qItem.name,
                    qItem.type,
                    qItem.price,
                    qItem.content,
                    qItem.provider.providerId
                ))
            .from(qItem)
            .where(qItem.price.goe(min))
            .where(qItem.price.loe(max))
            .fetch()
    }
}