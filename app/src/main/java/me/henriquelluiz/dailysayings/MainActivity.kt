package me.henriquelluiz.dailysayings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import me.henriquelluiz.dailysayings.ui.theme.DailySayingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailySayingsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val listOfSayings: Array<String> = stringArrayResource(R.array.list_of_sayings_pt)
    Text(
        text = listOfSayings[16],
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    apiLevel = 33
)
@Composable
fun GreetingPreview() {
    DailySayingsTheme {
        Greeting()
    }
}