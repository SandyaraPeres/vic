package com.sandyara.aula21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat.setAccessibilityDelegate
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var rvCharacters: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCharacters = findViewById(R.id.rvCharacters)
        charactersAdapter = CharactersAdapter()
        rvCharacters.adapter = charactersAdapter
        rvCharacters.layoutManager = LinearLayoutManager(this)

        val pb = findViewById<ProgressBar>(R.id.progressBar)

        val xpto = findViewById<TextView>(R.id.teste)

//        pb.contentDescription = ""
//        pb.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
//        pb.isAccessibilityHeading = true
//        //pb.accessibilityTraversalAfter =

        //val aaa = 1
        //aaa.convertToString()

        getCharacters()


        xpto.accessibilityDelegate = setAccessibilityDelegate(xpto, object: AccessibilityDelegateCompat(){
            override fun onInitializeAccessibilityNodeInfo(host: View?, info: AccessibilityNodeInfoCompat?) {
                super.onInitializeAccessibilityNodeInfo(host, info)
                info?.className = Button::class.java.name
            }
        }
    }

    fun getCharacters() {
        Network.getService().allCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                //Log.e()
            }
            .subscribe { resposta ->
                charactersAdapter.dataset.addAll(resposta.data.results)
                charactersAdapter.notifyDataSetChanged()
                rvCharacters.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_NONE
                rvCharacters.announceForAccessibility("Lista carregada")
            }

    }
}