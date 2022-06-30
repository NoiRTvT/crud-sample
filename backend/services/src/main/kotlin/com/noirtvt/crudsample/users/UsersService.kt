package com.noirtvt.crudsample.users

import com.noirtvt.crudsample.roles.Role
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component

@Component
class UsersService {

    fun addUser(model: UserRequestModel) = transaction {
        User.new {
            firstName = model.firstName
            lastName = model.lastName
            email = model.email
            phoneNumber = model.phoneNumber
            role = Role.valueOf(model.role)
        }
    }

    fun updateUser(userId: Int, model: UserRequestModel) = transaction {
        val user = User.findById(userId) ?: throw IllegalStateException("User not found")
        user.apply {
            firstName = model.firstName
            lastName = model.lastName
            email = model.email
            phoneNumber = model.phoneNumber
            role = Role.valueOf(model.role)
        }
    }

    fun deleteUser(userId: Int) = transaction {
        val user = User.findById(userId) ?: throw IllegalStateException("User not found")
        user.delete()
    }
}