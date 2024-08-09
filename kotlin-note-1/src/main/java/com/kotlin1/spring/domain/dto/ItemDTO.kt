package com.kotlin1.spring.domain.dto

import com.kotlin1.spring.domain.entity.Item
import com.kotlin1.spring.domain.enumerate.ItemType

class ItemDTO {
    data class ReadItemOutDTO(
        val itemId: Long,
        val name: String,
        val type: ItemType,
        val price: Long,
        val content: String,
        val providerId: Long,
    ) {
        companion object Mapper {
            fun toDTO(item: Item): ReadItemOutDTO {
                return ReadItemOutDTO(
                    itemId = item.itemId,
                    name = item.name,
                    type = item.type,
                    price = item.price,
                    content = item.content,
                    providerId = item.provider.providerId
                )
            }
        }
    }

    data class ReadItemOutDTOS(
        val ReadItemOutDTOs: List<ReadItemOutDTO>
    )

    data class CreateItemInDTO(
        val itemId: Long = 0L,
        val name: String,
        val type: ItemType,
        val price: Long,
        val content: String,
        val providerId: Long,
    )

    data class CreateItemOutDTO(
        val itemId: Long,
        val name: String,
        val type: ItemType,
        val price: Long,
        val content: String,
        val providerId: Long,
    ) {
        companion object Mapper {
            fun toDTO(item: Item): CreateItemOutDTO {
                return CreateItemOutDTO(
                    itemId = item.itemId,
                    name = item.name,
                    type = item.type,
                    price = item.price,
                    content = item.content,
                    providerId = item.provider.providerId
                )
            }
        }
    }
}