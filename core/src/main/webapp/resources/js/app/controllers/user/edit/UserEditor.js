/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 21:06
 */
define([
    "dojo/_base/declare", "dojo/_base/lang", 'dojo/when',

    "controllers/common/AbstractController",

    "./UserEditorView", "dojox/data/JsonRestStore", "dojo/data/ItemFileReadStore"
    , "dojox/mvc/EditStoreRefController"
], function (declare, lang, when, AbstractController, UserEditorView, JsonRestStore, ItemFileReadStore, EditStoreRefController) {
    return declare("controllers.user.UserBrowser", [AbstractController, EditStoreRefController], {

        _viewTemplateString: "ws/rest/user/editTemplate",
        currentTab: null,
        view: null,

        init: function () {
            this.store = new JsonRestStore({target: "/ws/rest/user/1"});
            this.holdModelUntilCommit = true;

            when(this.queryStore(), lang.hitch(this, function () {
                this.view = new UserEditorView(this._getViewParams());
                var view = this.view;
                this.currentTab.addChild(view);
                view.startup();
                view.show();
            }));


//            this.queryStore();
//
//            when(this.storeController.queryStore(), function () {
//                this.view.startup();
//            });
            this._addListeners();
        },
        _addListeners: function () {
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
                viewStore: viewStore,
                ctrl: self,
                style: {}

            };
            return params;
        }

    });
});