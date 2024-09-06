package me.lokmvne.foodpro.presentation.ui.start.onBoarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.async
import me.lokmvne.foodpro.presentation.ui.start.StartScreens

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navHostController: NavHostController,
    lifecycle: LifecycleCoroutineScope
) {
    val onBoardingviewModel = hiltViewModel<OnbOardingViewModel>()
    val OnBoardingPages = listOf(
        OnBoardingPage.Screen1,
        OnBoardingPage.Screen2,
        OnBoardingPage.Screen3
    )

    val pagerState = rememberPagerState(pageCount = { OnBoardingPages.size })

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) {
            PagerScreen(onBoardingPage = OnBoardingPages[it])
        }

        FinishButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState
        )
        {
            val setOnboardingCompleted = lifecycle.async {
                onBoardingviewModel.setOnboardingCompleted()
            }
            setOnboardingCompleted.invokeOnCompletion {
                navHostController.navigate(StartScreens.LoginScreen.route) {
                    popUpTo(StartScreens.LoginScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
    }
}