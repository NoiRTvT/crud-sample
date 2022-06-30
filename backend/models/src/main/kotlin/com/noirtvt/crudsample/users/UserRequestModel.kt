package com.noirtvt.crudsample.users

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY

@JsonAutoDetect(fieldVisibility = ANY)
data class UserRequestModel(
    val firstName: String,
    val lastName: String?,
    val email: String,
    val phoneNumber: String?,
    val role: String
)
