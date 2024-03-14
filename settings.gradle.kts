plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "PRO_2324_u4u5u6_libre"
include("src:test:kotlin")
findProject(":src:test:kotlin")?.name = "kotlin"
include("src:test")
findProject(":src:test")?.name = "test"
include("src:test")
findProject(":src:test")?.name = "test"
