var window = Titanium.UI.createWindow(),
    GTM = require("co.kommit.gtm");

GTM.init("UA-1234567-8");


window.addEventListener("open", function () {
    GTM.pushObject({"event": "openScreen", "screenName": "mainScreen"});
});

window.addEventListener("close", function () {
    GTM.pushObject({"event": "closeScreen", "screenName": "mainScreen"});
});

var button = Titanium.UI.createButton({
    "title": "Play",
    "top": 10,
    "width": 100,
    "height": 50
});

button.addEventListener("click", function () {
    GTM.pushObject({"event": "click", "buttonName": "Play"});
});

window.open();
