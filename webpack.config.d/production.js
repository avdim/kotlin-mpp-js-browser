(function () {
    var path = require('path');
    config.entry = [path.resolve(__dirname, "../../../../build/kotlin-js-min/js/main/some-app.js")];
    config.resolve.modules.push(path.resolve(__dirname, "../../../../build/kotlin-js-min/js/main"));
    config.mode = "production";
})();