package com.azrinurvani.newsapicompose.presentation.theme
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.azrinurvani.newsapicompose.presentation.component.theme.AppTypography
import com.azrinurvani.newsapicompose.presentation.component.theme.backgroundDark
import com.azrinurvani.newsapicompose.presentation.component.theme.backgroundLight
import com.azrinurvani.newsapicompose.presentation.component.theme.errorContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.errorContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.errorDark
import com.azrinurvani.newsapicompose.presentation.component.theme.errorLight
import com.azrinurvani.newsapicompose.presentation.component.theme.inverseOnSurfaceDark
import com.azrinurvani.newsapicompose.presentation.component.theme.inverseOnSurfaceLight
import com.azrinurvani.newsapicompose.presentation.component.theme.inversePrimaryDark
import com.azrinurvani.newsapicompose.presentation.component.theme.inversePrimaryLight
import com.azrinurvani.newsapicompose.presentation.component.theme.inverseSurfaceDark
import com.azrinurvani.newsapicompose.presentation.component.theme.inverseSurfaceLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onBackgroundDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onBackgroundLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onErrorContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onErrorContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onErrorDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onErrorLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onPrimaryContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onPrimaryContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onPrimaryDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onPrimaryLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onSecondaryContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onSecondaryContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onSecondaryDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onSecondaryLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onSurfaceDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onSurfaceLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onSurfaceVariantDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onSurfaceVariantLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onTertiaryContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onTertiaryContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.onTertiaryDark
import com.azrinurvani.newsapicompose.presentation.component.theme.onTertiaryLight
import com.azrinurvani.newsapicompose.presentation.component.theme.outlineDark
import com.azrinurvani.newsapicompose.presentation.component.theme.outlineLight
import com.azrinurvani.newsapicompose.presentation.component.theme.outlineVariantDark
import com.azrinurvani.newsapicompose.presentation.component.theme.outlineVariantLight
import com.azrinurvani.newsapicompose.presentation.component.theme.primaryContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.primaryContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.primaryDark
import com.azrinurvani.newsapicompose.presentation.component.theme.primaryLight
import com.azrinurvani.newsapicompose.presentation.component.theme.scrimDark
import com.azrinurvani.newsapicompose.presentation.component.theme.scrimLight
import com.azrinurvani.newsapicompose.presentation.component.theme.secondaryContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.secondaryContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.secondaryDark
import com.azrinurvani.newsapicompose.presentation.component.theme.secondaryLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceBrightDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceBrightLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerHighDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerHighLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerHighestDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerHighestLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerLowDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerLowLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerLowestDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceContainerLowestLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceDimDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceDimLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceLight
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceVariantDark
import com.azrinurvani.newsapicompose.presentation.component.theme.surfaceVariantLight
import com.azrinurvani.newsapicompose.presentation.component.theme.tertiaryContainerDark
import com.azrinurvani.newsapicompose.presentation.component.theme.tertiaryContainerLight
import com.azrinurvani.newsapicompose.presentation.component.theme.tertiaryDark
import com.azrinurvani.newsapicompose.presentation.component.theme.tertiaryLight

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)


@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun NewsAPIComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

