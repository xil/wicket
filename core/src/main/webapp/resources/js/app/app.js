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

//            this.loginController = new LoginController();
//
//            if (!this._checkAuth()) {
//                this.loginController.init();
//                this.loginController.on("loginSuccess", lang.hitch(this, function () {
//                    this._loginSuccess();
//                }));
//            } else {
//                this._loginSuccess();
//            }
        },
        init: function () {

        },

        _checkAuth: function () {
//TODO check auth
            return false;
        },
        _loginSuccess: function () {
//            this.userPageController = new UserPageController({});
//            this.userPageController.init();
        },

        _loadingAppContext: function() {

        }
    });
})
;