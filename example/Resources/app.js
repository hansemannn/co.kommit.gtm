var window = Titanium.UI.createWindow({
        "backgroundColor": "#FFFFFF"
    }),
    GTM = require("co.kommit.gtm");

GTM.init("GTM-XXXX");

window.addEventListener("open", function () {
    GTM.pushObject({"event": "openScreen", "screenName": "mainScreen"});
});

window.addEventListener("close", function () {
    GTM.pushObject({"event": "closeScreen", "screenName": "mainScreen"});
});

var button = Titanium.UI.createButton({
    "title": "Play",
    "width": 100,
    "height": 50
});

button.addEventListener("click", function () {
    GTM.pushObject({"event": "click", "buttonName": "Play"});
});

window.add(button);

window.open();
