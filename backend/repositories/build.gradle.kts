dependencies {
    implementation(project(":backend:domain"))
    implementation(project(":backend:models"))

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter")
}