package com.curiousapps.countryqlapi.domain

class GetCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String): DetailCountry?{
        return countryClient
            .getCountry(code)
    }
}