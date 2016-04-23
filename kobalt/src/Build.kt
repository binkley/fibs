import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.kotlin.*

val repos = repos()

val p = project {
    name = "fibs"
    group = "hm.binkley"
    artifactId = name
    version = "0-SNAPSHOT"

    sourceDirectories {
        path("src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/kotlin")
    }

    dependencies {
//        compile("com.beust:jcommander:1.48")
    }

    dependenciesTest {
        compile("org.testng:testng:6.9.9")
    }

    assemble {
        jar {
            fatJar = true
            manifest {
                attributes("Main-Class", "hm.binkley.MainKt")
            }
        }
    }

    application {
        mainClass = "hm.binkley.MainKt"
    }
}
