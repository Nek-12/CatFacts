plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

sourceSets.all {
    java.srcDir("src/$name/kotlin")
}
