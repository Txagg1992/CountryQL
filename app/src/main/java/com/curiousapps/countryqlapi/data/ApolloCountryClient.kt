package com.curiousapps.countryqlapi.data

import com.apollographql.apollo3.ApolloClient
import com.curiousapps.CountriesQuery
import com.curiousapps.CountryQuery
import com.curiousapps.countryqlapi.domain.CountryClient
import com.curiousapps.countryqlapi.domain.DetailCountry
import com.curiousapps.countryqlapi.domain.ListCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {
    override suspend fun getCountries(): List<ListCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toListCountry() } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailCountry()
    }
}