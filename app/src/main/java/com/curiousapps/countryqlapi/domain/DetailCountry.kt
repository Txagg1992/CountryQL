package com.curiousapps.countryqlapi.domain

data class DetailCountry(
    val name: String,
    val capital: String,
    val code: String,
    val emoji: String,
    val currency: String,
    val languages: List<String>,
    val continent: String,
)
