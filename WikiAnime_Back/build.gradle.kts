import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    //Permet à JAVA de se connecter à une base SQL
    runtimeOnly("com.mysql:mysql-connector-j")

    //JPA Framework Java qui génère du SQL
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    //Requete
    implementation("com.squareup.okhttp3:okhttp:+")
    //Parsing JSON
    implementation("com.google.code.gson:gson:+")
    //Utilisation générale
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:+")

    implementation("com.squareup.retrofit2:retrofit:2.+")
    implementation("com.squareup.retrofit2:converter-gson:2.+")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
