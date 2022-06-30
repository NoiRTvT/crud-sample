package com.noirtvt.crudsample.users

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY
import com.noirtvt.crudsample.Pagination

@JsonAutoDetect(fieldVisibility = ANY)
data class UsersResponseModel constructor(
    private val users: List<UserResponseModel>,
    private val pagination: Pagination
)
