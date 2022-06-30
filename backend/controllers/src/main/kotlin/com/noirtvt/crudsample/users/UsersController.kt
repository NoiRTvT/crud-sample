package com.noirtvt.crudsample.users

import com.noirtvt.crudsample.PaginationFilters
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController(private val usersRepository: UsersRepository, private val usersService: UsersService) {

    @GetMapping("/api/v1/users")
    fun getUsers(
        @RequestParam(defaultValue = "") search: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int = 10
    ): UsersResponseModel {
        val paginationFilters = PaginationFilters(page, size)
        return usersRepository.getUsers(search, paginationFilters)
    }

    @GetMapping("/api/v1/users/{userId}")
    fun getUser(@PathVariable userId: Int): UserResponseModel {
        return usersRepository.getUser(userId)
    }

    @PostMapping("/api/v1/users")
    fun addUser(@RequestBody model: UserRequestModel) {
        usersService.addUser(model)
    }

    @PutMapping("/api/v1/users/{userId}")
    fun updateUser(@PathVariable userId: Int, @RequestBody model: UserRequestModel) {
        usersService.updateUser(userId, model)
    }

    @DeleteMapping("/api/v1/users/{userId}")
    fun deleteUsers(@PathVariable userId: Int) {
        usersService.deleteUser(userId)
    }
}