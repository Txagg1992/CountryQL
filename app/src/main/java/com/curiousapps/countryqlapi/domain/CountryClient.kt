package com.curiousapps.countryqlapi.domain

import com.curiousapps.CountryQuery

interface CountryClient {

    suspend fun getCountries(): List<ListCountry>

    suspend fun getCountry(code: String): DetailCountry?
}