package com.noirtvt.crudsample

import com.noirtvt.crudsample.roles.Role
import com.noirtvt.crudsample.users.User
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrudSampleApplication

fun main(args: Array<String>) {
    runApplication<CrudSampleApplication>(*args)

    transaction {
        User.new {
            firstName = "Илья"
            lastName = "Осадчий"
            email = "noirtvt@gmail.com"
            phoneNumber = "79851236678"
            role = Role.DEVELOPER
        }
        User.new {
            firstName = "Tiernan"
            lastName = "Betts"
            email = "Tiernan.Betts@gmail.com"
            phoneNumber = "79998886651"
            role = Role.OWNER
        }
        User.new {
            firstName = "Garrett"
            lastName = "Campos"
            email = "Garrett.Campos@gmail.com"
            phoneNumber = "79998886652"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Percy"
            lastName = "Mckinney"
            email = "Percy.Mckinney@gmail.com"
            phoneNumber = "79998886653"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Kendal"
            lastName = "Glass"
            email = "Kendal.Glass@gmail.com"
            phoneNumber = "79998886654"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Luella"
            lastName = "Frank"
            email = "Luella.Frank@gmail.com"
            phoneNumber = "79998886656"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Wade"
            lastName = "Esquivel"
            email = "Wade.Esquivel@gmail.com"
            phoneNumber = "79998886657"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Milly"
            lastName = "Mcfadden"
            email = "Milly.Mcfadden@gmail.com"
            phoneNumber = "79998886658"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Alysha"
            lastName = "Watt"
            email = "Alysha.Watt@gmail.com"
            phoneNumber = "79968886655"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Fahima"
            lastName = "Matthews"
            email = "Fahima.Matthews@gmail.com"
            phoneNumber = "79918886655"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Osman"
            lastName = "Glover"
            email = "Osman.Glover@gmail.com"
            phoneNumber = "72998886655"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Ace"
            lastName = "Carroll"
            email = "Ace.Carroll@gmail.com"
            phoneNumber = "79998386655"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Aleena"
            lastName = "Logan"
            email = "Aleena.Logan@gmail.com"
            phoneNumber = "79998486655"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Maverick"
            lastName = "Ochoa"
            email = "Maverick.Ochoa@gmail.com"
            phoneNumber = "79998896655"
            role = Role.EMPLOYEE
        }
        User.new {
            firstName = "Cormac"
            email = "Cormac.Rodriquez@gmail.com"
            role = Role.EMPLOYEE
        }
    }
}
