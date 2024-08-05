package com.curiousapps.countryqlapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.countryqlapi.presentation.CountriesScreen
import com.curiousapps.countryqlapi.presentation.CountryViewModel
import com.curiousapps.countryqlapi.ui.theme.CountryQLApiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryQLApiTheme {
                val viewModel = hiltViewModel<CountryViewModel>()
                val state by viewModel.state.collectAsState()

                CountriesScreen(
                    state = state,
                    onSelectCountry = {viewModel.selectCountry(it)},
                    onDismissDialog = {viewModel.dismissDialogBox()}
                )
            }
        }
    }
}
