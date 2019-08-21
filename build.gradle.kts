import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.41"
}

group = "com.dkorobtsov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.12.1")
    implementation("org.apache.logging.log4j:log4j-api-kotlin:1.0.0")
    implementation("org.apache.commons:commons-text:1.1")
    testCompile("org.testng:testng:6.14.3")
    implementation(kotlin("stdlib-jdk8"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.register<Test>("kotlinFloodTest") {
    include("**/kotlinflood/KotlinOutputFloodingTestFactory.*")
    configureTestRunner()
}

tasks.register<Test>("javaFloodTest") {
    include("**/javaflood/OutputFloodingTestFactory.*")
    configureTestRunner()
}

tasks.named<Test>("test") {
    include("**/kotlinflood/KotlinOutputFloodingTestFactory.*")
    include("**/javaflood/OutputFloodingTestFactory.*")
    configureTestRunner()
}

fun Test.configureTestRunner() {
    group = "tests"
    useTestNG()
    outputs.upToDateWhen {
        false
    }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}