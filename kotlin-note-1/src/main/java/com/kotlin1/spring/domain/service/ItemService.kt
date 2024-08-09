package com.kotlin1.spring.domain.service

import com.kotlin1.spring.domain.dto.*
import com.kotlin1.spring.domain.enumerate.ItemType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

interface ItemService {
    fun readItemById(itemId: Long): ItemDTO.ReadItemOutDTO
    fun readItemByType(type: ItemType): ItemDTO.ReadItemOutDTOS
    fun readItemByPrice(min: Long, max: Long): ItemDTO.ReadItemOutDTOS
    fun createItem(createItemInDTO: ItemDTO.CreateItemInDTO): ItemDTO.CreateItemOutDTO
}