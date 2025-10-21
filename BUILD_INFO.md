# 🔨 Build Information

## Project Build Details

### Version Information
- **Project Name**: StriveSync Health App
- **Version**: 1.0.0 (versionCode 1)
- **Package**: com.strivesync.health
- **Wear Package**: com.strivesync.health.wear

### Build Requirements
- **Gradle**: 8.2+
- **Android Gradle Plugin**: 8.2.0
- **Kotlin**: 1.9.20
- **Compile SDK**: 34 (Android 14)
- **Min SDK Mobile**: 26 (Android 8.0)
- **Min SDK Wear**: 30 (Wear OS 3.0)
- **Target SDK**: 34

---

## Quick Build Commands

### Clean Build
```bash
./gradlew clean
./gradlew build
```

### Build Mobile App
```bash
./gradlew :app:assembleDebug
```

### Build Wear OS App
```bash
./gradlew :wear:assembleDebug
```

### Install on Device
```bash
# Mobile
./gradlew :app:installDebug

# Wear OS
./gradlew :wear:installDebug
```

### Build Release
```bash
# Mobile (unsigned)
./gradlew :app:assembleRelease

# Wear OS (unsigned)
./gradlew :wear:assembleRelease
```

---

## Build Outputs

### Debug APKs
```
Mobile:  app/build/outputs/apk/debug/app-debug.apk
Wear:    wear/build/outputs/apk/debug/wear-debug.apk
```

### Release APKs
```
Mobile:  app/build/outputs/apk/release/app-release.apk
Wear:    wear/build/outputs/apk/release/wear-release.apk
```

---

## Dependencies Summary

### Mobile App Dependencies
```
Core:
- androidx.core:core-ktx:1.12.0
- androidx.lifecycle:lifecycle-runtime-ktx:2.6.2
- androidx.activity:activity-compose:1.8.1

Compose:
- androidx.compose:compose-bom:2023.10.01
- androidx.compose.material3:material3
- androidx.compose.material:material-icons-extended

Navigation:
- androidx.navigation:navigation-compose:2.7.5

Health:
- androidx.health.connect:connect-client:1.1.0-alpha07

Charts:
- com.patrykandpatrick.vico:compose:1.13.1
- com.patrykandpatrick.vico:compose-m3:1.13.1

Utilities:
- com.google.accompanist:accompanist-permissions:0.32.0
```

### Wear OS Dependencies
```
Wear:
- androidx.wear:wear:1.3.0

Compose:
- androidx.wear.compose:compose-material:1.2.1
- androidx.wear.compose:compose-foundation:1.2.1
- androidx.wear.compose:compose-navigation:1.2.1

Health:
- androidx.health:health-services-client:1.0.0-rc02

Horologist:
- com.google.android.horologist:horologist-compose-layout:0.5.11
- com.google.android.horologist:horologist-compose-material:0.5.11
```

---

## Build Time Estimates

| Task | First Build | Subsequent |
|------|-------------|------------|
| Gradle Sync | 3-5 min | 10-30 sec |
| Clean Build | 2-3 min | 1-2 min |
| Incremental Build | N/A | 10-30 sec |
| Install APK | 30 sec | 20 sec |

---

## Troubleshooting Build Issues

### Issue: Gradle Sync Failed
```bash
# Solution 1: Clean and retry
./gradlew clean
./gradlew build --refresh-dependencies

# Solution 2: Clear Gradle cache
rm -rf ~/.gradle/caches/
./gradlew clean build
```

### Issue: Out of Memory
```bash
# Edit gradle.properties
org.gradle.jvmargs=-Xmx4096m -XX:MaxPermSize=1024m
```

### Issue: Dependency Resolution Failed
```bash
# Clear build directories
rm -rf app/build wear/build build
./gradlew clean build
```

### Issue: Compilation Failed
```bash
# Check Kotlin version compatibility
# Ensure all dependencies use compatible versions
./gradlew dependencies
```

---

## CI/CD Configuration

### GitHub Actions Example
```yaml
name: Android CI

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
    
    - name: Grant execute permission for gradlew
      run: chmod +x gradlew
    
    - name: Build with Gradle
      run: ./gradlew build
    
    - name: Run tests
      run: ./gradlew test
    
    - name: Build APKs
      run: |
        ./gradlew :app:assembleDebug
        ./gradlew :wear:assembleDebug
    
    - name: Upload APKs
      uses: actions/upload-artifact@v3
      with:
        name: apks
        path: |
          app/build/outputs/apk/debug/
          wear/build/outputs/apk/debug/
```

---

## Signing Configuration (Production)

### Generate Keystore
```bash
keytool -genkey -v -keystore strivesync.jks \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias strivesync
```

### Configure Signing (app/build.gradle.kts)
```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("../strivesync.jks")
            storePassword = System.getenv("KEYSTORE_PASSWORD")
            keyAlias = "strivesync"
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }
    
    buildTypes {
        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
```

---

## Performance Optimization

### Build Performance
```properties
# gradle.properties
org.gradle.caching=true
org.gradle.parallel=true
org.gradle.configureondemand=true
android.enableJetifier=true
android.useAndroidX=true
```

### APK Size Optimization
```kotlin
android {
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
    
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
```

---

## Build Variants

### Debug Build
- **Purpose**: Development and testing
- **Features**: Debug symbols, logging enabled
- **Size**: Larger due to debug info
- **Performance**: Not optimized

### Release Build
- **Purpose**: Production deployment
- **Features**: Optimized, minified
- **Size**: Smaller (ProGuard/R8)
- **Performance**: Optimized

---

## Module Structure

```
Root Project (mobile-test)
├── app (Mobile App Module)
│   ├── Debug APK: ~15-20 MB
│   └── Release APK: ~8-12 MB
│
└── wear (Wear OS Module)
    ├── Debug APK: ~5-8 MB
    └── Release APK: ~3-5 MB
```

---

## Build Verification Checklist

Before committing:
- [ ] `./gradlew clean` succeeds
- [ ] `./gradlew build` succeeds
- [ ] No compiler warnings (critical)
- [ ] No lint errors (critical)
- [ ] Both APKs install successfully
- [ ] Both apps launch without crash
- [ ] All screens navigate properly
- [ ] No runtime exceptions in logs

---

## Useful Gradle Tasks

```bash
# List all tasks
./gradlew tasks

# Check dependencies
./gradlew :app:dependencies
./gradlew :wear:dependencies

# Run lint
./gradlew :app:lint
./gradlew :wear:lint

# Generate reports
./gradlew :app:dependencyInsight --dependency [dep-name]

# Analyze APK size
./gradlew :app:assembleRelease --scan
```

---

## Build Flags

### Debug Build
```bash
./gradlew :app:assembleDebug \
  --info \              # Info logging
  --stacktrace \        # Full stack traces
  --scan               # Build scan
```

### Release Build
```bash
./gradlew :app:assembleRelease \
  --no-daemon \         # No Gradle daemon
  --max-workers=4 \     # Parallel workers
  --build-cache        # Use build cache
```

---

## Expected Build Output

### Successful Build
```
BUILD SUCCESSFUL in 1m 23s
45 actionable tasks: 45 executed
```

### Build with Warnings
```
BUILD SUCCESSFUL in 1m 45s
45 actionable tasks: 45 executed

Note: Some input files use or override a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```

---

## Post-Build Verification

### Check APK Integrity
```bash
# View APK contents
unzip -l app/build/outputs/apk/debug/app-debug.apk

# Check APK size
ls -lh app/build/outputs/apk/debug/app-debug.apk
```

### Install and Test
```bash
# Install
adb install app/build/outputs/apk/debug/app-debug.apk

# Launch
adb shell am start -n com.strivesync.health/.MainActivity

# Check logs
adb logcat -s StriveSync
```

---

## Build Success Indicators

✅ Gradle sync completes without errors  
✅ Compilation succeeds for both modules  
✅ No critical lint errors  
✅ APK files generated successfully  
✅ APKs install on device/emulator  
✅ Apps launch without crash  
✅ No memory leaks detected  

---

## Support

For build issues:
1. Check [SETUP.md](SETUP.md) troubleshooting section
2. Review Gradle build output
3. Verify all dependencies are available
4. Check Android Studio build logs
5. Ensure proper SDK versions installed

---

**Last Updated**: 2024  
**Build System**: Gradle 8.2 with Kotlin DSL  
**CI Ready**: Yes  
**Production Ready**: Foundation (needs backend)

