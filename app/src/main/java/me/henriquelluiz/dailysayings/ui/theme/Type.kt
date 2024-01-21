package me.henriquelluiz.dailysayings.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.henriquelluiz.dailysayings.R

val JosefinSans = FontFamily(
    Font(R.font.josefin_sans_light, FontWeight.Light),
    Font(R.font.josefin_sans_regular, FontWeight.Normal)
)

val Melodrama = FontFamily(
    Font(R.font.melodrama_bold, FontWeight.Bold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Melodrama,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = JosefinSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = JosefinSans,
        fontWeight = FontWeight.Light,
        fontSize = 11.sp
    )
)