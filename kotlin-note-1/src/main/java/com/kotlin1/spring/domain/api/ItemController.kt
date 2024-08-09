package com.kotlin1.spring.domain.api

import com.kotlin1.spring.domain.dto.ItemDTO
import com.kotlin1.spring.domain.enumerate.ItemType
import com.kotlin1.spring.domain.service.ItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ItemController(private var itemService: ItemService) {
    @GetMapping()
    fun readItemById(@RequestParam id: Long): ResponseEntity<ItemDTO.ReadItemOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(itemService.readItemById(id))
    }
    @GetMapping("/type")
    fun readItemByType(@RequestParam type: ItemType): ResponseEntity<ItemDTO.ReadItemOutDTOS>{
        return ResponseEntity.status(HttpStatus.OK).body(itemService.readItemByType(type))
    }
    @GetMapping("/price")
    fun readItemByPrice(@RequestParam min: Long, @RequestParam max: Long): ResponseEntity<ItemDTO.ReadItemOutDTOS>{
        return ResponseEntity.status(HttpStatus.OK).body(itemService.readItemByPrice(min, max))
    }
    @PostMapping()
    fun createItem(@RequestBody createItemInDTO: ItemDTO.CreateItemInDTO): ResponseEntity<ItemDTO.CreateItemOutDTO>{
        return ResponseEntity.status(HttpStatus.OK).body(itemService.createItem(createItemInDTO))
    }
}