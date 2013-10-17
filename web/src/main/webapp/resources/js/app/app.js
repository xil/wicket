/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 26.09.12
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */

define([
//    Base modules
    "dojo/_base/declare",
    "dojo/_base/lang",
    "require",
//    login and user page controllers
    "controllers/main/MainController"
    //,
//    ready!
//    "dojo/ready"
], function (declare, lang, require, MainController) {
    return declare("app", null, {
//        loginController: null,
//        userPageController: null,

        mainController: null,
        applicationContext: null,

        constructor: function () {

        },
        init: function () {
            this.mainController = new MainController({app: this});
            this.mainController.init();

            this.initErrorHandler();
        },

        handleError: function (error) {
            console.log(error.src, error.id);
        },

        initErrorHandler: function () {
            require.on("error", function (error) {
                console.log(error.src, error.id);
            });
        }
    });
})
;