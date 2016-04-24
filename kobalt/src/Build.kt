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

    dependenciesTest {
        compile("junit:junit:4.12")
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
