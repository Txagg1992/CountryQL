package com.curiousapps.countryqlapi.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CountriesScreen(
    state: CountryViewModel.CountriesState,
    onSelectCountry: (code: String) -> Unit,
    onDismissDialog: () -> Unit,
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        if (state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.Red
            )
        }else{
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.countries){country ->
                    CountryItem(
                        country = country,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                onSelectCountry(country.code)
                            }
                    )
                }
            }
        }
    }
}