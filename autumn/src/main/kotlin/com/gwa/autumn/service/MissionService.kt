package com.gwa.autumn.service

import com.gwa.autumn.model.MissionDto
import com.gwa.winter.output.CoreBackendClient
import org.springframework.stereotype.Service
import kotlin.collections.map

@Service
class MissionService(val coreBackendClient: CoreBackendClient) {

    fun getMissions(): List<MissionDto>? {
        return coreBackendClient.getAllItems()
            ?.map { MissionDto.fromEntity(it) }
    }

    fun getMissionById(id: Long): MissionDto? {
        return coreBackendClient.getItemById(id)
            ?.let { MissionDto.fromEntity(it) }
    }
}