package com.gwa.winter.model

import com.gwa.summer.model.Todo

data class TodoDto(val identifier: Long, val userIdentifier: Long, val label: String, val done: Boolean) {
    companion object {
        fun fromEntity(entity: Todo): TodoDto {
            return TodoDto(entity.id, entity.userId, entity.title, entity.completed)
        }
    }
}
