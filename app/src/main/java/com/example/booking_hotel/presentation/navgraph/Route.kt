package com.example.booking_hotel.presentation.navgraph

sealed class Route(
    val route: String
) {
    data object SplashScreen : Route("SplashScreen")
    data object IntroScreen : Route("IntroScreen")
    data object RegisterScreen : Route("RegisterScreen")
    data object LoginScreen : Route("LoginScreen")
    data object HomeScreen : Route("HomeScreen")
    data object ExploreScreen : Route("ExploreScreen")
    data object OrderScreen : Route("OrderScreen")
    data object AccountScreen : Route("AccountScreen")
    data object NavigatorScreen : Route("NavigatorScreen")
    data object ConfirmOrderScreen : Route("ConfirmOrderScreen/{checkInDate}/{checkOutDate}/{numberNight}/{price}") {
        fun passData(
            checkInDate: String,
            checkOutDate: String,
            numberNight: Int,
            price: Double
        ): String {
            return "ConfirmOrderScreen/$checkInDate/$checkOutDate/$numberNight/$price"
        }
    }
    data object DetailScreen : Route("DetailScreen/{checkInDate}/{checkOutDate}/{adult}/{children}") {
        fun passData(
            checkInDate: String,
            checkOutDate: String,
            adult: String,
            children: String
        ): String {
            return "DetailScreen/$checkInDate/$checkOutDate/$adult/$children"
        }
    }
    data object SearchScreen : Route("SearchScreen/{searchQuery}/{checkInDate}/{checkOutDate}/{adult}/{children}") {
        fun passData(
            searchQuery: String,
            checkInDate: String,
            checkOutDate: String,
            adult: String,
            children: String,
        ): String {
            return "SearchScreen/$searchQuery/$checkInDate/$checkOutDate/$adult/$children"
        }
    }
}