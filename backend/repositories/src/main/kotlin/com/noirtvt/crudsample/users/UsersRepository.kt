package com.noirtvt.crudsample.users

import com.noirtvt.crudsample.Pagination
import com.noirtvt.crudsample.PaginationFilters
import org.jetbrains.exposed.sql.Op.TRUE
import org.jetbrains.exposed.sql.SqlExpressionBuilder.like
import org.jetbrains.exposed.sql.lowerCase
import org.jetbrains.exposed.sql.or
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component

@Component
class UsersRepository {

    fun getUsers(search: String, paginationFilters: PaginationFilters) = transaction {
        val searchPattern = "${search.lowercase()}%"
        val searchExpression = if (search.isNotBlank()) {
            Users.firstName.lowerCase().like(searchPattern) or Users.lastName.lowerCase()
                .like(searchPattern) or Users.email.lowerCase().like(searchPattern) or Users.phoneNumber.lowerCase()
                .like(searchPattern)
        } else {
            TRUE
        }
        val users = User.find { searchExpression }
            .limit(paginationFilters.size, (paginationFilters.size * paginationFilters.page).toLong())
            .sortedBy { it.firstName }
        val pagination = Pagination(paginationFilters, User.count(searchExpression))
        val usersResponse = users.map {
            UserResponseModel(it.id.value, it.firstName, it.lastName, it.email, it.phoneNumber, it.role.name)
        }
        UsersResponseModel(usersResponse, pagination)
    }

    fun getUser(userId: Int) = transaction {
        val user = User.findById(userId) ?: throw IllegalStateException("User not found")
        UserResponseModel(null, user.firstName, user.lastName, user.email, user.phoneNumber, user.role.name)
    }
}