/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 26.09.12
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */

define([
//    Base modules
    "dojo/_base/declare", "dojo/_base/lang",
//    login and user page controllers
    "controllers/main/MainController"
    //,
//    ready!
//    "dojo/ready"
], function (declare, lang, MainController) {
    return declare("app", null, {
//        loginController: null,
//        userPageController: null,

        mainController: null,
        applicationContext: null,

        constructor: function () {
            this.mainController = new MainController({app: this});
            this.mainController.init();
        },
        init: function () {

        },
        initErrorHandler: function() {

        }
    });
})
;