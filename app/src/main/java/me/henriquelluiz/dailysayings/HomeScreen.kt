package me.henriquelluiz.dailysayings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.henriquelluiz.dailysayings.model.Saying
import me.henriquelluiz.dailysayings.ui.theme.DailySayingsTheme

@Composable
fun SayingList(
    sayings: Array<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(sayings) { index, item ->
            val saying = Saying(index + 1, item)
            SayingCard(
                saying = saying,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = dimensionResource(R.dimen.large),
                        vertical = dimensionResource(R.dimen.medium)
                    )
            )
        }
    }
}

@Composable
fun SayingCard(
    saying: Saying,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        var isMarked by remember { mutableStateOf(false) }

        Column(modifier = Modifier.padding(dimensionResource(R.dimen.medium))) {
            AssistChip(
                onClick = { isMarked = !isMarked },
                label = {
                    Text(
                        text = stringResource(R.string.day_of_month, saying.dayOfMonth),
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                leadingIcon = {
                    if (isMarked) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_check_circle_outline_24),
                            contentDescription = "Day Of Month",
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.size(AssistChipDefaults.IconSize)
                        )
                    } else {
                        Icon(
                            painter = painterResource(R.drawable.baseline_radio_button_unchecked_24),
                            contentDescription = "Day Of Month",
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.size(AssistChipDefaults.IconSize)
                        )
                    }

                },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                ),
                modifier = Modifier
                    .sizeIn(maxHeight = 26.dp, maxWidth = 86.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium)))
            Text(
                text = saying.content,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(
    showBackground = true,
    apiLevel = 33
)
@Composable
fun HomeScreenPreview() {
    val sayings = stringArrayResource(R.array.list_of_sayings_pt)
    DailySayingsTheme {
        SayingList(sayings = sayings)
    }
}