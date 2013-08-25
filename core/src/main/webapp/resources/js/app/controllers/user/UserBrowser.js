/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 21:06
 */
define([
    "dojo/_base/declare", "dojo/_base/lang",

    "controllers/common/AbstractController",

    "views/user/UserBrowserView", "dojo/store/JsonRest", "dojo/data/ItemFileReadStore"    ,
    "controllers/user/edit/UserEditor"
], function (declare, lang, AbstractController, UserBrowserView, JsonRest, ItemFileReadStore, UserEditor) {
    return declare("controllers.user.UserBrowser", [AbstractController], {

        _viewTemplateString: "ws/rest/user/template",
        currentTab: null,
        userStore: null,
        view: null,

        init: function () {
            this._initUserStore();

//            TODO rework it!
            this.view = new UserBrowserView(this._getViewParams());
            this.currentTab.addChild(this.view);
            this.view.startup();
            this._addListeners();
        },
        _addListeners: function () {
            this.view.on("create", lang.hitch(this, function (params) {
                var editor = new UserEditor({});
                editor.init();
            }));
//            this.mainPane.on("clickMenuBarItem_logout", function () {
//                window.location.href = "/logout";
//            });
        },
        _getViewParams: function () {
            var self = this;

            var storeParams = {
                url: "ws/rest/user/list"
            };
            var viewStore = new ItemFileReadStore(storeParams);
            var params = {
                currentTab: self.currentTab,
                app: this.app,
                templateString: self._getTemplateString(),
                viewStore: viewStore
            };
            return params;
        },
        _initUserStore: function () {

        }

    });
});