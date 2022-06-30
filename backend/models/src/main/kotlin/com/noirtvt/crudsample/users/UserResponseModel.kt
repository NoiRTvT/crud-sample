package com.noirtvt.crudsample.users

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY

@JsonAutoDetect(fieldVisibility = ANY)
data class UserResponseModel(
    private val id: Int?,
    private val firstName: String,
    private val lastName: String?,
    private val email: String,
    private val phoneNumber: String?,
    private val role: String
)
