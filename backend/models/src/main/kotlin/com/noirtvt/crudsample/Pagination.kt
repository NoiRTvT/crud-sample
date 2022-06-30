package com.noirtvt.crudsample

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY
import kotlin.math.ceil

@JsonAutoDetect(fieldVisibility = ANY)
data class Pagination(
    private val page: Int,
    private val size: Int,
    private val totalElements: Int,
    private val totalPages: Int
) {

    constructor(paginationFilters: PaginationFilters, count: Long) : this(
        paginationFilters.page,
        paginationFilters.size,
        count.toInt(),
        ceil(count.toDouble() / paginationFilters.size.toDouble()).toInt()
    )
}
