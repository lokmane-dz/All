package me.lokmvne.common_ui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.lokmvne.common_ui.R

val MyFontFamily = FontFamily(
    Font(R.font.poppinslight, FontWeight.Light),
    Font(R.font.poppinslightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.poppinsregular, FontWeight.Normal),
    Font(R.font.poppinsitalic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.poppinsmedium, FontWeight.Medium),
    Font(R.font.poppinsmediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.poppinssemibold, FontWeight.SemiBold),
    Font(R.font.poppinssemibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.poppinsbold, FontWeight.Bold),
    Font(R.font.poppinsbolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.poppinsextrabold, FontWeight.ExtraBold),
    Font(R.font.poppinsmediumitalic, FontWeight.ExtraBold, FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)