package org.redbee.adapter.out.hibernate.utils

class FileReader {
    companion object {
        fun execute(path: String): String {
            val contextClassLoader = Thread.currentThread().contextClassLoader
            return contextClassLoader.getResource(path).readText()
        }
    }
}