package pl.michal_boryczko.domain.models.exceptions

/**
 * Created by ${michal_boryczko} on 14.08.2018.
 */
data class ApiErrorException(
		val error: String,
		val errorCode: Int
): Exception(error)