repositories {
  mavenCentral()
  maven("https://jitpack.io")
}
plugins {
  kotlin("jvm") version "1.5.20-M1"
  id("com.github.johnrengelman.shadow") version "6.1.0"
}
dependencies {
  implementation("com.google.guava:guava:30.1.1-jre")
  implementation("co.touchlab:stately-isolate-jvm:1.1.7-a1")
  implementation("ch.qos.logback:logback-classic:1.3.0-alpha5")
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.0-M1")
  testImplementation("com.natpryce:hamkrest:1.8.0.1")
  testImplementation("io.mockk:mockk:1.11.0")
}
tasks.compileKotlin {
  kotlinOptions.jvmTarget = "16"
  kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime"
}
tasks.compileTestKotlin {
  kotlinOptions.jvmTarget = "16"
  kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime"
}
tasks.test {
  useJUnitPlatform()
}
tasks.jar {
  manifest.attributes("Main-Class" to "AppKt")
}