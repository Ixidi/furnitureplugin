plugins {
    id("com.github.johnrengelman.shadow") version "5.2.0" apply false
    kotlin("jvm") version "1.3.72" apply false
}

allprojects {
    group = "xyz.ixidi.furniture"
    version = "1.0"
}

subprojects {

    apply(plugin = "com.github.johnrengelman.shadow")

    repositories {
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
        archiveBaseName.set("furniture-${this@subprojects.name}")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

}