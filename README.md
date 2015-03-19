# Google Tag Manager Module

## Description

Connects to Google Tag Manager for dynamic tag management.

## Set up Google Tag Manager

Create a container in [http://www.google.com/tagmanager/](http://www.google.com/tagmanager/)

For more information [http://www.google.com/tagmanager/get-started.html](http://www.google.com/tagmanager/get-started.html)

## Accessing the gtm Module

To access this module from JavaScript, you would do the following:

```
var gtm = require("co.kommit.gtm");
gtm.init("UA-1234567-8");
```

The gtm variable is a reference to the Module object.

## Reference

## Container methods

Android API for more information [https://developer.android.com/reference/com/google/android/gms/tagmanager/Container.html](https://developer.android.com/reference/com/google/android/gms/tagmanager/Container.html)

### gtm.getString(key)

Returns a string representing the configuration value for the given key.

### gtm.getBoolean(key)

Returns a boolean representing the configuration value for the given key.

### gtm.getLong(key)

Returns a Number representing the configuration value for the given key.

### gtm.getDouble(key)

Returns a Number representing the configuration value for the given key.

### gtm.getLastRefreshtTime(key)

Returns a Number with the last time (in milliseconds since midnight, January 1, 1970 UTC) that this container was refreshed from the network.


### gtm.isDefault()

Returns a boolean whether this is a default container, or one refreshed from the server.


## Data layer methods

Android API for more information [https://developer.android.com/reference/com/google/android/gms/tagmanager/DataLayer.html](https://developer.android.com/reference/com/google/android/gms/tagmanager/DataLayer.html)

### gtm.mapOf(args)

```
gtm.mapOf("key1", "value1", "key2", "value2");
gtm.mapOf("event", "click", "buttonName", "playMovie");
```

### gtm.listOf([])

```
gtm.listOf("value1", "value2", "value3", "value4")
```


### gtm.pushObject(object)

```
gtm.pushObject(gtm.mapOf("event", "click", "buttonName", "playMovie"));
gtm.pushObject(gtm.mapOf("title", "New screen title"));

```

### gtm.pushKeyValue(key, value)

```
gtm.pushKeyValue("items", gtm.mapOf("key1", "value1", "key2", "value2"));
gtm.pushKeyValue("items", gtm.listOf("value1", "value2", "value3", "value4"));
```


### gtm.openScreenEvent(screenTitle)

```
gtm.openScreen("mainScreen")
```

### gtm.closeScreenEvent(screenTitle)

```
gtm.closeScreen("mainScreen")
```

## Usage

**Opening a window/screen**

```
$.mainScreen.addEventListener("open", function () {
    gtm.openScreenEvent("mainScreen");
});
```

**Closing a window/screen**

```
$.mainScreen.addEventListener("close", function () {
    gtm.closeScreenEvent("mainScreen");
});
```

**Click event**

```
$.myButton.addEventListener("click", function () {
    gtm.pushObject(gtm.mapOf("event", "click", "buttonName", "My Button Name"));
});
```

## Build from source

### Android

```
export ANDROID_SDK="/Path/to/Android/SDK"
export TITANIUM_SDK="/Users/somebody/Library/Application Support/Titanium/mobilesdk/osx/3.4.1.GA"
export ANDROID_NDK="/Path/to/Android/NDK"
cd android && ant
```

#### iOS

```
cd iphone && python build.py
```


## License

The MIT License (MIT)

Copyright (c) 2015 Kommit.co

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.


