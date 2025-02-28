package com.example.speechtotext

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.speechtotext.databinding.FragmentSupportBinding

class SupportFragment : Fragment() {
    private lateinit var binding: FragmentSupportBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSupportBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.textSupport.text = """
            **Dəstək**  

            **Probleminiz var? Biz kömək etməyə hazırıq!**  
            Əgər tətbiqlə bağlı sualınız, problemi və ya təklifiniz varsa, bizimlə əlaqə saxlayın.  
            Komandamız sizə tez bir zamanda cavab verəcək.  

            **Dəstək üçün əlaqə vasitələri:**  
            📧 **Email:** rizvan.davudov@yahoo.com  /  davudovrizvan55@gmail.com 
            📞 **Telefon:** +994 70-611-48-81
            🌍 **Vebsayt:** https://github.com/rizvandavudov  
            🌍 **Vebsayt:**  https://www.linkedin.com/in/rizvan-davudov-8b995b325/

            **Tez-tez verilən suallar:**  
            ❓ **Tətbiq niyə səsimi düzgün tanımır?**  
            ✅ Mümkün səbəblər: səsli nitqin sürəti, ətraf səs-küy, internet bağlantısı zəifliyi.  
            **Həll yolu:** Sakit bir mühitdə danışmağa çalışın və cihazın mikrofonuna yaxın olun.  

            ❓ **Mətnləri necə redaktə edə bilərəm?**  
            ✅ EditText sahəsinə daxil olub istədiyiniz mətnləri əl ilə düzəldə bilərsiniz.  

            ❓ **Faylı saxladım, harada tapa bilərəm?**  
            ✅ Word (.docx) sənədləri **"Download/SpeechToText"** qovluğuna saxlanır.  

            **Daha çox sualınız varsa, bizimlə əlaqə saxlayın!**  
        """.trimIndent()

        return view
    }
}
