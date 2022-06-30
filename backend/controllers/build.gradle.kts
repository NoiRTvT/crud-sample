dependencies {
    implementation(project(":backend:domain"))
    implementation(project(":backend:models"))
    implementation(project(":backend:services"))
    implementation(project(":backend:repositories"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}