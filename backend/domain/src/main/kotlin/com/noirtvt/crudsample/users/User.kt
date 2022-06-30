package com.noirtvt.crudsample.users

import com.noirtvt.crudsample.roles.Role
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Users : IntIdTable() {

    val firstName = varchar("firstName", 50)
    val lastName = varchar("lastName", 50).nullable()
    val email = varchar("email", 50).uniqueIndex()
    val phoneNumber = varchar("phoneNumber", 11).nullable().uniqueIndex()
    val role = customEnumeration(
        "role",
        "ENUM('OWNER', 'EMPLOYEE', 'DEVELOPER')",
        { value -> Role.valueOf(value as String) },
        { it.name })
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var firstName by Users.firstName
    var lastName by Users.lastName
    var email by Users.email
    var phoneNumber by Users.phoneNumber
    var role by Users.role
}