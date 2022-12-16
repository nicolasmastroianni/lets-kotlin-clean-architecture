package org.redbee.adapter.exception

import org.redbee.shared.error.model.exception.GenericException

class NotFoundException(description: String) : GenericException(description)
