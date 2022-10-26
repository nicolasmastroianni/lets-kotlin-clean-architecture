package org.redbee.application.port.`in`

interface CreateDigimonCommand {
    fun execute(command: Command): Unit

    class Command(
        private val name: String
    ) {
        fun getName() : String {
            return this.name
        }
    }
}