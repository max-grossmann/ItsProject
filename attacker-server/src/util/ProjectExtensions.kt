package com.kleinmann.util

import io.ktor.application.*
import java.io.File

fun Application.getResourceContent(path: String): String {
    val resource = javaClass.classLoader.getResource(path)
    return resource?.readText() ?: ""
}

fun File.inProjectResources() {


}