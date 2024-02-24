plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.pqm"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security
	implementation("org.springframework.boot:spring-boot-starter-security")
	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation
	implementation("org.springframework.boot:spring-boot-starter-validation")
	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-logging
	implementation("org.springframework.boot:spring-boot-starter-logging")
	// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-log4j2
	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
	implementation("io.jsonwebtoken:jjwt-api:0.12.5")

	// https://mvnrepository.com/artifact/org.projectlombok/lombok
	compileOnly("org.projectlombok:lombok:1.18.30")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	runtimeOnly("org.postgresql:postgresql")
	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
	// https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")
	annotationProcessor("org.projectlombok:lombok:1.18.30")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
	testCompileOnly("org.projectlombok:lombok:1.18.30")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
