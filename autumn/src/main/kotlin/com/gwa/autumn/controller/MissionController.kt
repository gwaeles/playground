package com.gwa.autumn.controller

import com.gwa.autumn.model.MissionDto
import com.gwa.autumn.service.MissionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/missions")
class MissionController(val missionService: MissionService) {

    @GetMapping("/")
    fun getMissions(): ResponseEntity<List<MissionDto>> {
        return missionService.getMissions()
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/{id}")
    fun getMissionById(@PathVariable id: Long): ResponseEntity<MissionDto> {
        return missionService.getMissionById(id)
            ?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()
    }
}