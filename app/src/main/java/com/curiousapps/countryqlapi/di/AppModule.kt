package com.curiousapps.countryqlapi.di

import com.apollographql.apollo3.ApolloClient
import com.curiousapps.countryqlapi.data.ApolloCountryClient
import com.curiousapps.countryqlapi.domain.CountryClient
import com.curiousapps.countryqlapi.domain.GetCountriesUseCase
import com.curiousapps.countryqlapi.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient{
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient{
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase{
        return GetCountriesUseCase(countryClient)
    }
    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient): GetCountryUseCase{
        return GetCountryUseCase(countryClient)
    }
}