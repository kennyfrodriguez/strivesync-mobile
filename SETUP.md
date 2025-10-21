# StriveSync - Setup Guide

This guide will help you set up the StriveSync Android mobile and watch apps on your development machine.

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Environment Setup](#environment-setup)
3. [Project Setup](#project-setup)
4. [Running the Apps](#running-the-apps)
5. [Troubleshooting](#troubleshooting)

---

## Prerequisites

### Required Software

1. **Android Studio Electric Eel or newer**
   - Download from: https://developer.android.com/studio
   - Recommended: Latest stable version (Hedgehog or newer)

2. **Java Development Kit (JDK)**
   - JDK 11 or higher (JDK 17 recommended)
   - Usually bundled with Android Studio
   - Verify: `java -version`

3. **Android SDK**
   - Minimum: API 26 (Android 8.0)
   - Target: API 34 (Android 14)
   - Installed through Android Studio SDK Manager

4. **Wear OS SDK**
   - Minimum: API 30 (Wear OS 3.0)
   - Installed through Android Studio SDK Manager

### System Requirements

- **OS**: Windows 10/11, macOS 10.14+, or Linux
- **RAM**: 8 GB minimum (16 GB recommended)
- **Disk Space**: 8 GB minimum free space
- **Display**: 1280x800 minimum resolution

---

## Environment Setup

### 1. Install Android Studio

1. Download Android Studio from the official website
2. Run the installer and follow the setup wizard
3. Choose "Standard" installation type
4. Install Android SDK, platform tools, and emulator

### 2. Install Required SDK Components

Open Android Studio → Tools → SDK Manager

#### SDK Platforms Tab
Install the following:
- ✅ Android 14.0 (API 34)
- ✅ Android 13.0 (API 33)
- ✅ Android 11.0 (API 30) - for Wear OS
- ✅ Android 8.0 (API 26) - minimum supported

#### SDK Tools Tab
Ensure these are installed:
- ✅ Android SDK Build-Tools
- ✅ Android Emulator
- ✅ Android SDK Platform-Tools
- ✅ Android SDK Tools
- ✅ Google Play services
- ✅ Intel x86 Emulator Accelerator (HAXM) - for Windows/Mac

### 3. Configure Emulators

#### Mobile Emulator Setup

1. Tools → Device Manager → Create Device
2. Select Hardware:
   - Choose: **Pixel 7** or **Pixel 7 Pro**
   - Click "Next"
3. Select System Image:
   - Select **API Level 34** (Android 14)
   - Download if needed
   - Click "Next"
4. Verify Configuration:
   - Name: `Pixel_7_API_34`
   - Startup orientation: Portrait
   - Click "Finish"

#### Wear OS Emulator Setup

1. Tools → Device Manager → Create Device
2. Click **Wear OS** tab
3. Select Hardware:
   - Choose: **Wear OS Large Round**
   - Click "Next"
4. Select System Image:
   - Select **API Level 33** (Wear OS 4)
   - Download if needed
   - Click "Next"
5. Verify Configuration:
   - Name: `Wear_OS_Large_Round_API_33`
   - Click "Finish"

---

## Project Setup

### 1. Clone the Repository

```bash
# Using HTTPS
git clone <repository-url>
cd mobile-test

# Or if you have the zip file
unzip mobile-test.zip
cd mobile-test
```

### 2. Open Project in Android Studio

1. Launch Android Studio
2. Click **"Open"** on welcome screen
3. Navigate to the `mobile-test` directory
4. Click **"OK"**

### 3. Wait for Gradle Sync

The project will automatically:
- Download dependencies
- Configure build tools
- Index project files

This may take 5-10 minutes on first run.

#### If Gradle Sync Fails:

1. Click **"Try Again"** in the error notification
2. Or manually sync: File → Sync Project with Gradle Files
3. Check [Troubleshooting](#troubleshooting) section if issues persist

### 4. Verify Project Structure

Ensure you see these modules in Project view:
- **mobile-test** (root)
  - **app** (mobile module)
  - **wear** (Wear OS module)
  - **Gradle Scripts**

---

## Running the Apps

### Running the Mobile App

#### Option 1: Using Android Studio

1. Select **"app"** from run configuration dropdown (top toolbar)
2. Select your target device/emulator
3. Click the green **Run** button (▶️)
4. Wait for app to install and launch

#### Option 2: Using Command Line

```bash
# Install debug version
./gradlew :app:installDebug

# On Windows
gradlew.bat :app:installDebug

# Launch the app manually on device
adb shell am start -n com.strivesync.health/.MainActivity
```

### Running the Wear OS App

#### Option 1: Using Android Studio

1. Select **"wear"** from run configuration dropdown
2. Select your Wear OS emulator
3. Click the green **Run** button (▶️)
4. Wait for app to install and launch

#### Option 2: Using Command Line

```bash
# Install debug version
./gradlew :wear:installDebug

# On Windows
gradlew.bat :wear:installDebug

# Launch the app manually on watch
adb shell am start -n com.strivesync.health.wear/.MainActivity
```

### Running Both Apps Simultaneously

1. Start the Wear OS emulator first
2. Run the wear app
3. Start the mobile emulator
4. Run the mobile app
5. Both apps will run independently

---

## Troubleshooting

### Common Issues and Solutions

#### 1. Gradle Sync Failed

**Error**: "Gradle sync failed: Could not resolve all dependencies"

**Solutions**:
```bash
# Clear Gradle cache
rm -rf ~/.gradle/caches/
# Or on Windows: rmdir /s /q %USERPROFILE%\.gradle\caches

# In Android Studio:
# File → Invalidate Caches → Invalidate and Restart
```

#### 2. SDK Not Found

**Error**: "SDK location not found"

**Solution**:
Create `local.properties` file in project root:
```properties
sdk.dir=/path/to/Android/Sdk

# Example Windows:
# sdk.dir=C\:\\Users\\YourName\\AppData\\Local\\Android\\Sdk

# Example macOS:
# sdk.dir=/Users/YourName/Library/Android/sdk

# Example Linux:
# sdk.dir=/home/YourName/Android/Sdk
```

#### 3. Emulator Won't Start

**Error**: Emulator fails to launch

**Solutions**:
- Enable Virtualization in BIOS (VT-x/AMD-V)
- On Windows: Enable Hyper-V or WHPX
- On Mac: No additional setup needed
- On Linux: Install KVM

Check virtualization:
```bash
# Linux
egrep -c '(vmx|svm)' /proc/cpuinfo
# Should return > 0

# Mac
sysctl kern.hv_support
# Should return 1
```

#### 4. Out of Memory During Build

**Error**: "Expiring Daemon because JVM heap space is exhausted"

**Solution**:
Edit `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx4096m -XX:MaxPermSize=1024m -XX:+HeapDumpOnOutOfMemoryError
```

#### 5. Dependency Resolution Failed

**Error**: "Could not resolve com.google.android.xxx"

**Solution**:
Check your `settings.gradle.kts` has correct repositories:
```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
```

#### 6. App Not Installing

**Error**: "Installation failed with message Invalid File"

**Solutions**:
```bash
# Uninstall existing app
adb uninstall com.strivesync.health
adb uninstall com.strivesync.health.wear

# Clear app data
adb shell pm clear com.strivesync.health

# Restart ADB
adb kill-server
adb start-server
```

#### 7. Wear OS Emulator Not Found

**Error**: "No Wear OS emulator available"

**Solution**:
1. Tools → SDK Manager → SDK Tools
2. Install "Wear OS Emulator"
3. Create Wear OS AVD (see setup instructions above)

#### 8. Build Fails with "Duplicate Class"

**Error**: "Duplicate class ... found in modules"

**Solution**:
Clean and rebuild:
```bash
./gradlew clean
./gradlew build

# Or in Android Studio:
# Build → Clean Project
# Build → Rebuild Project
```

---

## Testing the Apps

### Mobile App Features to Test

1. **Dashboard**
   - ✅ View health status card
   - ✅ Check health metrics (heart rate, steps, etc.)
   - ✅ Click quick action cards
   - ✅ Press Emergency SOS button

2. **Health Check**
   - ✅ Switch between tabs
   - ✅ View vital signs
   - ✅ Check activity metrics
   - ✅ View sleep data

3. **AI Advice**
   - ✅ Send messages to AI
   - ✅ Try quick prompts
   - ✅ View chat history

4. **Profile**
   - ✅ View profile information
   - ✅ Navigate through settings
   - ✅ Check medication list

### Wear OS App Features to Test

1. **Home Screen**
   - ✅ Scroll through metrics
   - ✅ View health status
   - ✅ Click quick action chips

2. **Heart Rate**
   - ✅ Start/stop monitoring
   - ✅ View current BPM
   - ✅ Check reading history

3. **Activity**
   - ✅ View step count
   - ✅ Check progress bars
   - ✅ View other metrics

4. **Emergency**
   - ✅ Test countdown (cancel before calling!)
   - ✅ View emergency contacts
   - ✅ Check medical info

---

## Development Tips

### Hot Reload

Compose supports hot reload for UI changes:
1. Make UI changes in Compose code
2. Click **"Apply Changes"** (⚡) or `Ctrl+F10` / `Cmd+F10`
3. Changes appear instantly without reinstalling

### Debugging

```kotlin
// Add log statements
import android.util.Log

Log.d("StriveSync", "Debug message")
Log.e("StriveSync", "Error message")
```

View logs:
- Android Studio → Logcat
- Filter by "StriveSync" tag

### Code Inspection

Run code analysis:
- Analyze → Inspect Code
- Review warnings and errors
- Fix issues automatically when possible

---

## Next Steps

After successful setup:

1. **Explore the Code**
   - Read through screen implementations
   - Study the data models
   - Review the navigation structure

2. **Customize the App**
   - Change colors in `theme/Color.kt`
   - Modify strings in `res/values/strings.xml`
   - Add new features to existing screens

3. **Add Real Functionality**
   - Integrate actual AI services
   - Connect to backend API
   - Implement real health data tracking

4. **Test Thoroughly**
   - Write unit tests
   - Add integration tests
   - Test on real devices

---

## Additional Resources

- [Android Studio User Guide](https://developer.android.com/studio/intro)
- [Jetpack Compose Tutorial](https://developer.android.com/jetpack/compose/tutorial)
- [Wear OS Development Guide](https://developer.android.com/training/wearables)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Material Design 3](https://m3.material.io/)

---

## Getting Help

If you encounter issues not covered here:

1. Check Android Studio error messages carefully
2. Review Gradle build logs (Build → Build Output)
3. Search Android Developer documentation
4. Check Stack Overflow for similar issues
5. Review the project's README.md

---

**Happy Coding! 🚀**

