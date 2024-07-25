package com.curiousapps.countryqlapi.data

import com.curiousapps.CountriesQuery
import com.curiousapps.CountryQuery
import com.curiousapps.countryqlapi.domain.DetailCountry
import com.curiousapps.countryqlapi.domain.ListCountry

fun CountryQuery.Country.toDetailCountry(): DetailCountry{
    return DetailCountry(
        name = name,
        capital = capital ?: "No Cap",
        code = code,
        emoji = emoji,
        currency = currency ?: "No Currentsy",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}fun CountriesQuery.Country.toListCountry(): ListCountry{
    return ListCountry(
        name = name,
        capital = capital ?: "No Cap",
        code = code,
        emoji = emoji,
    )
}