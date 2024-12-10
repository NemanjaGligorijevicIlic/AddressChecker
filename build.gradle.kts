plugins {
    id("java")
}

group = "zoo.tours.hybrid"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.seleniumhq.selenium:selenium-java:4.13.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.5.3")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.slf4j:slf4j-simple:1.7.36")
    implementation("org.apache.poi:poi:5.2.3")
    implementation("org.apache.poi:poi-ooxml:5.2.3")
}


tasks.test {
    useJUnitPlatform()
}