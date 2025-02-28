package com.example.speechtotext

import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.speechtotext.databinding.ActivityMainBinding
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.File
import java.io.FileOutputStream
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding-i başlat
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Button-lara klik hadisələrini əlavə et
        binding.buttonInfo.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)
        }

        // Danışmağa başla düyməsi
        binding.button.setOnClickListener {
            startSpeechToText()
        }

        // Word faylına yadda saxla düyməsi
        binding.buttonSave.setOnClickListener {
            saveToWordFile(binding.editText.text.toString())
        }
    }

    private fun startSpeechToText() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Danışmağa başlayın...")

        try {
            startActivityForResult(intent, 1)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Sizin cihazınızda bu funksiya dəstəklənmir!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.get(0) ?: ""
            showResultDialog(result) // Nəticəni təsdiqlətmək üçün dialoq açılır
        }
    }

    // 📌 Danışıq nəticəsini təsdiqlətmək üçün dialoq
    private fun showResultDialog(result: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Danışıq Nəticəsi")
        builder.setMessage(result)

        builder.setPositiveButton("Təsdiqlə") { _, _ ->
            val currentText = binding.editText.text.toString() // Hal-hazırda yazılmış mətn
            val newText =
                if (currentText.isNotEmpty()) "$currentText $result" else result // Köhnə mətnin arxasına əlavə et
            binding.editText.setText(newText)
        }

        builder.setNegativeButton("Ləğv et") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun saveToWordFile(text: String) {
        // Əgər EditText boşdursa, istifadəçiyə xəbərdarlıq mesajı göstər
        if (text.isEmpty()) {
            Toast.makeText(this, "Xəbərdarlıq: Mətn daxil edilməyib!", Toast.LENGTH_SHORT).show()
            return // Funksiyadan çıx
        }

        try {
            val doc = XWPFDocument()
            val paragraph = doc.createParagraph()
            val run = paragraph.createRun()
            run.setText(text)

            // 📂 'Download/SpeechToText' qovluğu
            val downloadsDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "SpeechToText"
            )
            if (!downloadsDir.exists()) {
                downloadsDir.mkdirs() // Qovluğu yarat
            }

            val fileName = "SpeechToText_${System.currentTimeMillis()}.docx"
            val file = File(downloadsDir, fileName)

            val fos = FileOutputStream(file)
            doc.write(fos)
            fos.close()
            doc.close()

            // 📌 Fayl yadda saxlanandan sonra qovluğu açma seçimi göstər
            showFileSavedDialog(file)

        } catch (e: Exception) {
            Toast.makeText(this, "Xəta baş verdi: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    // 📌 Fayl saxlandıqdan sonra istifadəçiyə qovluğu açmaq üçün seçim təqdim edən funksiya
    private fun showFileSavedDialog(file: File) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Fayl Saxlandı")
        builder.setMessage("Fayl yadda saxlandı: ${file.absolutePath}")

        builder.setPositiveButton("Aç") { _, _ ->
            openSavedFolder()
        }

        builder.setNegativeButton("Bağla") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }

    // 📂 'SpeechToText' qovluğunu açan funksiya
    private fun openSavedFolder() {
        val folder = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            "SpeechToText"
        )
        val uri = Uri.parse(folder.absolutePath)

        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(uri, DocumentsContract.Document.MIME_TYPE_DIR)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Qovluğu açmaq mümkün olmadı!", Toast.LENGTH_SHORT).show()
        }
    }
}