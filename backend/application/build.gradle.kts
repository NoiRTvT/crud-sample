plugins {
    id("org.springframework.boot")
}

group = "com.noirtvt"
version = "0.0.1-SNAPSHOT"

dependencies {
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation(project(":backend:domain"))
    implementation(project(":backend:repositories"))
    implementation(project(":backend:controllers"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter")

    runtimeOnly("com.h2database:h2")
}
