package com.gwa.autumn.model

import com.gwa.winter.model.OrderLineDto

data class MissionDto(val identifier: Long, val userIdentifier: Long, val label: String, val done: Boolean) {
    companion object {
        fun fromEntity(entity: OrderLineDto): MissionDto {
            return MissionDto(entity.identifier, entity.userIdentifier, entity.label, entity.done)
        }
    }
}
