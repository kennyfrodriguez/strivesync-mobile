# 📂 StriveSync - Complete Project Structure

This document provides a comprehensive visual overview of the entire project structure.

---

## 🗂️ Complete File Tree

```
mobile-test/                                   # Root project directory
│
├── 📱 app/                                    # Mobile App Module (Phone)
│   ├── src/
│   │   └── main/
│   │       ├── AndroidManifest.xml            # App configuration & permissions
│   │       ├── java/com/strivesync/health/
│   │       │   │
│   │       │   ├── 🚀 MainActivity.kt         # App entry point
│   │       │   │   └── Sets up Compose & navigation
│   │       │   │
│   │       │   ├── 📊 data/                   # Data Layer
│   │       │   │   ├── models/
│   │       │   │   │   └── HealthMetric.kt    # Health data models
│   │       │   │   │       ├── HealthMetric
│   │       │   │   │       ├── MetricType
│   │       │   │   │       ├── HealthStatus
│   │       │   │   │       ├── HealthSummary
│   │       │   │   │       ├── SymptomReport
│   │       │   │   │       ├── Medication
│   │       │   │   │       └── EmergencyContact
│   │       │   │   │
│   │       │   │   └── repository/
│   │       │   │       └── MedicationRepository.kt  # Medication management
│   │       │   │           ├── medications Flow
│   │       │   │           ├── addMedication()
│   │       │   │           ├── updateMedication()
│   │       │   │           └── deleteMedication()
│   │       │   │
│   │       │   └── 🎨 ui/                    # UI Layer
│   │       │       │
│   │       │       ├── navigation/
│   │       │       │   └── AppNavigation.kt   # Navigation setup
│   │       │       │       ├── Screen sealed class
│   │       │       │       ├── Bottom navigation
│   │       │       │       └── NavHost configuration
│   │       │       │
│   │       │       ├── screens/               # Main Screens
│   │       │       │   │
│   │       │       │   ├── 📊 DashboardScreen.kt    # Main dashboard
│   │       │       │   │   ├── Health status overview
│   │       │       │   │   ├── Emergency SOS button
│   │       │       │   │   ├── Health metrics grid
│   │       │       │   │   ├── Quick action cards
│   │       │       │   │   └── Components:
│   │       │       │   │       ├── HealthStatusCard
│   │       │       │   │       ├── HealthMetricCard
│   │       │       │   │       └── QuickActionCard
│   │       │       │   │
│   │       │       │   ├── 💓 HealthCheckScreen.kt  # Health monitoring
│   │       │       │   │   ├── Tabbed interface
│   │       │       │   │   ├── Vital signs display
│   │       │       │   │   ├── Tabs:
│   │       │       │   │   │   ├── Overview
│   │       │       │   │   │   ├── Heart Health
│   │       │       │   │   │   ├── Activity
│   │       │       │   │   │   └── Sleep
│   │       │       │   │   └── Components:
│   │       │       │   │       ├── VitalSignsCard
│   │       │       │   │       ├── VitalSignItem
│   │       │       │   │       ├── HealthReadingItem
│   │       │       │   │       ├── ActivityCard
│   │       │       │   │       └── SleepStat
│   │       │       │   │
│   │       │       │   ├── 🤖 AIAdviceScreen.kt     # AI assistant
│   │       │       │   │   ├── Chat interface
│   │       │       │   │   ├── Quick prompts
│   │       │       │   │   ├── Message input
│   │       │       │   │   ├── Data:
│   │       │       │   │   │   └── ChatMessage
│   │       │       │   │   └── Components:
│   │       │       │   │       ├── ChatMessageBubble
│   │       │       │   │       └── QuickPromptCard
│   │       │       │   │
│   │       │       │   └── 👤 ProfileScreen.kt      # User profile
│   │       │       │       ├── Profile header
│   │       │       │       ├── Health settings
│   │       │       │       ├── AI integrations
│   │       │       │       ├── App settings
│   │       │       │       └── Components:
│   │       │       │           ├── ProfileStat
│   │       │       │           └── ProfileMenuItem
│   │       │       │
│   │       │       └── theme/                 # Theming
│   │       │           │
│   │       │           ├── Color.kt           # Color palette
│   │       │           │   ├── Primary colors
│   │       │           │   ├── Health status colors
│   │       │           │   ├── Background colors
│   │       │           │   └── Text colors
│   │       │           │
│   │       │           ├── Theme.kt           # Theme setup
│   │       │           │   ├── LightColorScheme
│   │       │           │   ├── DarkColorScheme
│   │       │           │   └── StriveSyncTheme
│   │       │           │
│   │       │           └── Type.kt            # Typography
│   │       │               └── Material 3 type scale
│   │       │
│   │       └── res/                           # Resources
│   │           ├── mipmap-hdpi/
│   │           │   └── ic_launcher.xml        # App icon
│   │           └── values/
│   │               ├── colors.xml             # Color resources
│   │               ├── strings.xml            # String resources
│   │               └── themes.xml             # Theme resources
│   │
│   ├── build.gradle.kts                       # Module build config
│   │   ├── Dependencies
│   │   ├── Compose setup
│   │   ├── Health Connect
│   │   └── Charts library
│   │
│   └── proguard-rules.pro                     # ProGuard rules
│
├── ⌚ wear/                                     # Wear OS Module (Watch)
│   ├── src/
│   │   └── main/
│   │       ├── AndroidManifest.xml            # Watch configuration
│   │       ├── java/com/strivesync/health/wear/
│   │       │   │
│   │       │   ├── 🚀 MainActivity.kt         # Watch entry point
│   │       │   │
│   │       │   └── 🎨 presentation/
│   │       │       │
│   │       │       ├── WearApp.kt             # Watch navigation
│   │       │       │   └── SwipeDismissableNavHost
│   │       │       │
│   │       │       ├── components/            # Reusable Components
│   │       │       │   │
│   │       │       │   ├── MetricCard.kt      # Metric display card
│   │       │       │   │   ├── Icon
│   │       │       │   │   ├── Label
│   │       │       │   │   ├── Value
│   │       │       │   │   └── Unit
│   │       │       │   │
│   │       │       │   └── QuickActionChip.kt # Action button
│   │       │       │       ├── Label
│   │       │       │       ├── Icon
│   │       │       │       └── Background color
│   │       │       │
│   │       │       ├── screens/               # Watch Screens
│   │       │       │   │
│   │       │       │   ├── 🏠 HomeScreen.kt         # Main watch screen
│   │       │       │   │   ├── Health status badge
│   │       │       │   │   ├── Metric cards
│   │       │       │   │   ├── Quick action chips
│   │       │       │   │   └── Scrollable list
│   │       │       │   │
│   │       │       │   ├── ❤️ HeartRateScreen.kt    # Heart rate monitor
│   │       │       │   │   ├── Large BPM display
│   │       │       │   │   ├── Start/Stop button
│   │       │       │   │   ├── Real-time monitoring
│   │       │       │   │   └── Reading history
│   │       │       │   │
│   │       │       │   ├── 🏃 ActivityScreen.kt     # Activity tracking
│   │       │       │   │   ├── Step counter
│   │       │       │   │   ├── Progress bars
│   │       │       │   │   ├── Calories display
│   │       │       │   │   ├── Active minutes
│   │       │       │   │   └── Distance
│   │       │       │   │
│   │       │       │   └── 🚨 EmergencyScreen.kt    # Emergency features
│   │       │       │       ├── SOS button
│   │       │       │       ├── 5-second countdown
│   │       │       │       ├── Emergency contacts
│   │       │       │       └── Medical info
│   │       │       │
│   │       │       └── theme/                 # Watch theming
│   │       │           │
│   │       │           ├── Color.kt           # Watch colors
│   │       │           │   └── Wear OS palette
│   │       │           │
│   │       │           ├── Theme.kt           # Watch theme
│   │       │           │   └── StriveSyncWearTheme
│   │       │           │
│   │       │           └── Type.kt            # Watch typography
│   │       │               └── Wear OS type scale
│   │       │
│   │       └── res/                           # Watch resources
│   │           ├── mipmap-hdpi/
│   │           │   └── ic_launcher.xml        # Watch icon
│   │           └── values/
│   │               ├── colors.xml             # Watch colors
│   │               └── strings.xml            # Watch strings
│   │
│   ├── build.gradle.kts                       # Wear module config
│   │   ├── Wear OS dependencies
│   │   ├── Compose for Wear
│   │   ├── Health Services
│   │   └── Horologist
│   │
│   └── proguard-rules.pro                     # Wear ProGuard
│
├── 📚 Documentation/                           # Project Documentation
│   │
│   ├── README.md                              # Main documentation (500+ lines)
│   │   ├── Project overview
│   │   ├── Architecture details
│   │   ├── Setup instructions
│   │   ├── Feature descriptions
│   │   ├── API documentation
│   │   └── Contributing guide
│   │
│   ├── SETUP.md                               # Detailed setup guide
│   │   ├── Prerequisites
│   │   ├── Environment setup
│   │   ├── Emulator configuration
│   │   ├── Build instructions
│   │   └── Troubleshooting
│   │
│   ├── QUICKSTART.md                          # Quick start guide
│   │   ├── 5-minute setup
│   │   ├── Testing checklist
│   │   ├── Common issues
│   │   └── Pro tips
│   │
│   ├── PROJECT_OVERVIEW.md                    # Technical overview
│   │   ├── Architecture explanation
│   │   ├── Technology stack
│   │   ├── Design system
│   │   ├── Code structure
│   │   └── Development guide
│   │
│   ├── PROJECT_SUMMARY.md                     # Project summary
│   │   ├── What's included
│   │   ├── Statistics
│   │   ├── Features list
│   │   └── Next steps
│   │
│   └── STRUCTURE.md                           # This file
│       └── Complete file tree
│
├── ⚙️ Configuration/                           # Build Configuration
│   │
│   ├── build.gradle.kts                       # Root build script
│   │   ├── Plugin versions
│   │   ├── Kotlin version
│   │   └── Clean task
│   │
│   ├── settings.gradle.kts                    # Project settings
│   │   ├── Plugin management
│   │   ├── Repositories
│   │   └── Module includes
│   │
│   ├── gradle.properties                      # Gradle properties
│   │   ├── JVM args
│   │   ├── AndroidX flag
│   │   └── Kotlin style
│   │
│   └── .gitignore                             # Git ignore rules
│       ├── Build files
│       ├── IDE files
│       ├── Keystore files
│       └── System files
│
└── 🔧 gradle/                                  # Gradle Wrapper
    └── wrapper/
        └── gradle-wrapper.properties          # Gradle version config
```

---

## 📊 Module Breakdown

### 📱 Mobile App Module (`app/`)

| Component | Files | Purpose |
|-----------|-------|---------|
| **Entry Point** | MainActivity.kt | App initialization |
| **Data Layer** | 2 files | Models & repositories |
| **UI Layer** | 8 files | Screens, navigation, theme |
| **Resources** | 4 files | Strings, colors, icons |
| **Config** | 2 files | Build & ProGuard |
| **Total** | ~17 files | Complete mobile app |

### ⌚ Wear OS Module (`wear/`)

| Component | Files | Purpose |
|-----------|-------|---------|
| **Entry Point** | MainActivity.kt | Watch initialization |
| **Presentation** | 9 files | Screens, components, theme |
| **Resources** | 3 files | Watch strings, colors |
| **Config** | 2 files | Build & ProGuard |
| **Total** | ~15 files | Complete watch app |

---

## 🎯 Key File Locations

### Most Important Files

#### Mobile App
```
📍 Entry: app/src/main/java/.../MainActivity.kt
📍 Navigation: app/src/main/java/.../ui/navigation/AppNavigation.kt
📍 Dashboard: app/src/main/java/.../ui/screens/DashboardScreen.kt
📍 Theme: app/src/main/java/.../ui/theme/Color.kt
📍 Data: app/src/main/java/.../data/models/HealthMetric.kt
```

#### Wear OS App
```
📍 Entry: wear/src/main/java/.../MainActivity.kt
📍 Navigation: wear/src/main/java/.../presentation/WearApp.kt
📍 Home: wear/src/main/java/.../presentation/screens/HomeScreen.kt
📍 Theme: wear/src/main/java/.../presentation/theme/Color.kt
📍 Components: wear/src/main/java/.../presentation/components/
```

#### Configuration
```
📍 Root Build: build.gradle.kts
📍 Settings: settings.gradle.kts
📍 Properties: gradle.properties
📍 App Build: app/build.gradle.kts
📍 Wear Build: wear/build.gradle.kts
```

#### Documentation
```
📍 Main: README.md
📍 Setup: SETUP.md
📍 Quick: QUICKSTART.md
📍 Overview: PROJECT_OVERVIEW.md
📍 Summary: PROJECT_SUMMARY.md
```

---

## 🔗 File Dependencies

### Mobile App Flow
```
MainActivity
    ↓
StriveSyncTheme (theme setup)
    ↓
AppNavigation (navigation)
    ↓
Screens (4 screens)
    ├── DashboardScreen
    ├── HealthCheckScreen
    ├── AIAdviceScreen
    └── ProfileScreen
```

### Wear OS App Flow
```
MainActivity
    ↓
StriveSyncWearTheme (watch theme)
    ↓
WearApp (watch navigation)
    ↓
Screens (4 screens)
    ├── HomeScreen
    ├── HeartRateScreen
    ├── ActivityScreen
    └── EmergencyScreen
```

---

## 📦 Package Structure

### Mobile App Packages
```
com.strivesync.health
├── data
│   ├── models                # Data classes
│   └── repository            # Data management
└── ui
    ├── navigation            # Nav setup
    ├── screens               # UI screens
    └── theme                 # Theming
```

### Wear OS Packages
```
com.strivesync.health.wear
└── presentation
    ├── components            # Reusable widgets
    ├── screens               # Watch screens
    └── theme                 # Watch theming
```

---

## 📈 Lines of Code

| Component | Approx. Lines |
|-----------|--------------|
| **Mobile Screens** | 1,200 |
| **Wear OS Screens** | 800 |
| **Data Models** | 100 |
| **Theme Files** | 300 |
| **Navigation** | 100 |
| **Documentation** | 2,000+ |
| **Total** | ~4,500+ |

---

## 🎨 Component Hierarchy

### Mobile App Components
```
DashboardScreen
├── HealthStatusCard
│   ├── Status Badge
│   └── AI Insight
├── HealthMetricCard (x4)
│   ├── Icon
│   ├── Title
│   ├── Value
│   └── Unit
└── QuickActionCard (x3)
    ├── Gradient Background
    ├── Icon
    ├── Title
    └── Description
```

### Watch App Components
```
HomeScreen
├── Health Status Badge
├── MetricCard (x3)
│   ├── Icon (emoji)
│   ├── Label
│   ├── Value
│   └── Unit
└── QuickActionChip (x3)
    ├── Icon
    ├── Label
    └── Background
```

---

## 🔍 Finding Files Quickly

### By Feature

**Dashboard/Home**
- Mobile: `app/.../screens/DashboardScreen.kt`
- Watch: `wear/.../screens/HomeScreen.kt`

**Health Monitoring**
- Mobile: `app/.../screens/HealthCheckScreen.kt`
- Watch: `wear/.../screens/HeartRateScreen.kt`

**AI Features**
- Mobile: `app/.../screens/AIAdviceScreen.kt`
- Watch: `wear/.../screens/HomeScreen.kt` (chip)

**Emergency**
- Mobile: `app/.../screens/DashboardScreen.kt` (button)
- Watch: `wear/.../screens/EmergencyScreen.kt`

**Styling**
- Mobile: `app/.../ui/theme/`
- Watch: `wear/.../presentation/theme/`

---

## 🛠️ Modifying the Project

### To Change Colors
```
1. Mobile: app/src/main/java/.../ui/theme/Color.kt
2. Watch: wear/src/main/java/.../presentation/theme/Color.kt
3. Update color values
4. Hot reload (⚡)
```

### To Add a Screen
```
1. Create: NewScreen.kt in screens/
2. Add route in AppNavigation.kt
3. Add navigation item
4. Implement screen UI
```

### To Modify Data
```
1. Edit: data/models/HealthMetric.kt
2. Update: data/repository/
3. Modify screen displays
```

### To Change Strings
```
1. Edit: app/src/main/res/values/strings.xml
2. Use: stringResource(R.string.your_string)
```

---

## 📚 Documentation Files Explained

| File | Purpose | Lines |
|------|---------|-------|
| **README.md** | Complete guide | 500+ |
| **SETUP.md** | Setup & troubleshooting | 400+ |
| **QUICKSTART.md** | 10-minute start | 300+ |
| **PROJECT_OVERVIEW.md** | Technical details | 600+ |
| **PROJECT_SUMMARY.md** | High-level summary | 400+ |
| **STRUCTURE.md** | This file | 300+ |

---

## 🎯 Quick Navigation

### Need to...

**Build the project?**
→ See [SETUP.md](SETUP.md)

**Get started quickly?**
→ See [QUICKSTART.md](QUICKSTART.md)

**Understand architecture?**
→ See [PROJECT_OVERVIEW.md](PROJECT_OVERVIEW.md)

**See what's included?**
→ See [PROJECT_SUMMARY.md](PROJECT_SUMMARY.md)

**Read complete docs?**
→ See [README.md](README.md)

**Understand structure?**
→ You're reading it! ✨

---

## 🏆 Project Statistics

| Metric | Count |
|--------|-------|
| **Total Files** | 35+ |
| **Kotlin Files** | 20+ |
| **Documentation** | 6 files |
| **Config Files** | 9 files |
| **Modules** | 2 |
| **Screens** | 8 |
| **Components** | 15+ |
| **Packages** | 10+ |

---

## ✅ Verification Checklist

Use this to verify all files are present:

### Mobile App
- [ ] MainActivity.kt
- [ ] HealthMetric.kt
- [ ] MedicationRepository.kt
- [ ] AppNavigation.kt
- [ ] DashboardScreen.kt
- [ ] HealthCheckScreen.kt
- [ ] AIAdviceScreen.kt
- [ ] ProfileScreen.kt
- [ ] Color.kt (theme)
- [ ] Theme.kt
- [ ] Type.kt

### Wear OS App
- [ ] MainActivity.kt (wear)
- [ ] WearApp.kt
- [ ] HomeScreen.kt
- [ ] HeartRateScreen.kt
- [ ] ActivityScreen.kt
- [ ] EmergencyScreen.kt
- [ ] MetricCard.kt
- [ ] QuickActionChip.kt
- [ ] Color.kt (wear theme)
- [ ] Theme.kt (wear)
- [ ] Type.kt (wear)

### Configuration
- [ ] build.gradle.kts (root)
- [ ] build.gradle.kts (app)
- [ ] build.gradle.kts (wear)
- [ ] settings.gradle.kts
- [ ] gradle.properties
- [ ] .gitignore

### Documentation
- [ ] README.md
- [ ] SETUP.md
- [ ] QUICKSTART.md
- [ ] PROJECT_OVERVIEW.md
- [ ] PROJECT_SUMMARY.md
- [ ] STRUCTURE.md

---

<div align="center">

## 🎉 Complete Project Structure

**All 35+ files organized and ready to go!**

---

**[Back to Main Docs](README.md)** | **[Quick Start](QUICKSTART.md)** | **[Setup Guide](SETUP.md)**

</div>

