package com.noirtvt.crudsample.roles

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY

@JsonAutoDetect(fieldVisibility = ANY)
data class RolesResponseModel(private val roles: List<String>)