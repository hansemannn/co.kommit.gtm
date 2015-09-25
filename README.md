[![gitTio](http://gitt.io/badge.svg)](http://gitt.io/component/co.kommit.gtm)
[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/kommitters/co.kommit.gtm?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

# Kommit Google Tag Manager Module

## Description

Connects to Google Tag Manager for dynamic tag management. v0.0.1

## Set up Google Tag Manager

Create a container in [http://www.google.com/tagmanager/](http://www.google.com/tagmanager/)

For more information [http://www.google.com/tagmanager/get-started.html](http://www.google.com/tagmanager/get-started.html)

### Default container Data

**For Android**

```
platform
└── android
    └── res
        └── raw
            ├── GTM_XYZZY_binary
            └── GTM_XYZZY_json
```

**For iOS**

```
platform
└── iphone
    ├── GTM-XXXX.json <--- JSON
    └── GTM-XXXX.plist <--- Binary
```

## Accessing the gtm Module

To access this module from JavaScript, you would do the following:

```
var GTM = require("co.kommit.gtm");
GTM.init("GTM-XXXX");
```

The gtm variable is a reference to the Module object.

## Reference

## Container methods

### GTM.getString(key)

Returns a string representing the configuration value for the given key.

### GTM.getBoolean(key)

Returns a boolean representing the configuration value for the given key.

### GTM.getLong(key)

Returns a Number representing the configuration value for the given key.

### GTM.getDouble(key)

Returns a Number representing the configuration value for the given key.

### GTM.getLastRefreshtTime()

Returns a Number with the last time (in milliseconds since midnight, January 1, 1970 UTC) that this container was refreshed from the network.


## Data layer methods

### GTM.pushObject(object)

```
GTM.pushObject({"event", "click", "buttonName", "playMovie"});
```

### GTM.pushValue(key, object)

```
GTM.pushValue("foo", {"bar": "baz"});
```

## Usage

**Opening a window/screen**

```
$.mainScreen.addEventListener("open", function () {
   GTM.pushObject({"event": "openScreen", "screenName": "mainScreen"});
});
```

**Click event**

```
$.myButton.addEventListener("click", function () {
    GTM.pushObject({"event": "click", "buttonName": "refresh"});
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

## TODO

- Support for multiple containers
- Container preview
- Callbacks
- Port of `<android-sdk-directory>/extras/google/google_play_services/tagmanager/cuteanimals`

## Recomendations

- Download container data from your Tag Manager account

## Example Application

```
cd example
ti build -p ios
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

## Feel free to comment and help out! :)
