package org.redbee.adapter.exception

import org.redbee.config.GenericException

class NotFoundException(description: String) : GenericException(description) {
}