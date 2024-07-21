package cromega.studio.measurepedia.ui.components.elements

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextTitle(modifier: Modifier = Modifier, textAlign: TextAlign = TextAlign.Start, text: String) =
    Text(
        modifier = Modifier.then(modifier),
        fontSize = 35.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = textAlign,
        text = text
    )

@Composable
fun TextSubtitle(modifier: Modifier = Modifier, textAlign: TextAlign = TextAlign.Start, text: String) =
    Text(
        modifier = Modifier.then(modifier),
        fontSize = 22.5.sp,
        fontStyle = FontStyle.Italic,
        textAlign = textAlign,
        text = text
    )

@Composable
fun TextLeftAligned(modifier: Modifier = Modifier, text: String) =
    Text(
        modifier = Modifier.then(modifier),
        textAlign = TextAlign.Start,
        text = text
    )

@Composable
fun TextRightAligned(modifier: Modifier = Modifier, text: String) =
    Text(
        modifier = Modifier.then(modifier),
        textAlign = TextAlign.End,
        text = text
    )

@Composable
fun TextSmall(modifier: Modifier = Modifier, text: String) =
    Text(
        modifier = Modifier.then(modifier),
        fontSize = 13.sp,
        text = text
    )