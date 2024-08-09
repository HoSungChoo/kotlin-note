package com.kotlin1.spring.domain.repo.custom.impl

import com.kotlin1.spring.domain.dto.ReadOrderItemOutDTO
import com.kotlin1.spring.domain.entity.QOrder
import com.kotlin1.spring.domain.entity.QOrderItem
import com.kotlin1.spring.domain.entity.QUser
import com.kotlin1.spring.domain.repo.custom.OrderItemRepoCustom
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQuery
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepoCustomImpl: OrderItemRepoCustom {
    @PersistenceContext
    lateinit var em: EntityManager
    private val qOrderItem: QOrderItem = QOrderItem.orderItem
    private val qOrder: QOrder = QOrder.order
    private val qUser: QUser = QUser.user
    override fun findAllByOrderId(orderId: Long): List<ReadOrderItemOutDTO> {
        return JPAQuery<List<ReadOrderItemOutDTO>>(em)
            .select(
                Projections.constructor(
                    ReadOrderItemOutDTO::class.java,
                    qOrderItem.orderItemId,
                    qOrderItem.count,
                    qOrderItem.order.orderId,
                    qOrderItem.item.itemId))
            .from(qOrderItem)
            .where(qOrderItem.order.orderId.eq(orderId))
            .fetch()
    }
    override fun findAllByItemId(itemId: Long): List<ReadOrderItemOutDTO> {
        return JPAQuery<List<ReadOrderItemOutDTO>>(em)
            .select(
                Projections.constructor(
                    ReadOrderItemOutDTO::class.java,
                    qOrderItem.orderItemId,
                    qOrderItem.count,
                    qOrderItem.order.orderId,
                    qOrderItem.item.itemId))
            .from(qOrderItem)
            .where(qOrderItem.item.itemId.eq(itemId))
            .fetch()
    }
    override fun findAllByUserId(userId: Long): List<ReadOrderItemOutDTO> {
        return JPAQuery<List<ReadOrderItemOutDTO>>(em)
            .select(
                Projections.constructor(
                    ReadOrderItemOutDTO::class.java,
                    qOrderItem.orderItemId,
                    qOrderItem.count,
                    qOrderItem.order.orderId,
                    qOrderItem.item.itemId))
            .from(qOrderItem)
            .join(qOrder)
            .on(qOrderItem.order.orderId.eq(qOrder.orderId))
            .join(qUser)
            .on(qOrder.user.userId.eq(qUser.userId))
            .where(qUser.userId.eq(userId))
            .fetch()
    }
}