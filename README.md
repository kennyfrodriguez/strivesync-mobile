# StriveSync Health App - Android Mobile & Watch

<div align="center">

![StriveSync Logo](https://img.shields.io/badge/StriveSync-Health%20Companion-4F46E5?style=for-the-badge&logo=android&logoColor=white)

**Your Personal AI Health Companion for Android & Wear OS**

[![Android](https://img.shields.io/badge/Android-26+-3DDC84?style=flat-square&logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-7F52FF?style=flat-square&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2023.10.01-4285F4?style=flat-square&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Wear OS](https://img.shields.io/badge/Wear%20OS-3.0+-00C853?style=flat-square&logo=wear-os&logoColor=white)](https://wearos.google.com)

</div>

---

## 📱 Overview

StriveSync is a comprehensive health monitoring and AI-powered medical advice application for Android smartphones and Wear OS smartwatches. Get personalized medical guidance, monitor your health metrics, and access reliable medical information with our advanced AI assistant.

### ✨ Key Features

- 🤖 **AI Health Assistant** - Get instant, personalized medical guidance powered by advanced AI
- 💓 **Health Monitoring** - Track heart rate, steps, sleep, calories, and more
- ⌚ **Wear OS Integration** - Real-time vitals monitoring on your smartwatch
- 🚨 **Emergency SOS** - Quick access to emergency services with one tap
- 💊 **Medication Reminders** - Never miss a dose with smart notifications
- 🔒 **Secure & Private** - HIPAA compliant with enterprise-grade encryption
- 📊 **Health Analytics** - Beautiful charts and insights into your health trends
- 👨‍👩‍👧‍👦 **Family Care** - Manage health information for your entire family

---

## 🏗️ Architecture

### Project Structure

```
mobile-test/
├── app/                                    # Mobile app module (Phone)
│   ├── src/main/
│   │   ├── java/com/strivesync/health/
│   │   │   ├── MainActivity.kt            # Main entry point
│   │   │   ├── data/
│   │   │   │   ├── models/                # Data models
│   │   │   │   │   └── HealthMetric.kt
│   │   │   │   └── repository/            # Data repositories
│   │   │   │       └── MedicationRepository.kt
│   │   │   └── ui/
│   │   │       ├── navigation/            # Navigation setup
│   │   │       │   └── AppNavigation.kt
│   │   │       ├── screens/               # Main screens
│   │   │       │   ├── DashboardScreen.kt
│   │   │       │   ├── HealthCheckScreen.kt
│   │   │       │   ├── AIAdviceScreen.kt
│   │   │       │   └── ProfileScreen.kt
│   │   │       └── theme/                 # App theming
│   │   │           ├── Color.kt
│   │   │           ├── Theme.kt
│   │   │           └── Type.kt
│   │   ├── res/                           # Resources
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml
│   │   │   │   └── themes.xml
│   │   │   └── mipmap-*/                  # App icons
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts                   # App module build config
│
├── wear/                                   # Wear OS module (Watch)
│   ├── src/main/
│   │   ├── java/com/strivesync/health/wear/
│   │   │   ├── MainActivity.kt            # Watch main entry
│   │   │   └── presentation/
│   │   │       ├── WearApp.kt             # Watch navigation
│   │   │       ├── components/            # Reusable components
│   │   │       │   ├── MetricCard.kt
│   │   │       │   └── QuickActionChip.kt
│   │   │       ├── screens/               # Watch screens
│   │   │       │   ├── HomeScreen.kt
│   │   │       │   ├── HeartRateScreen.kt
│   │   │       │   ├── ActivityScreen.kt
│   │   │       │   └── EmergencyScreen.kt
│   │   │       └── theme/                 # Watch theming
│   │   │           ├── Color.kt
│   │   │           ├── Theme.kt
│   │   │           └── Type.kt
│   │   ├── res/                           # Watch resources
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts                   # Wear module build config
│
├── build.gradle.kts                       # Root build config
├── settings.gradle.kts                    # Project settings
├── gradle.properties                      # Gradle properties
└── README.md                              # This file
```

### Technology Stack

#### Mobile App
- **Language**: Kotlin 1.9.20
- **UI Framework**: Jetpack Compose with Material 3
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: Jetpack Navigation Compose
- **Async**: Kotlin Coroutines & Flow
- **Health Data**: Health Connect API
- **Charts**: Vico Charts Library

#### Wear OS App
- **Language**: Kotlin 1.9.20
- **UI Framework**: Compose for Wear OS
- **Health**: Health Services API
- **Layout**: Horologist (Wear OS utilities)
- **Navigation**: Wear Navigation Compose

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio**: Electric Eel (2022.1.1) or newer
- **JDK**: Java 8 or higher
- **Android SDK**: API 26+ (Android 8.0) for mobile
- **Wear OS SDK**: API 30+ (Wear OS 3.0) for watch
- **Gradle**: 8.2 or higher (included via wrapper)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd mobile-test
   ```

2. **Open in Android Studio**
   - File → Open → Select `mobile-test` directory
   - Wait for Gradle sync to complete

3. **Build the project**
   ```bash
   ./gradlew build
   ```

4. **Run on device/emulator**

   **For Mobile App:**
   ```bash
   ./gradlew :app:installDebug
   ```

   **For Wear OS App:**
   ```bash
   ./gradlew :wear:installDebug
   ```

   Or use Android Studio's Run button (▶️) and select your target device.

### Setting Up Emulators

#### Mobile Emulator
1. Tools → Device Manager → Create Device
2. Select a phone (e.g., Pixel 7)
3. Choose system image: API 34 (Android 14)
4. Finish setup

#### Wear OS Emulator
1. Tools → Device Manager → Create Device
2. Select Wear OS tab
3. Choose a watch (e.g., Wear OS Large Round)
4. Choose system image: API 33 (Wear OS 4)
5. Finish setup

---

## 📱 Mobile App Features

### 1. Dashboard
- **Health Status Overview** - See your overall health status at a glance
- **Today's Metrics** - Heart rate, steps, sleep, calories displayed in beautiful cards
- **Quick Actions** - Fast access to AI consultation, symptom checker, medications
- **Emergency SOS** - One-tap emergency call button

### 2. Health Check
- **Vital Signs Monitoring** - Real-time tracking of heart rate, SpO2, temperature, blood pressure
- **Health Tabs** - Overview, Heart Health, Activity, Sleep with detailed analytics
- **Reading History** - View your health metrics over time
- **Trend Analysis** - Visual charts showing health trends

### 3. AI Advice
- **Chat Interface** - Natural conversation with AI health assistant
- **Quick Prompts** - Pre-built questions for common health concerns
- **Symptom Checker** - Describe symptoms and get AI-powered analysis
- **Medication Information** - Ask about any medication
- **Exercise & Nutrition** - Get personalized advice

### 4. Profile
- **Personal Information** - Age, height, weight, health stats
- **Medication Management** - Add, edit, and track your medications
- **Emergency Contacts** - Save important contact information
- **Health Goals** - Set and track fitness goals
- **AI Integrations** - Import tokens from OpenAI, Claude, etc.
- **Privacy & Security** - HIPAA compliant settings
- **App Settings** - Notifications, theme, data sync

---

## ⌚ Wear OS App Features

### 1. Home Screen
- **Health Status Badge** - Quick view of overall health
- **Metric Cards** - Heart rate, steps, calories at a glance
- **Quick Actions** - Emergency SOS, AI Advice, Medications
- **Scrollable List** - Easy navigation with rotary input support

### 2. Heart Rate Monitor
- **Real-time BPM** - Live heart rate display with large numbers
- **Start/Stop Monitoring** - Control heart rate sensor
- **Recent Readings** - History of past measurements
- **Status Indicators** - Color-coded health status

### 3. Activity Tracker
- **Step Counter** - Daily steps with progress bar
- **Goal Tracking** - Visual progress toward daily goals
- **Additional Metrics** - Calories, active minutes, distance
- **Progress Indicators** - See completion percentage

### 4. Emergency Screen
- **Emergency SOS** - 5-second countdown to call 911
- **Emergency Contacts** - Quick dial to saved contacts
- **Medical Information** - Blood type, allergies, medications
- **Cancel Option** - Stop emergency call if triggered accidentally

---

## 🎨 Design System

### Color Palette

```kotlin
// Primary Colors
PrimaryBlue = #4F46E5
PrimaryBlueLight = #818CF8
SecondaryTeal = #06B6D4
AccentPurple = #8B5CF6

// Health Status Colors
HealthExcellent = #10B981  // Green
HealthGood = #3B82F6       // Blue
HealthWarning = #F59E0B    // Orange
HealthDanger = #EF4444     // Red

// Backgrounds
BackgroundLight = #F8FAFC
BackgroundDark = #0F172A
```

### Typography

- **Display**: Bold, 36-57sp - Hero sections
- **Headline**: SemiBold, 24-32sp - Section titles
- **Title**: SemiBold, 16-22sp - Card titles
- **Body**: Normal, 12-16sp - Main content
- **Label**: Medium, 11-14sp - Labels and buttons

### Components

- **Cards**: Rounded corners (16-20dp), subtle elevation
- **Buttons**: Rounded (12-16dp), bold text
- **Chips**: Fully rounded, icon + text
- **Progress Bars**: 4-8dp height, rounded corners

---

## 🔐 Permissions

### Mobile App Permissions

```xml
<!-- Required -->
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.BODY_SENSORS" />
<uses-permission android:name="android.permission.ACTIVITY_RECOGNITION" />

<!-- Health Connect -->
<uses-permission android:name="android.permission.health.READ_HEART_RATE" />
<uses-permission android:name="android.permission.health.READ_STEPS" />
<uses-permission android:name="android.permission.health.READ_SLEEP" />

<!-- Emergency Features -->
<uses-permission android:name="android.permission.CALL_PHONE" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

### Wear OS Permissions

```xml
<!-- Required -->
<uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="android.permission.BODY_SENSORS" />
<uses-permission android:name="android.permission.ACTIVITY_RECOGNITION" />

<!-- Health Services -->
<uses-permission android:name="android.permission.health.READ_HEART_RATE" />
<uses-permission android:name="android.permission.health.READ_STEPS" />
```

---

## 🧪 Testing

### Run Unit Tests

```bash
# Mobile app tests
./gradlew :app:testDebugUnitTest

# Wear OS tests
./gradlew :wear:testDebugUnitTest
```

### Run Instrumented Tests

```bash
# Mobile app
./gradlew :app:connectedDebugAndroidTest

# Wear OS
./gradlew :wear:connectedDebugAndroidTest
```

---

## 📦 Building Release APKs

### Mobile App

```bash
./gradlew :app:assembleRelease
```

APK location: `app/build/outputs/apk/release/app-release.apk`

### Wear OS App

```bash
./gradlew :wear:assembleRelease
```

APK location: `wear/build/outputs/apk/release/wear-release.apk`

### Signing Configuration

For production builds, add signing configuration to `app/build.gradle.kts`:

```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("path/to/keystore.jks")
            storePassword = "your-store-password"
            keyAlias = "your-key-alias"
            keyPassword = "your-key-password"
        }
    }
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
        }
    }
}
```

---

## 🔧 Configuration

### Gradle Properties

Edit `gradle.properties` to configure build settings:

```properties
org.gradle.jvmargs=-Xmx2048m
android.useAndroidX=true
android.enableJetifier=true
kotlin.code.style=official
```

### Min SDK Versions

- **Mobile**: API 26 (Android 8.0 Oreo) and above
- **Wear OS**: API 30 (Wear OS 3.0) and above

### Compile SDK

- **Current**: API 34 (Android 14)

---

## 🚀 Features Roadmap

### Implemented ✅
- [x] Modern Material 3 UI for mobile
- [x] Wear OS optimized interface
- [x] Health metrics dashboard
- [x] Heart rate monitoring
- [x] Activity tracking (steps, calories)
- [x] AI chat interface
- [x] Emergency SOS functionality
- [x] Medication management
- [x] Profile management
- [x] Beautiful charts and visualizations

### Planned 🔮
- [ ] Real Health Connect integration
- [ ] Backend API integration
- [ ] Actual AI model integration (OpenAI, Claude)
- [ ] Push notifications for medication reminders
- [ ] Cloud data sync across devices
- [ ] Family account sharing
- [ ] Advanced analytics and reports
- [ ] Watch face complications
- [ ] Continuous heart rate monitoring
- [ ] Sleep tracking integration
- [ ] Export health data (PDF, CSV)

---

## 📚 Resources

### Official Documentation
- [Android Developers](https://developer.android.com)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Wear OS Development](https://developer.android.com/training/wearables)
- [Health Connect](https://developer.android.com/health-and-fitness/guides/health-connect)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)

### Libraries Used
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern UI toolkit
- [Compose for Wear OS](https://developer.android.com/training/wearables/compose) - Watch UI
- [Health Services](https://developer.android.com/training/wearables/health-services) - Wear health
- [Vico Charts](https://github.com/patrykandpatrick/vico) - Beautiful charts
- [Horologist](https://google.github.io/horologist/) - Wear OS utilities
- [Accompanist](https://google.github.io/accompanist/) - Compose utilities

---

## 🤝 Contributing

This is a demo/test application. For production use:

1. Implement real backend API
2. Add proper authentication
3. Integrate with actual AI services
4. Implement Health Connect properly
5. Add comprehensive error handling
6. Write unit and integration tests
7. Add proper logging and analytics

---

## ⚖️ Legal & Compliance

### Medical Disclaimer

**⚠️ IMPORTANT**: This is a demonstration application for educational purposes only. It is NOT intended for actual medical diagnosis or treatment. Always consult with qualified healthcare professionals for medical advice.

### HIPAA Compliance

For production use, ensure:
- End-to-end encryption of health data
- Secure authentication (OAuth 2.0, biometric)
- Audit logging of all health data access
- Business Associate Agreements (BAAs)
- Regular security audits
- Data retention and deletion policies

### Privacy

- All health data should be encrypted at rest and in transit
- Users must provide explicit consent for data collection
- Implement proper data anonymization
- Provide data export and deletion options
- Follow GDPR, CCPA, and local privacy laws

---

## 📄 License

This project is a demo application based on the StriveSync website design.

For production use, ensure you have:
- Proper medical app certifications (FDA if applicable)
- Privacy policy and terms of service
- Appropriate licenses for all dependencies
- Medical professional validation of AI responses

---

## 📞 Support

For questions or issues with this test application:

- Review the code documentation
- Check Android Studio build logs
- Verify all dependencies are properly synced
- Ensure emulators/devices meet minimum requirements

---

## 🎯 Quick Start Checklist

- [ ] Clone repository
- [ ] Open in Android Studio
- [ ] Sync Gradle files
- [ ] Create mobile emulator (API 34+)
- [ ] Create Wear OS emulator (API 30+)
- [ ] Build project
- [ ] Run mobile app
- [ ] Run Wear OS app
- [ ] Explore features
- [ ] Review code structure

---

<div align="center">

**Built with ❤️ using Kotlin & Jetpack Compose**

[Android](https://www.android.com) • [Kotlin](https://kotlinlang.org) • [Jetpack Compose](https://developer.android.com/jetpack/compose)

</div>

