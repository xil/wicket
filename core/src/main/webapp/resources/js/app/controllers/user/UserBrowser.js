/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 21:06
 */
define([
    "dojo/_base/declare", "dojo/_base/lang",

    "controllers/common/AbstractController",

    "views/user/UserBrowserView", "dojo/store/JsonRest", "dojo/data/ObjectStore"    ,
    "controllers/user/edit/UserEditor"
], function (declare, lang, AbstractController, UserBrowserView, JsonRest, ObjectStore, UserEditor) {
    return declare("controllers.user.UserBrowser", [AbstractController], {

        _viewTemplateString: "ws/rest/user/template",
        currentTab: null,
        userStore: null,
        view: null,

        init: function () {
//            TODO rework it!
            this.view = new UserBrowserView(this._getViewParams());
            this.view.placeAt(this.currentTab);
            this.view.startup();
            this._addListeners();
        },
        _addListeners: function () {
            var self = this;
            this.view.on("create", lang.hitch(this, function (params) {
                this._openEditor(null);
            }));
            this.view.on("edit", lang.hitch(this, function (params) {
                var selectedId = this.view.selectedRowId;
                if (undefined != selectedId) {
                    this._openEditor(this.view.getSelectedId(selectedId));
                }
            }));
//            this._addListener("remove", function(params) {
//                var selectedId = this.view.selectedRowId;
//                if (!selectedId) {
//                  self.userStore.deleteItem();
//                }
//            });
            this.view.on("remove", lang.hitch(this, function (params) {
                var selectedId = this.view.selectedRowId;
                if (undefined != selectedId) {
//                    TODO
                    self.userStore.deleteItem(this.view.getSelectedItem());
                    self.userStore.save();
                }
//                TODO add refreshing
            }));
            this.view.on("refresh", lang.hitch(this, function (params) {
                this._refreshStore();
            }));
        },
        _addListener: function (eventName, func) {
            this.view.on(eventName, lang.hitch(this, func(params)));

        },
        _openEditor: function (itemId) {
            var editor = new UserEditor({itemId: itemId});
            editor.init();
            var self = this;
            editor.on("commitAction", function (params) {
                self._refreshStore();
            });
        },
        _getViewParams: function () {
            var self = this;

            var storeParams = {
//                url: "ws/rest/user/list"
                target: "ws/rest/user/", idProperty: "id"
            };
//            TODO replace to JsonRestStore
            var restUserStore = this.restUserStore = new JsonRest(storeParams);
            var viewStore = this.userStore = new ObjectStore({objectStore: restUserStore});
            var params = {
                currentTab: self.currentTab,
                app: this.app,
                templateString: self._getTemplateString(),
                viewStore: viewStore
            };
            return params;
        },
//        TODO rework it
        _refreshStore: function () {
//            var storeParams = {
//            url: "ws/rest/user/list"
//                target: "ws/rest/user/list", idAttribute: "id"
//            };
            var self = this;
            var restUserStore = this.restUserStore;
            var viewStore = this.userStore = new ObjectStore({objectStore: restUserStore});
            var refresh = function () {
                self._refreshStore();
            }
//            dojo.connect(viewStore, "onDelete", refresh);
            this.view.usersGrid.setStore(viewStore, "/list");
        }

    });
})
;