# Google Tag Manager Module

## Description

Connects to Google Tag Manager for dynamic tag management.

## Set up Google Tag Manager

Create a container in [http://www.google.com/tagmanager/](http://www.google.com/tagmanager/)

For more information [http://www.google.com/tagmanager/get-started.html](http://www.google.com/tagmanager/get-started.html)

## Accessing the gtm Module

To access this module from JavaScript, you would do the following:

```
var GTM = require("co.kommit.gtm");
GTM.init("UA-1234567-8");
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

### GTM.getLastRefreshtTime(key)

Returns a Number with the last time (in milliseconds since midnight, January 1, 1970 UTC) that this container was refreshed from the network.

### GTM.isDefault()

Returns a boolean whether this is a default container, or one refreshed from the server.


## Data layer methods


### GTM.pushObject(object)

```
GTM.pushObject({"event", "click", "buttonName", "playMovie"});
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
- Add default container data


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


