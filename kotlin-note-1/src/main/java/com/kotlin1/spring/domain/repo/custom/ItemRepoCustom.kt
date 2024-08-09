package com.kotlin1.spring.domain.repo.custom

import com.kotlin1.spring.domain.dto.ItemDTO
import com.kotlin1.spring.domain.dto.ItemDTO.ReadItemOutDTO
import com.kotlin1.spring.domain.enumerate.ItemType

interface ItemRepoCustom {
    fun findAllByItemType(itemType: ItemType): List<ItemDTO.ReadItemOutDTO>
    fun findAllByPrice(min: Long, max: Long): List<ItemDTO.ReadItemOutDTO>
}