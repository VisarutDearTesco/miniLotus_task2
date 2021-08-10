package com.visarut.minilotus_task2.recycleView

data class ErrorResponse(
	val error: Error? = null
)

data class Error(
	val traceId: String? = null,
	val code: Int? = null,
	val description: String? = null,
	val detail: String? = null,
	val type: String? = null
)

