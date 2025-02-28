
🎙️ Speech to Text – Convert Voice to Text Easily

📢 Speech to Text is a powerful Android application that allows users to convert spoken words into text, edit, and save as a .docx file. This app is designed for professionals, students, and anyone who needs a fast and accurate voice-to-text solution.

📌 Features
✔️ Speech Recognition – Convert speech into text using Google Speech API
✔️ Save to Word File – Export transcribed text as a .docx document
✔️ Editable Text Field – Append new speech-to-text results to previous text
✔️ Quick File Access – Open saved documents directly from the app
✔️ User Confirmation – Edit and verify text before saving
✔️ Multi-Language Support – Works with different languages
✔️ Minimal UI – User-friendly Material Design interface
✔️ About & Support Sections – Learn more about the app and get assistance

🖥️ Installation
🔹 Using Android Studio (For Developers)
Clone this repository:
sh
Copy
Edit
git clone https://github.com/your-repo-name.git
cd speech-to-text-app
Open the project in Android Studio.
Build and run the project using an emulator or a physical device.
🔹 Installing APK (For Users)
Download the latest SpeechToText.apk file from the releases section.
Enable Install from Unknown Sources in device settings.
Install the APK and start using the app.
🎤 How to Use
1️⃣ Convert Speech to Text
📢 Tap the "Start Speaking" button
🎙️ Speak clearly into the microphone
📝 Text appears on the screen
✅ Confirm or Edit before saving

2️⃣ Save Text as a Word Document
💾 Tap the "Save to Word" button
📁 The .docx file is saved in Downloads/SpeechToText

3️⃣ Open Saved Files
📂 After saving, a dialog allows quick access to the saved file
📍 Navigate to the SpeechToText folder manually

## 📸 Screenshots

### 🏠 Main Screen  
![Main Screen](IMG_20250228_170607.jpg)

### 🎤 Speech to Text in Action  
![Speech to Text](IMG_20250228_170432.jpg)

### 💾 Save as Word File  
![Save File](IMG_20250228_170413.jpg)


📂 Project Structure
bash
Copy
Edit
📦 speech-to-text-app
 ┣ 📂 app/src/main/java/com/example/speechtotext/
 ┃ ┣ 📜 MainActivity.kt          # Main screen handling speech recognition
 ┃ ┣ 📜 InfoActivity.kt          # About & Support page with tab layout
 ┃ ┣ 📜 AboutFragment.kt         # Fragment for "About" section
 ┃ ┣ 📜 SupportFragment.kt       # Fragment for "Support" section
 ┃ ┣ 📜 SectionsPagerAdapter.kt  # Adapter for tab navigation
 ┃
 ┣ 📂 app/src/main/res/layout/
 ┃ ┣ 📜 activity_main.xml        # Main UI layout
 ┃ ┣ 📜 activity_info.xml        # Layout for about/support page
 ┃ ┣ 📜 fragment_about.xml       # UI for about section
 ┃ ┣ 📜 fragment_support.xml     # UI for support section
 ┃
 ┣ 📜 AndroidManifest.xml        # App permissions and declarations
🔒 Permissions Required
Permission	Purpose
🎤 Microphone Access	To capture speech input
🌐 Internet Access	To use Google Speech Recognition API
📁 Storage Access	To save .docx files on the device
❓ Troubleshooting
🚨 "Speech recognition not available"
➡️ Ensure you have Google Speech-to-Text enabled on your device

🚨 "Cannot create keystore" error
➡️ Check write permissions for the keystore path

🚨 App crashes on file save
➡️ Ensure storage permissions are granted in settings

🚀 Contributing
Fork the repository
Create a new branch:
sh
Copy
Edit
git checkout -b feature-name
Commit your changes:
sh
Copy
Edit
git commit -m "Added new feature"
Push to your branch:
sh
Copy
Edit
git push origin feature-name
Submit a Pull Request
📜 License
This project is licensed under the MIT License – see the LICENSE file for details.

📞 Contact & Support
📧 Email: rizvan.davudov@yahoo.com
📧 Email: davudovrizvan55@gmail.com
🌍 Website: https://www.linkedin.com/in/rizvan-davudov-8b995b325/


📢 Transform your speech into text effortlessly with Speech to Text! 🎙️📄✨

🔥 Made with ❤️ for speech-to-text users worldwide 🌍
