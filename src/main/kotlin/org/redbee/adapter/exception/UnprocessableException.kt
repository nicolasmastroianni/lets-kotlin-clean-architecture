package org.redbee.adapter.exception

import org.redbee.shared.error.model.exception.GenericException

class UnprocessableException(description: String) : GenericException(description)
