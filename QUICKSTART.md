# StriveSync - Quick Start Guide

**Get up and running in 10 minutes!** ⚡

## Prerequisites Checklist

Before you begin, ensure you have:
- [ ] Android Studio (Electric Eel or newer) installed
- [ ] Java JDK 11+ installed
- [ ] At least 8GB RAM available
- [ ] 8GB free disk space
- [ ] Internet connection for dependencies

## 🚀 5-Minute Setup

### Step 1: Open Project (1 minute)
```bash
# Navigate to the project
cd mobile-test

# Open in Android Studio
# Or: File → Open → Select mobile-test folder
```

### Step 2: Wait for Gradle Sync (3-5 minutes)
- Android Studio will automatically download dependencies
- Watch the progress bar at the bottom
- ☕ Grab a coffee while it syncs!

### Step 3: Run Mobile App (1 minute)
1. Select **"app"** from the run configuration dropdown
2. Click the green Run button (▶️)
3. Choose your device/emulator
4. Wait for installation

### Step 4: Run Watch App (1 minute)
1. Select **"wear"** from the run configuration dropdown
2. Click the green Run button (▶️)
3. Choose Wear OS emulator
4. Wait for installation

**Done! 🎉** Both apps should now be running!

---

## 📱 What to Test First

### On Mobile App:

#### 1. Dashboard (Main Screen)
```
✓ View health status card
✓ Check heart rate: 72 BPM
✓ Check steps: 8,542 steps
✓ Scroll through quick actions
✓ Click Emergency SOS (don't confirm!)
```

#### 2. Health Check Tab
```
✓ Tap "Health Check" in bottom nav
✓ View vital signs card
✓ Switch tabs: Overview → Heart → Activity → Sleep
✓ Check activity progress bars
```

#### 3. AI Advice Tab
```
✓ Tap "AI Advice" in bottom nav
✓ Try a quick prompt card
✓ Type a message: "I have a headache"
✓ Send message and see AI response
```

#### 4. Profile Tab
```
✓ Tap "Profile" in bottom nav
✓ View user stats: Age 32, Height 175cm
✓ Scroll through settings options
✓ Check "Import AI Tokens" card
```

### On Watch App:

#### 1. Home Screen
```
✓ See health status: Excellent
✓ View heart rate: 72 BPM
✓ View steps: 8,542
✓ Scroll with rotary or swipe
```

#### 2. Heart Rate Monitor
```
✓ Tap heart rate card
✓ See current BPM display
✓ Tap "Start Monitoring"
✓ Watch BPM change in real-time
✓ Tap "Stop" to end
```

#### 3. Activity Screen
```
✓ Tap steps card
✓ See step count: 8,542
✓ Check progress bar: 85%
✓ View other metrics (calories, active time)
```

#### 4. Emergency Screen (BE CAREFUL!)
```
✓ Tap "Emergency SOS" chip
✓ See 5-second countdown
✓ IMMEDIATELY tap "Cancel"
✓ View emergency contacts
```

---

## 🎨 Customization Quick Tips

### Change App Colors
Edit: `app/src/main/java/com/strivesync/health/ui/theme/Color.kt`
```kotlin
// Change primary color from blue to green
val PrimaryBlue = Color(0xFF10B981)  // Now green!
```

### Change App Name
Edit: `app/src/main/res/values/strings.xml`
```xml
<string name="app_name">MyHealthApp</string>
```

### Modify Health Data
Edit: `app/src/main/java/com/strivesync/health/ui/screens/DashboardScreen.kt`
```kotlin
// Line ~85 - Change heart rate
value = "85",  // Was 72
```

### Add New Screen
1. Create new file: `YourScreen.kt` in `ui/screens/`
2. Add route in `AppNavigation.kt`
3. Add navigation item
4. Done!

---

## 🐛 Common Issues & Quick Fixes

### Issue: Gradle Sync Failed
```bash
# Quick fix:
./gradlew clean
./gradlew build
```

### Issue: Emulator Won't Start
```bash
# Check virtualization is enabled
# Windows: Enable Hyper-V or WHPX
# Mac: Should work by default
# Linux: Install KVM
```

### Issue: App Won't Install
```bash
# Uninstall existing app
adb uninstall com.strivesync.health

# Clear cache and retry
./gradlew clean
```

### Issue: Out of Memory
Edit `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx4096m
```

---

## 📚 File Locations Quick Reference

```
Key Files You'll Edit Often:
├── DashboardScreen.kt       → app/src/main/java/.../ui/screens/
├── Color.kt                 → app/src/main/java/.../ui/theme/
├── strings.xml              → app/src/main/res/values/
├── AndroidManifest.xml      → app/src/main/
└── build.gradle.kts         → app/
```

---

## 🔥 Pro Tips

### 1. Use Hot Reload
After making UI changes:
- Press `Ctrl+F10` (Windows/Linux)
- Press `Cmd+F10` (Mac)
- Or click the ⚡ icon
- Changes appear instantly!

### 2. View Logs
```
Android Studio → Logcat
Filter: "StriveSync"
```

### 3. Keyboard Shortcuts
```
Ctrl/Cmd + B      → Go to definition
Ctrl/Cmd + /      → Comment/uncomment
Ctrl/Cmd + D      → Duplicate line
Ctrl/Cmd + Space  → Auto-complete
```

### 4. Quick Navigation
```
Double Shift      → Search anywhere
Ctrl/Cmd + N      → Find class
Ctrl/Cmd + E      → Recent files
```

---

## 📖 Further Reading

Once you're comfortable with the basics:

1. **[README.md](README.md)** - Complete project documentation
2. **[SETUP.md](SETUP.md)** - Detailed setup instructions
3. **[PROJECT_OVERVIEW.md](PROJECT_OVERVIEW.md)** - Technical details

---

## 🎯 Your First Task

**Challenge**: Change the heart rate from 72 to your age!

1. Open `DashboardScreen.kt`
2. Find line with `value = "72"`
3. Change to your age
4. Press ⚡ to apply changes
5. See it update instantly!

**Bonus**: Change the color too!
```kotlin
color = Color(0xFFYOURCOLOR)
```

---

## 💡 What's Next?

After you're comfortable:
- [ ] Add a new health metric card
- [ ] Change the theme colors
- [ ] Create a new screen
- [ ] Add a new quick action
- [ ] Connect to a real API
- [ ] Add backend integration
- [ ] Write some tests

---

## 🆘 Need Help?

### Check These First:
1. Gradle sync completed? (check bottom of Android Studio)
2. Correct module selected? (app or wear in dropdown)
3. Emulator running? (check Device Manager)
4. Internet connection? (for dependency download)

### Error Messages:
- Read carefully - they're usually helpful!
- Google the exact error message
- Check Stack Overflow

### Still Stuck?
- Review [SETUP.md](SETUP.md) troubleshooting section
- Check Android Studio build output
- Verify all prerequisites are met

---

## 🎉 Success Checklist

You're ready when you can:
- [x] Build the project without errors
- [x] Run mobile app on emulator
- [x] Run watch app on Wear OS emulator
- [x] Navigate between all screens
- [x] See health metrics displayed
- [x] Interact with the AI chat
- [x] Make a simple code change

**Congratulations!** 🎊 You're all set up!

---

## ⏱️ Time Estimate

| Task | Time |
|------|------|
| Initial Gradle sync | 3-5 min |
| First mobile build | 2-3 min |
| First watch build | 2-3 min |
| Testing features | 5-10 min |
| **Total** | **15-20 min** |

*Subsequent builds are much faster (seconds)!*

---

## 🚀 Ready to Code?

```kotlin
fun startCoding() {
    println("Let's build something amazing! 🚀")
    
    // Your journey begins here...
    createHealthApp()
    changeTheWorld()
}
```

**Happy Coding!** 💻✨

---

*For detailed documentation, see [README.md](README.md)*  
*For setup issues, see [SETUP.md](SETUP.md)*  
*For technical details, see [PROJECT_OVERVIEW.md](PROJECT_OVERVIEW.md)*

