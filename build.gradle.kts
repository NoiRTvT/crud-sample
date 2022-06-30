plugins {
    id("org.springframework.boot") version "2.7.1" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21" apply false
    kotlin("plugin.spring") version "1.6.21" apply false
}

allprojects {
    apply {
        plugin("io.spring.dependency-management")
    }

    repositories {
        mavenCentral()
    }

    dependencyManagement {
        dependencies {
            dependency("org.jetbrains.exposed:exposed-spring-boot-starter:0.38.2")
        }
    }
}