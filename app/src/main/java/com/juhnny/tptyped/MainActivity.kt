package com.juhnny.tptyped

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.juhnny.tptyped.R
import com.juhnny.tptyped.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Typed에서 가장 중요한 건 자료의 관리
    // DB 구조에 대해 유추해보고 DB를 설계하는 게 먼저...겠지만
    // 일단 UXI 구현부터 통과돼야되니 그것부터 해보자
    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val fragments = listOf(InboxFragment(), InfoFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragments[0]).commit()
        b.bnv.setOnItemSelectedListener {
            fragmentManager.fragments.forEach {
                fragmentManager.beginTransaction().hide(it).commit()
            }

            val trans = fragmentManager.beginTransaction()
            when(it.itemId){
                R.id.aa -> {
                    trans.show(fragments[0])
                }
                R.id.bb -> {
                    if( ! fragmentManager.fragments.contains(fragments[1])) trans.add(R.id.fragment_container, fragments[1])
                    trans.show(fragments[1])
                }
            }
            trans.commit()

            true
        }

    }
}