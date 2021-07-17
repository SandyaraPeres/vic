package com.sandyara.aula21

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
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
class FormTest {

    /*
    * Dado que um usuário está na tela inicial
    * Quando ele clicar no FAB
    * Então deve ser exibida a Activity de Formulario
    * */

    /*
    * Dado que um usuário está na formulario
    * Quando ele digitar nos campos seu nome e mensagem
    * Então deve ser exibido um Toast
    * */

    //ARRANGE
    @get:Rule
    val mainActivity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun start_form(){
        onView(withId(R.id.fabNext)).perform(click())
        onView(withId(R.id.edtNome)).perform(typeText("Sandy"))
        onView(withId(R.id.edtMessage)).perform(typeText("voce e um xuxu"), closeSoftKeyboard())
        onView(withId(R.id.btnExibir)).perform(click())
    }
}