package com.noirtvt.crudsample.roles

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RolesController {

    @GetMapping("api/v1/roles")
    fun getRoles(): RolesResponseModel {
        return RolesResponseModel(Role.values().map { it.name })
    }
}