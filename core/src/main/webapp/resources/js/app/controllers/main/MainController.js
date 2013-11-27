define([
    "dojo/_base/declare", "dojo/_base/lang", "dojo/Evented", "dojo/_base/Deferred", "dojo/_base/xhr",
    "dojo/i18n!nls/messages",

    "views/main/MainPane"
], function (declare, lang, Evented, Deferred, xhr, messages, MainPane) {
    return declare([Evented], {

        viewTemplateString: "",


        constructor: function (options) {
            lang.mixin(this, options);
        },
        init: function () {
            this.mainPane = new MainPane(this._getViewParams(), "container");
            this.mainPane.init();
            this._addListeners();

            this.mainPane.startup();
        },
        _addListeners: function () {
            var self = this;
            this.mainPane.on("clickMenuBarItem_logout", function () {
                window.location.href = "logout";
            });
            this.mainPane.on("clickMenuBarItem_users", lang.hitch(this, function () {
                require(["controllers/user/browse/UserBrowser"], function (UserBrowser) {
                    var currentTab = self.mainPane.addTab(messages.userBrowser_caption, "usersBrowser");
                    if (currentTab) {
                        var usersController = new UserBrowser({currentTab: currentTab});
                        usersController.init();
                    }
                });
            }));
            this.mainPane.on("clickMenuBarItem_idents", lang.hitch(this, function () {
                var currentTab = self.mainPane.addTab(messages.userBrowser_identifications, "identifications");

            }));
            this.mainPane.on("clickMenuBarItem_wicket", lang.hitch(this, function () {
                var currentTab = self.mainPane.addTab(messages.userBrowser_wicket, "wicket");
            }));
        },
        _getViewParams: function () {
            var params = {
                app: this.app,
                templateString: this._getTemplateString()
            };
            return params;
        },
        _getTemplateString: function () {
            var template;
            var xhrArgs = {
                url: "app/mainTemplate",
                handleAs: "text",
                sync: true,
                preventCache: true,
                load: function (data) {
                    template = data;
                },
                error: function () {
//                    TODO show '((('-dialog
                }
            };
//            TODO: do asinc this
            dojo.xhrGet(xhrArgs);
            return template;
        }
    });
});