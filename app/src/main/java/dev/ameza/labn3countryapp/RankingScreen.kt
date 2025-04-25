package dev.ameza.labn3countryapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

data class Pais(val nombre: String, val ranking: Int, val banderaResId: Int)
@Composable
fun RankingScreen(){
    val paises = listOf(
        Pais("Brasil", 1, R.drawable.brazil),
        Pais("Argentina", 2, R.drawable.argentina),
        Pais("Francia", 3, R.drawable.francia)
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Ranking FIFA", style = MaterialTheme.typography.titleLarge)

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(paises) { pais ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = pais.banderaResId),
                            contentDescription = pais.nombre,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(text = pais.nombre, style = MaterialTheme.typography.bodyLarge)
                            Text(text = "Ranking FIFA: ${pais.ranking}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}