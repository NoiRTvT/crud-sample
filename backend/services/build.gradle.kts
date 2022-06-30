dependencies {
    implementation(project(":backend:models"))
    implementation(project(":backend:domain"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter")
}