package com.example.pvh_cenima.ui.theme


import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    // Basic spacing
    val extraSmall: Dp = 0.dp,      // 1-6dp range
    val small: Dp = 0.dp,            // 2-8dp range
    val small2: Dp = 0.dp,           // 3-10dp range
    val small3: Dp = 0.dp,           // 4-12dp range
    val medium1: Dp = 0.dp,         // 8-20dp range
    val medium2: Dp = 0.dp,         // 13-24dp range
    val medium3: Dp = 0.dp,         // 14-32dp range
    val large: Dp = 0.dp,            // 16-40dp range
    val large2: Dp = 0.dp,           // 24-44dp range

    // Component sizes
    val buttonHeight: Dp = 40.dp,
    val logoSize: Dp = 42.dp,
    val textFieldHeight: Dp = 60.dp,
    val iconSizeSmall: Dp = 20.dp,
    val iconSizeMedium: Dp = 24.dp,
    val iconSizeLarge: Dp = 50.dp,

    // Spacing
    val screenPadding: Dp = 24.dp,   // Screen horizontal padding
    val spacingSmall: Dp = 5.dp,     // 5dp spacing
    val spacingMedium: Dp = 32.dp,   // 32dp spacing
    val spacingLarge: Dp = 48.dp,     // 48dp spacing
    val spacingXLarge: Dp = 60.dp,   // 60dp spacing
    val height1: Dp = 220.dp,        // Component height

    // Corner radius
    val cornerRadiusSmall: Dp = 8.dp,
    val cornerRadiusMedium: Dp = 10.dp,
    val cornerRadiusLarge: Dp = 12.dp,
    val cornerRadiusXLarge: Dp = 16.dp,

    // Elevation
    val elevationSmall: Dp = 1.dp,
    val elevationMedium: Dp = 2.dp,
    val elevationLarge: Dp = 4.dp,

    // Border widths
    val borderThin: Dp = 0.5.dp,
    val borderMedium: Dp = 1.dp,
    val borderThick: Dp = 1.5.dp
)

// 🔹 Compact Small — small phones (under ~360dp width)
val CompactSmallDimens = Dimens(
    extraSmall = 1.dp,
    small = 2.dp,
    small2 = 3.dp,
    small3 = 4.dp,
    medium1 = 8.dp,
    medium2 = 13.dp,
    medium3 = 14.dp,
    large = 16.dp,
    large2 = 24.dp,
    buttonHeight = 36.dp,
    logoSize = 36.dp,
    textFieldHeight = 56.dp,
    iconSizeSmall = 18.dp,
    iconSizeMedium = 20.dp,
    iconSizeLarge = 48.dp,
    screenPadding = 20.dp,
    spacingSmall = 4.dp,
    spacingMedium = 28.dp,
    spacingLarge = 44.dp,
    spacingXLarge = 56.dp,
    height1 = 220.dp,
    cornerRadiusSmall = 7.dp,
    cornerRadiusMedium = 9.dp,
    cornerRadiusLarge = 11.dp,
    cornerRadiusXLarge = 14.dp,
    elevationSmall = 1.dp,
    elevationMedium = 2.dp,
    elevationLarge = 4.dp,
    borderThin = 0.5.dp,
    borderMedium = 1.dp,
    borderThick = 1.5.dp
)

// 🔹 Compact Medium — most standard phones (360dp–420dp)
val CompactMediumDimens = Dimens(
    extraSmall = 2.dp,
    small = 4.dp,
    small2 = 6.dp,
    small3 = 8.dp,
    medium1 = 12.dp,
    medium2 = 14.dp,
    medium3 = 16.dp,
    large = 24.dp,
    large2 = 32.dp,
    buttonHeight = 40.dp,
    logoSize = 40.dp,
    textFieldHeight = 60.dp,
    iconSizeSmall = 20.dp,
    iconSizeMedium = 24.dp,
    iconSizeLarge = 50.dp,
    screenPadding = 24.dp,
    spacingSmall = 5.dp,
    spacingMedium = 32.dp,
    spacingLarge = 48.dp,
    spacingXLarge = 60.dp,
    height1 = 220.dp,
    cornerRadiusSmall = 8.dp,
    cornerRadiusMedium = 10.dp,
    cornerRadiusLarge = 12.dp,
    cornerRadiusXLarge = 16.dp,
    elevationSmall = 1.dp,
    elevationMedium = 2.dp,
    elevationLarge = 4.dp,
    borderThin = 0.5.dp,
    borderMedium = 1.dp,
    borderThick = 1.5.dp
)

// 🔹 Compact Large — larger phones or narrow tablets (~421–599dp)
val CompactLargeDimens = Dimens(
    extraSmall = 3.dp,
    small = 5.dp,
    small2 = 7.dp,
    small3 = 9.dp,
    medium1 = 13.dp,
    medium2 = 16.dp,
    medium3 = 18.dp,
    large = 28.dp,
    large2 = 36.dp,
    buttonHeight = 44.dp,
    logoSize = 44.dp,
    textFieldHeight = 64.dp,
    iconSizeSmall = 22.dp,
    iconSizeMedium = 26.dp,
    iconSizeLarge = 52.dp,
    screenPadding = 26.dp,
    spacingSmall = 6.dp,
    spacingMedium = 36.dp,
    spacingLarge = 52.dp,
    spacingXLarge = 64.dp,
    height1 = 230.dp,
    cornerRadiusSmall = 9.dp,
    cornerRadiusMedium = 11.dp,
    cornerRadiusLarge = 13.dp,
    cornerRadiusXLarge = 18.dp,
    elevationSmall = 1.dp,
    elevationMedium = 2.dp,
    elevationLarge = 4.dp,
    borderThin = 0.5.dp,
    borderMedium = 1.dp,
    borderThick = 1.5.dp
)

// 🔹 Medium — large phones, foldables, or small tablets
val MediumDimens = Dimens(
    extraSmall = 4.dp,
    small = 6.dp,
    small2 = 8.dp,
    small3 = 10.dp,
    medium1 = 16.dp,
    medium2 = 20.dp,
    medium3 = 24.dp,
    large = 32.dp,
    large2 = 40.dp,
    buttonHeight = 48.dp,
    logoSize = 56.dp,
    textFieldHeight = 68.dp,
    iconSizeSmall = 24.dp,
    iconSizeMedium = 28.dp,
    iconSizeLarge = 56.dp,
    screenPadding = 28.dp,
    spacingSmall = 7.dp,
    spacingMedium = 40.dp,
    spacingLarge = 56.dp,
    spacingXLarge = 68.dp,
    height1 = 230.dp,
    cornerRadiusSmall = 10.dp,
    cornerRadiusMedium = 12.dp,
    cornerRadiusLarge = 14.dp,
    cornerRadiusXLarge = 20.dp,
    elevationSmall = 1.dp,
    elevationMedium = 2.dp,
    elevationLarge = 4.dp,
    borderThin = 0.5.dp,
    borderMedium = 1.dp,
    borderThick = 1.5.dp
)

// 🔹 Expanded — tablets and large screens
val ExpandedDimens = Dimens(
    extraSmall = 6.dp,
    small = 8.dp,
    small2 = 10.dp,
    small3 = 12.dp,
    medium1 = 20.dp,
    medium2 = 24.dp,
    medium3 = 32.dp,
    large = 40.dp,
    large2 = 44.dp,
    buttonHeight = 56.dp,
    logoSize = 72.dp,
    textFieldHeight = 72.dp,
    iconSizeSmall = 28.dp,
    iconSizeMedium = 32.dp,
    iconSizeLarge = 64.dp,
    screenPadding = 32.dp,
    spacingSmall = 8.dp,
    spacingMedium = 48.dp,
    spacingLarge = 64.dp,
    spacingXLarge = 80.dp,
    height1 = 250.dp,
    cornerRadiusSmall = 12.dp,
    cornerRadiusMedium = 14.dp,
    cornerRadiusLarge = 16.dp,
    cornerRadiusXLarge = 24.dp,
    elevationSmall = 1.dp,
    elevationMedium = 2.dp,
    elevationLarge = 4.dp,
    borderThin = 0.5.dp,
    borderMedium = 1.dp,
    borderThick = 1.5.dp
)
