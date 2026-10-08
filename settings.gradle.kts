pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Basket"
include(":app")
include(":feature:home:data")
include(":feature:cart:data")
include(":feature:details:data")
include(":feature:explore:presentation")
include(":feature:explore:domain")
include(":feature:home:presentation")
include(":feature:home:domain")
include(":feature:details:presentation")
include(":feature:details:domain")
include(":feature:cart:presentation")
include(":feature:cart:domain")
include(":feature:explore:data")
include(":core:ui")
include(":core:database")

include(":feature:profile:presentation")
include(":feature:auth:login")
include(":feature:auth:signup")
