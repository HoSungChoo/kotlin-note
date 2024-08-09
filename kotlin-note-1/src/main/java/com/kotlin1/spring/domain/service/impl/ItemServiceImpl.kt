package com.kotlin1.spring.domain.service.impl

import com.kotlin1.spring.domain.dto.ItemDTO
import com.kotlin1.spring.domain.entity.Item
import com.kotlin1.spring.domain.enumerate.ItemType
import com.kotlin1.spring.domain.repo.custom.ItemRepoCustom
import com.kotlin1.spring.domain.repo.origin.ItemRepo
import com.kotlin1.spring.domain.repo.origin.ProviderRepo
import com.kotlin1.spring.domain.service.ItemService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl(
    private var itemRepo: ItemRepo,
    private var itemRepoCustom: ItemRepoCustom,
    private var providerRepo: ProviderRepo
): ItemService {
    override fun readItemById(itemId: Long): ItemDTO.ReadItemOutDTO {
        return ItemDTO.ReadItemOutDTO.toDTO(
            itemRepo.findByIdOrNull(itemId) ?: throw NoSuchElementException()
        )
    }

    override fun readItemByType(type: ItemType): ItemDTO.ReadItemOutDTOS {
        return ItemDTO.ReadItemOutDTOS(itemRepoCustom.findAllByItemType(type))
    }

    override fun readItemByPrice(min: Long, max: Long): ItemDTO.ReadItemOutDTOS {
        return ItemDTO.ReadItemOutDTOS(itemRepoCustom.findAllByPrice(min, max))
    }

    override fun createItem(createItemInDTO: ItemDTO.CreateItemInDTO): ItemDTO.CreateItemOutDTO {
        val provider = providerRepo.findByIdOrNull(createItemInDTO.providerId) ?: throw NoSuchElementException()

        val item = Item.toEntity(
            itemId = 0L,
            name = createItemInDTO.name,
            type = createItemInDTO.type,
            price = createItemInDTO.price,
            content = createItemInDTO.content,
            provider = provider
        )

        return ItemDTO.CreateItemOutDTO.toDTO(itemRepo.save(item))
    }
}