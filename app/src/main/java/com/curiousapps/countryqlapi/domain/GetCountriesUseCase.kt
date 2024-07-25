package com.curiousapps.countryqlapi.domain

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(): List<ListCountry>{
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}