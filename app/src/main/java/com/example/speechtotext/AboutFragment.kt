package com.example.speechtotext

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.speechtotext.databinding.FragmentAboutBinding
import com.example.speechtotext.databinding.FragmentSupportBinding

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.textAbout.text = """
            **Haqqımızda**  
            Speech To Text tətbiqi, istifadəçilərin danışıq nitqini mətnə çevirmək üçün yaradılmışdır. 
            Bu tətbiq, sürətli və dəqiq səs tanıma funksiyaları ilə istifadəçilərə rahat və səmərəli 
            şəkildə mətn yazmağa kömək edir. İstər qeydlərinizi aparmaq, istərsə də uzun mətnləri yazmaq 
            üçün danışmaq kifayətdir!

            **Xüsusiyyətlərimiz:**  
            ✔ **Danışıqdan mətnə çevirin** – Sürətli və dəqiq səs tanıma texnologiyası.  
            ✔ **Mətn redaktəsi** – Yazılmış mətn üzərində düzəlişlər edin.  
            ✔ **Word faylına yadda saxlayın** – Qeydlərinizi .docx formatında saxlayın.  
            ✔ **Tək düymə ilə səs yazın** – İstifadəsi asan və rahat interfeys.  
            ✔ **Dil dəstəyi** – Çoxsaylı dillər üçün səs tanıma imkanı.  

            Biz daim tətbiqi təkmilləşdirməyə və istifadəçilərimizin ehtiyaclarını qarşılamağa çalışırıq. 
            Fikirləriniz bizim üçün önəmlidir!  

           
        """.trimIndent()

        return view
    }
}
