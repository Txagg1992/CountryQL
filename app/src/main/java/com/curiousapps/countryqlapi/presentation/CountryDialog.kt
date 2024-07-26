package com.curiousapps.countryqlapi.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.curiousapps.countryqlapi.domain.DetailCountry

@Composable
fun CountryDialog(
    country: DetailCountry,
    onDismissDialog: ()-> Unit,
    modifier: Modifier = Modifier
){
    val languageList = remember(country.languages){
        country.languages.joinToString ()
    }

    Dialog(
        onDismissRequest = onDismissDialog
    ){
        Column(
            modifier = modifier
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = country.emoji,
                    fontSize = 60.sp
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = country.name,
                    fontSize =30.sp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = country.capital,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Continent: ${country.continent}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Currency: ${country.currency}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Capital: ${country.capital}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Languages: $languageList")
        }
    }

}