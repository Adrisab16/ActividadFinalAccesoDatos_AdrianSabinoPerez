import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    id("org.openjfx.javafxplugin") version "0.0.10"
}
javafx {
    version = "16" // Puedes ajustar la versión de JavaFX según tu necesidad
    modules = listOf("javafx.controls", "javafx.fxml")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org/maven2")
    }
    google()
    maven {
        url = uri("https://repo.spring.io/release")
    }
    maven {
        url = uri("https://repository.jboss.org/maven2")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    //implementation("de.felixroske.jfxsupport:javafx-spring-boot-starter:8.0.8")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    //implementation("org.openjfx:javafx-controls:21.0.1")
    //implementation("org.openjfx:javafx-fxml:21.0.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
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
