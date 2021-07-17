package com.sandyara.aula21

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sandyara.aula21.presentation.FormActivity
import com.sandyara.aula21.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    /*
    * Dado que um usuário está na tela inicial
    * Quando ele clicar no FAB
    * Então deve ser exibida a Activity de Formulario
    * */

    //ARRANGE
    @get:Rule
    val mainActivity = IntentsTestRule(MainActivity::class.java)

    @Test
    fun when_click_on_FAB_go_to_FormActivity(){
        //ACT
        onView(withId(R.id.fabNext)).perform(click())
        //ASSERT
        intended(hasComponent(FormActivity::class.java.name))
    }
}