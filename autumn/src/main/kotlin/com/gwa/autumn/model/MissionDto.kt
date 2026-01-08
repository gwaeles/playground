package com.gwa.winter.model

import com.gwa.summer.model.Todo

data class OrderLineDto(val identifier: Long, val userIdentifier: Long, val label: String, val done: Boolean) {
    companion object {
        fun fromEntity(entity: Todo): OrderLineDto {
            return OrderLineDto(entity.id, entity.userId, entity.title, entity.completed)
        }
    }
}
