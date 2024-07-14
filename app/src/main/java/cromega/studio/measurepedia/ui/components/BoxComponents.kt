package cromega.studio.measurepedia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun <T> Dropdown(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    option: T,
    options: Array<T>,
    extractOptionName: (T) -> String,
    onOptionSelected: (T) -> Unit,
    onClickMenu: () -> Unit
) =
    Box(
        modifier =
        Modifier
            .background(color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .border(width = 2.5.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable(onClick = onClickMenu)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextSmall( text = extractOptionName(option))
            VerticalArrowsIcon(arrowUp = expanded)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onClickMenu
        ) {
            options.forEach {
                DropdownMenuItem(
                    text = { Text(text = extractOptionName(it)) },
                    onClick = { onOptionSelected(it) }
                )
            }
        }
    }
