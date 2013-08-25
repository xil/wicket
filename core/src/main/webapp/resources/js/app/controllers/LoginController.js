/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 16.10.12
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 */

define([
    "dojo/_base/declare", "dojo/_base/lang", "dojo/Evented", "dojo/_base/Deferred",

    "views/login/LoginDialog"
], function (declare, lang, Evented, Deferred, LoginDialog) {
    return declare([Evented], {
        loginData:{
            "user":"user",
            "Vasja":"Ivanov",
            "qwerty":"123456"
        },

        constructor:function () {

        },
        init:function () {
            this.dialog = new LoginDialog({controller:this});
            this.dialog.startup();
            this.dialog.show();

            this.dialog.on("success", lang.hitch(this, function (username) {
                this.dialog.hide();
                this.emit("loginSuccess", username);
            }));

        },

        login:function (data) {
            var def = new Deferred();
            setTimeout(lang.hitch(this, function () {
//                do xhr to server
                def.resolve(this.loginData[data.username] && this.loginData[data.username] == data.password);
            }), 1000);
            return def;
        }
    });
});
