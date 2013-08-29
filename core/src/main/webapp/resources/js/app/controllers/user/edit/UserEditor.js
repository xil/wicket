/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 21:06
 */
define([
    "dojo/_base/declare", "dojo/_base/lang", 'dojo/when',

    "controllers/common/AbstractController",

    "./UserEditorView", "dojo/store/JsonRest", "dojo/data/ItemFileReadStore"
    , "dojox/mvc/EditStoreRefController", "dojox/mvc/getPlainValue", "dojox/mvc/getStateful"
], function (declare, lang, when, AbstractController, UserEditorView, JsonRest, ItemFileReadStore, EditStoreRefController, getPlainValue, getStateful) {
    return declare("controllers.user.UserBrowser", [AbstractController, EditStoreRefController], {

        _viewTemplateString: "ws/rest/user/editTemplate",
        currentTab: null,
        view: null,
        itemId: null,

        init: function () {
            this.holdModelUntilCommit = true;
            this.store = new JsonRest({target: "ws/rest/user/"});

            if (!this.itemId) {
                var item = getStateful({firstname: "", middlename: "", lastname: ""});
                this.set(this._refSourceModelProp, item);
                this._openView();
            } else {
                when(this.getStore(this.itemId), lang.hitch(this, function () {
                    this._openView();
                }));
            }
            this._addListeners();
        },
        _openView: function () {
            this.view = new UserEditorView(this._getViewParams());
            var view = this.view;
            view.startup();
            view.show();
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
                contentParams: {
                    currentTab: self.currentTab,
                    app: this.app,
                    templateString: self._getTemplateString(),
                    viewStore: viewStore,
                    ctrl: self,
                    style: {}
                }
            };
            return params;
        }

    });
})
;